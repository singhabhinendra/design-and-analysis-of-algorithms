public class TimeComplexity {
    public static void main(String[] args) {
        int start =(int) System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            System.out.println("a");
        }
        int end=(int)System.currentTimeMillis();
        System.out.println(end-start);
    }
}
