package hw3.hash;

import java.util.List;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        int N = 0;
        int[] buckets = new int[M];
        for (Oomage o : oomages) {
            int i = (o.hashCode() & 0x7FFFFFFF) % M;
            buckets[i]++;
            N++;
        }
        for (int num : buckets) {
            if (num >= N / 2.5 || num <= N / 50) {
                return false;
            }
        }
        return true;
    }
}
