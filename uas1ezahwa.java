import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class uas1ezahwa {
    public static void main(String[] args) {
        // Inisialisasi kapasitas stok
        int[] kapasitasStok = {2000, 2500, 1700, 2800};

        // Inisialisasi ArrayList untuk menyimpan penjualan masing-masing bahan bakar
        ArrayList<Integer> penjualanPertalite = new ArrayList<>();
        ArrayList<Integer> penjualanPertamax = new ArrayList<>();
        ArrayList<Integer> penjualanPertamaxTurbo = new ArrayList<>();
        ArrayList<Integer> penjualanPertadex = new ArrayList<>();

        // Looping selama 8 jam (pukul 8 - 16)
        for (int jam = 8; jam <= 16; jam++) {
            // Generate jumlah penjualan setiap 3 detik
            int jumlahPenjualan = ThreadLocalRandom.current().nextInt(0,51);

            // Cek apakah stok masih cukup
            if (kapasitasStok[0] - jumlahPenjualan >= 0) {
                penjualanPertalite.add(jumlahPenjualan);
                kapasitasStok[0] -= jumlahPenjualan;
            }

            jumlahPenjualan = ThreadLocalRandom.current().nextInt(0, 51);
            if (kapasitasStok[1] - jumlahPenjualan >= 0) {
                penjualanPertamax.add(jumlahPenjualan);
                kapasitasStok[1] -= jumlahPenjualan;
            }

            jumlahPenjualan = ThreadLocalRandom.current().nextInt(0, 51);
            if (kapasitasStok[2] - jumlahPenjualan >= 0) {
                penjualanPertamaxTurbo.add(jumlahPenjualan);
                kapasitasStok[2] -= jumlahPenjualan;
            }

            jumlahPenjualan = ThreadLocalRandom.current().nextInt(0, 51);
            if (kapasitasStok[3] - jumlahPenjualan >=0) {
                penjualanPertadex.add(jumlahPenjualan);
                kapasitasStok[3] -= jumlahPenjualan;
            }

            // Tampilkan detail penjualan setiap 3 detik
            if (jam % 3 == 0) {
                System.out.println("Penjualan pukul " + jam + ":");
                System.out.println("Pertalite: " + penjualanPertalite);
                System.out.println("Pertamax: " + penjualanPertamax);
                System.out.println("Pertamax Turbo: " + penjualanPertamaxTurbo);
                System.out.println("Pertadex: " + penjualanPertadex);
                System.out.println("Total penjualan: " +(penjualanPertalite.stream().mapToInt(Integer::intValue).sum() +
                        penjualanPertamax.stream().mapToInt(Integer::intValue).sum() +
                        penjualanPertamaxTurbo.stream().mapToInt(Integer::intValue).sum() +
                        penjualanPertadex.stream().mapToInt(Integer::intValue).sum()) +
                        " kg");
                System.out.println("Sisa stok: ");
                System.out.println("Pertalite: " + kapasitasStok[0] + " kg");
                System.out.println("Pertamax: " + kapasitasStok[1] + " kg");
                System.out.println("Pertamax Turbo: " + kapasitasStok[2] + " kg");
                System.out.println("Pertadex: " + kapasitasStok[3] + " kg");
                System.out.println("------------------------------------");

            }
        }
    }
}
