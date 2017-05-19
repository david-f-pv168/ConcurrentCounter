public class Main {

    public static void main(String[] args)
    {
        Runnable counter1 = new Counter();
        Runnable counter2 = new Counter();
        Runnable counter3 = new Counter();

        Thread thread1 = new Thread(counter1, "vlakno 1");
        Thread thread2 = new Thread(counter2, "vlakno 2");
        Thread thread3 = new Thread(counter3, "vlakno 3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Counter implements Runnable {
    public void run() {
        while (Count.next()) {
            for (long l = 0l; l < 1000000; l++) {}
        }
    }
}

class Count {
    private static int currentValue = 0;
    public static synchronized boolean next() {
        if (currentValue <= 50) {
            System.out.println(String.format("%s: %d",Thread.currentThread().getName(), currentValue++));
            return true;
        }
        return false;
    }

}
