import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        int tabungan = 50000, tarik, setor;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n======= [ Mesin ATM ] =======");
            System.out.println("[ 1. Penarikan               ]");
            System.out.println("[ 2. Setor Uang              ]");
            System.out.println("[ 3. Cek Isi Tabungan        ]");
            System.out.println("[ 4. Keluar                  ]");
            System.out.println("==============================");
            System.out.print("> Pilih nomor yang ingin ditampilkan: ");

            if (!sc.hasNextInt()) {
                System.out.println("Input tidak valid. Silahkan masukkan nomor pilihan yang benar.");
                sc.next(); 
                continue;
            }

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("> Masukkan nominal penarikan: Rp.");
                    if (!sc.hasNextInt()) {
                        System.out.println("Input tidak valid. Silahkan masukkan nominal penarikan yang benar.");
                        sc.next(); 
                        continue;
                    }
                    tarik = sc.nextInt();

                    if (tarik <= 0) {
                        System.out.println("Nominal penarikan harus lebih dari 0.");
                    } else if (tabungan >= tarik) {
                        tabungan -= tarik;
                        System.out.println("\nPenarikan berhasil. Silahkan ambil uang anda.");
                    } else {
                        System.out.println("\n(!) Saldo tidak mencukupi.");
                    }
                    break;

                case 2:
                    System.out.print("> Masukkan nominal uang: Rp.");
                    if (!sc.hasNextInt()) {
                        System.out.println("\n(!) Input tidak valid. Silahkan masukkan nominal setor yang benar.");
                        sc.next();
                        continue;
                    }
                    setor = sc.nextInt();

                    if (setor <= 0) {
                        System.out.println("\n(!) Nominal setor harus lebih dari 0.");
                    } else {
                        tabungan += setor;
                        System.out.println("\nSetor uang telah berhasil.");
                    }
                    break;

                case 3:
                    System.out.println("> Saldo tabungan anda: Rp." + tabungan);
                    break;

                case 4:
                    System.out.println("\nTerima kasih telah menggunakan layanan kami.");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("\n(!) Pilihan anda salah. Silahkan pilih nomor antara 1-4.");
            }
        }
    }
}