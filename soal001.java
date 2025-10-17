import java.util.Scanner;

class soal001 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();

        int[] ans = { 0, 1, 3, 6, 0 };

        System.out.println(ans[X]);
    }
}