// Nama : Fafa Febriansa
// Kelas: 1B
// Absen: 10
import java.util.Scanner;
public class CM2Beasiswa10 {
    static Scanner sc = new Scanner(System.in);
    // Kapasitas maksimal 100
    // kolom: 0=Nama, 1=NIM, 2=IPK, 3=jenis, 4=penghasilan
    static String[][] data = new String[100][5];
    static int jml = 0;
    // untuk fungsi menampilkan menu
    public static void menu() {
        System.out.println();
        System.out.println("=== Sistem Pendaftaran Beasiswa ===");
        System.out.println("1. Tambah Data Pendaftar Beasiswa");
        System.out.println("2. Tampilkan Semua Pendaftar");
        System.out.println("3. Cari Pendaftar berdasarkan Jenis Beasiswa");
        System.out.println("4. Hitung Rata-rata IPK per Jenis Beasiswa");
        System.out.println("5. Keluar");
        System.out.print("Pilih menu (1-5): ");
    }
    
    // untuk fungsi menambahkan data
    public static void tambahData() {
        System.out.print("Nama Mahasiswa: ");
        data[jml][0] = sc.nextLine();
        System.out.print("NIM: ");
        data[jml][1] = sc.nextLine();
        System.out.print("IPK Terakhir: ");
        data[jml][2] = sc.nextLine();
        System.out.print("Jenis Beasiswa (Reguler/Unggulan/Riset): ");
        data[jml][3] = sc.nextLine();
        System.out.print("Penghasilan Orang Tua (maksimal Rp 2.000.000): ");
        String penghasilanStr = sc.nextLine();
        int penghasilan = Integer.parseInt(penghasilanStr);
        data[jml][4] = String.valueOf(penghasilan);

        // mengecek validasi jenis beasiswa
        if (!(data[jml][3].equalsIgnoreCase("Reguler") ||
            data[jml][3].equalsIgnoreCase("Unggulan") || 
            data[jml][3].equalsIgnoreCase("Riset"))) {
                System.out.println("Jenis beasiswa tidak valid.");
                return;
            }
    
        // mengecek validasi jumlah penghasilan
        if (penghasilan>2000000) {
            System.out.println("Pendaftaran dibatalkan karena penghasilan melebihi batas maksimal.");
            return;
        }

        jml++;
        System.out.println("Pendaftar berhasil disimpan. Total pendaftar:"+jml);
    } 

    // untuk fungsi menampilkan para pendaftar
    public static void tampilData() {
        if (jml == 0) {
            System.out.println("Belum ada pendaftar.");
            return;
        }
        System.out.printf("%-20s %-20s %-20s %-20s %-20s\n", "Nama","NIM","IPK","Jenis","Penghasilan");
        for (int i = 0; i <jml; i++) {
            System.out.printf("%-20s %-20s %-20s %-20s %-20s\n",data[i][0],data[i][1],data[i][2],data[i][3],data[i][4]);
        }
    }

    // untuk fungsi menampilkan pendaftar sesuai jenis beasiswa  
    public static void cari() {
        System.out.print("Masukkan jenis beasiswa: ");
        String jenis = sc.nextLine();
        boolean ada = false;
        for (int i = 0; i < jml; i++) {
            if (data[i][3].equalsIgnoreCase(jenis)) {
                System.out.println(data[i][0]+" - "+data[i][1]+" - IPK: "+data[i][2]);
                ada = true;
            }
        }
        if (!ada) {System.out.println("Tidak ada pendaftar untuk jenis "+jenis);}
    }

    // untuk fungsi menghitung rata rata
    public static void hitungRata() {
        String[] jenisList = {"Reguler", "Unggulan", "Riset"};
        for (String j:jenisList) {
            double total = 0; int count = 0;
            for (int i = 0; i <jml; i++) {
                if (data[i][3].equalsIgnoreCase(j)) {
                    total+= Double.parseDouble(data[i][2]);
                    count++;
                }
            }
            if (count == 0) {
                System.out.println(j+": tidak ada pendaftar.");
            } else {
                System.out.println(j+": Rata-rata IPK = "+(total/count));
            }
        }
    }
    
    // fungsi main
    public static void main(String[] args) {

        while (true) {
            menu();
            int pilihan =sc.nextInt(); sc.nextLine();
            switch (pilihan) {
                case 1: tambahData(); break;
                case 2: tampilData(); break;
                case 3: cari(); break;
                case 4: hitungRata(); break;
                case 5: System.out.println("Keluar...");return;
                default: System.out.println("Pilihan tidak valid.");
            }
        }
    }
} 