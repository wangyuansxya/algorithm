package com.thread;

import java.util.ArrayList;
import java.util.List;

public class ThreadTest {

    private static volatile Temp temp = new Temp();

    private static class Temp {
        public int value = 0;
    }

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(5);

        Thread a = new Thread() {
            @Override
            public void run() {
                super.run();

                synchronized (temp) {
                    for (int i = 0; i < 5; i++) {

                        if(temp.value == 1) {
                            try {
                                temp.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("A=" + i);
                        temp.value = 1;
                        list.add("" + i);
                        temp.notify();
                    }
                }

            }
        };

        Thread b = new Thread() {
            @Override
            public void run() {
                super.run();
                synchronized (temp) {
                    for (int i = 0; i < 5; i++) {
                        if(temp.value == 2) {
                            try {
                                temp.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        temp.value = 2;
                        System.out.println("B=" + i);
                        list.remove("" + i);
                        temp.notify();

                    }
                }
            }
        };

        Thread c = new Thread() {
            @Override
            public void run() {
                super.run();
                synchronized (temp) {
                    for (int i = 0; i < 5; i++) {
                        if(temp.value == 3) {
                            try {
                                temp.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        temp.value = 3;
                        System.out.println("C=" + i);
                        temp.notifyAll();

                    }
                }
            }
        };

        a.start();
        b.start();
//        c.start();

    }

}
