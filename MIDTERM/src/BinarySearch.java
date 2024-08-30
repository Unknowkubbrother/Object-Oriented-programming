public class BinarySearch {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        int start = 0, end = a.length - 1, mid = (start + end) / 2, key = 3;
        while (start <= end) {
            if (a[mid] == key) {
                System.out.println("Element found at index: " + mid);
                break;
            } else if (a[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = (start + end) / 2;
        }
    }
}
