import java.util.Arrays;
import java.util.Scanner;

public class soal003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int H = sc.nextInt();
        int[] lompatan = new int[N];

        for (int i = 0; i < N; i++) {
            lompatan[i] = sc.nextInt();
        }
        Arrays.sort(lompatan);
        int max = lompatan[N - 1];
        int sisa = H - max;
        if (sisa <= 0) {
            System.out.println(max);
            return;
        }
        int hasilKedua = 0;
        for (int j : lompatan) {
            if (j >= sisa) {
                hasilKedua = j;
                break;
            }
        }
        System.out.println(max + hasilKedua);
        sc.close();
    }
}
