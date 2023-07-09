package Thread_Tasks;

import javax.swing.*;

public class Task_1_1_2 {

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Captain("wink"));
        Thread thread2 = new Thread(new Captain("wave"));
        thread1.start();
        thread2.start();


        for (String input;
             (input = JOptionPane.showInputDialog("INPUT")) != null; ) {
            if (input.equals("endw"))
                thread1.interrupt();

            if (input.equals("endf"))
                thread2.interrupt();
        }

    }

}


record Captain(String message) implements Runnable {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println(message);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
