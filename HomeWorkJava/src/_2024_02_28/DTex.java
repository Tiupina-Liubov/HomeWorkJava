package src._2024_02_28;

public class DTex {
    public static void main(String[] args) {
        System.out.println("MAIN START");
        UserThread userThread = new UserThread();
        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setDaemon(true);

        userThread.start();
        daemonThread.start();

        System.out.println("MAIN END");
    }
}

class UserThread extends Thread {

    @Override
    public void run() {
        for (char c = '!'; c < 'z'; c++) {
            try {
                Thread.sleep(222);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("USER THREAD: " + c);
        }
    }
}

class DaemonThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 999; i++) {
            try {
                Thread.sleep(555);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("DAEMON: " + i);
        }
    }
}