package fullTime;

/**
 * Created by Biyanta on 14/11/17.
 */
public class Multithreading implements Runnable {
    Thread t;
    String threadName;

    Multithreading(String name) {
        threadName = name;
        System.out.println("Creating the thread "+ name);
    }
    @Override
    public void run() {
        System.out.println("The running thread is " + threadName);
        try {
            for (int i = 1; i <= 4; i++) {
                System.out.println("thread "+ threadName + " running for :"+ i);

                t.sleep(50);
            }
        }
        catch (InterruptedException e) {
            System.out.println("Thread interrupted "+ threadName);
        }
        System.out.println("Thread exiting "+ threadName);

    }

    public static void main(String[] args) {
        Multithreading m1 = new Multithreading("First Thread");
        m1.start();

        Multithreading m2 = new Multithreading("Second Thread");
        m2.start();
    }

    private void start() {
        System.out.println("Starting thread "+ threadName);

        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }

    }
}
