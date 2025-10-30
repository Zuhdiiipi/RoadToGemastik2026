import java.util.*;

public class soal004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        ArrayList<Integer> zero = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            if (x > 0)
                pos.add(x);
            else if (x < 0)
                neg.add(x);
            else
                zero.add(x);
        }

        int nPos = pos.size();
        int nNeg = neg.size();
        int nZero = zero.size();
        int nNonZero = nPos + nNeg;

        // ---- 1. Kasus dasar ----
        if (N <= 2) {
            printAll(pos, neg, zero);
            return;
        }

        // ---- 2. Semua bilangan tanda sama ----
        if ((nPos == N) || (nNeg == N) || (nZero == N)) {
            printAll(pos, neg, zero);
            return;
        }

        // ---- 3. Ada nol dan cukup untuk menjadikan semua hasil kali = 0 ----
        if (nZero >= nNonZero - 1) {
            ArrayList<Integer> out = new ArrayList<>();
            // sisipkan nol di antara non-zero
            Queue<Integer> nonz = new LinkedList<>();
            nonz.addAll(pos);
            nonz.addAll(neg);
            while (!nonz.isEmpty()) {
                out.add(nonz.poll());
                if (nZero > 0) {
                    out.add(0);
                    nZero--;
                }
            }
            while (nZero-- > 0)
                out.add(0);
            printList(out);
            return;
        }

        // ---- 4. Tidak ada nol, campuran positif-negatif ----
        if (nZero == 0 && nPos > 0 && nNeg > 0 && Math.abs(nPos - nNeg) <= 1) {
            ArrayList<Integer> out = new ArrayList<>();
            boolean startPos = nPos >= nNeg;
            int ip = 0, in = 0;
            while (ip < nPos || in < nNeg) {
                if (startPos && ip < nPos)
                    out.add(pos.get(ip++));
                if (in < nNeg)
                    out.add(neg.get(in++));
                if (!startPos && ip < nPos)
                    out.add(pos.get(ip++));
            }
            printList(out);
            return;
        }

        // ---- 5. Semua kondisi gagal ----
        System.out.println("mustahil");
    }

    static void printAll(List<Integer> pos, List<Integer> neg, List<Integer> zero) {
        ArrayList<Integer> all = new ArrayList<>();
        all.addAll(neg);
        all.addAll(zero);
        all.addAll(pos);
        printList(all);
    }

    static void printList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (i > 0)
                System.out.print(" ");
            System.out.print(list.get(i));
        }
        System.out.println();
    }
}
