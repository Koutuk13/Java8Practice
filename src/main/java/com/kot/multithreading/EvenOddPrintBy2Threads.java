package com.kot.multithreading;

public class EvenOddPrintBy2Threads implements Runnable{

    int count = 1;
    Object object;

    public EvenOddPrintBy2Threads(Object object){
        this.object=object;
    }
    @Override
    public void run() {
        System.out.println("Current thread running is : " + Thread.currentThread().getName());
            while (count <= 10) {
                System.out.println("count is : "+ count + " :: " + Thread.currentThread().getName());
                synchronized (object) {
                    if (count % 2 == 0 && "even".equals(Thread.currentThread().getName())) {
                        // synchronized (object) {
                        System.out.println("Thread name: " + Thread.currentThread().getName() + " value : " + count);
                        count++;
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        // }
                    } else if (count % 2 != 0 && "odd".equals(Thread.currentThread().getName())) {
                        //synchronized (object){
                        System.out.println("Thread name: " + Thread.currentThread().getName() + " value : " + count);
                        count++;
                        object.notify();
                        // }
                    }
                }
            }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        Runnable run1 = new EvenOddPrintBy2Threads(lock);
        Thread t1 = new Thread(run1,"even");
        Thread t2 = new Thread(run1, "odd");
        t1.start();
        t2.start();
    }


}
