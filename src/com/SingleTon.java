package com;

import java.util.ArrayList;
import java.util.List;

public class SingleTon {

    private SingleTon() {
    }

    private static class Holder {
        private static final SingleTon Instance = new SingleTon();
    }

    public static SingleTon getInstance() {
        return Holder.Instance;
    }


    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                super.run();
                if (list.size() < 5) {
                    list.add(new Integer(1));
                }else{
                    this.notifyAll();
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                super.run();
                if (list.size() > 0) {
                    list.remove(0);
                } else {
                    this.notifyAll();
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }
        };

        t1.start();
        t2.start();
    }
}
