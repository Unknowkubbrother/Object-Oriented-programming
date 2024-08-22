public class LAB4NO4 {
    public static void main(String[] args) {
        double[] A = { 9, 5, 9, 5, 8 };
        AscendSortFreq obj = new AscendSortFreq(A.length);
        double[] B = obj.AscendSort(A);
        int[] C = obj.SortCommuFreq(B);
        for(int i = 0; i < obj.getLengthA(); i++) {
            System.out.print(obj.getValueAofIndex(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < obj.getLengthA(); i++) {
            System.out.print(C[i] + " ");
        }
    }
}

class AscendSortFreq {
    private double[] A;

    public AscendSortFreq(int n) {
        this.A = new double[n];
    }

    public double[] AscendSort(double[] A) {
        double temp;
        for (int i = 0; i < A.length; i++) {
            for (int j = i; j > 0; j--) {
                if (A[j] < A[j - 1]) {
                    temp = A[j];
                    A[j] = A[j - 1];
                    A[j - 1] = temp;
                }
            }
        }
        return A;
    }

    public int[] SortCommuFreq(double[] B) {
        double[] C = new double[B.length];
        int[] freq = new int[B.length];
        int freqCount = 0;
        int count = 0;
        for (int i = 0; i < B.length; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < count; j++) {
                if (B[i] == C[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                C[count++] = B[i];
            }
        }
        this.A = C;
        for (int i=0; i<count; i++) {
            for (int j=0; j<B.length; j++) {
                if (C[i] == B[j]) {
                    freqCount++;
                }
            }
            freq[i] = freqCount;
        }

        return freq;

    }

    public double getValueAofIndex(int idx) {
        return this.A[idx];
    }

    public int getLengthA() {
        int length = 0;
        for (int i = 0; i < this.A.length; i++) {
            if (this.A[i] != 0) {
                length++;
            }
        }
        return length;
    }

}
