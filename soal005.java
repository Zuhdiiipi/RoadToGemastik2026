import java.util.Scanner;

public class soal005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        long A = sc.nextLong();
        long B = sc.nextLong();

        long kpk = kpk(A, B);

        long merah = kpk / A;
        long hijau = kpk / B;

        if (merah <= N && hijau <= N) {
            System.out.println(merah + hijau);
        } else {
            System.out.println(-1);
        }

        sc.close();
    }

    static long fpb(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static long kpk(long a, long b) {
        return (a / fpb(a, b)) * b;
    }
}
