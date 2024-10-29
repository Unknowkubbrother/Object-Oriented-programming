import java.util.Arrays;

class SortThread extends Thread {
    private int[] array;
    private int start;
    private int end;

    public SortThread(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        Arrays.sort(array, start, end); // ทำการเรียงข้อมูลส่วนที่กำหนด
        System.out.println(Thread.currentThread().getName() + " sorted part: " + Arrays.toString(Arrays.copyOfRange(array, start, end)));
    }
}

public class MultiThreadSorting {
    public static void main(String[] args) {
        int[] array = {29, 10, 14, 37, 13, 3, 85, 42, 27, 9}; // ข้อมูลที่ต้องการเรียง
        System.out.println("Original array: " + Arrays.toString(array));

        // แบ่งการเรียงข้อมูลเป็น 3 ส่วน
        int mid1 = array.length / 3;
        int mid2 = 2 * (array.length / 3);

        // สร้างเธรดในการเรียงข้อมูลแต่ละส่วน
        SortThread thread1 = new SortThread(array, 0, mid1);  // เธรดที่ 1 เรียงจาก 0 ถึง mid1
        SortThread thread2 = new SortThread(array, mid1, mid2); // เธรดที่ 2 เรียงจาก mid1 ถึง mid2
        SortThread thread3 = new SortThread(array, mid2, array.length); // เธรดที่ 3 เรียงจาก mid2 ถึงสิ้นสุด array

        // เริ่มทำงานเธรด
        thread1.start();
        thread2.start();
        thread3.start();

        try {
            // รอให้เธรดทั้งหมดทำงานเสร็จ
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // รวมข้อมูลหลังจากเธรดแต่ละตัวทำการเรียงเสร็จ
        // Arrays.sort(array); // เรียงข้อมูลใหม่ทั้งหมดหลังจากแยกเรียงเสร็จ
        System.out.println("Final sorted array: " + Arrays.toString(array));
    }
}