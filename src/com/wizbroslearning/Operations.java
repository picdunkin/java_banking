package com.wizbroslearning;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Operations {
    public static void main(String[] args){
        final Account a = new Account(5000);
        final  Account b = new Account(2500);

        new Thread(new Runnable() {
            @Override
            public void run() {
                transfer(b,a,2500);
                transfer(b,a,2500);
            }
        }).start();

        transfer(a,b,2500);
        transfer(a,b,2500);

        System.out.println("A balance final: " + a.getBalance());
        System.out.println("B balance final: " + b.getBalance());
    }

     static void transfer(Account ac1, Account ac2, int amount){

        if(ac1.getBalance() < amount){
            System.out.println("Transit unsuccessful");
            return;
        }

        //ac1.withdraw(amount);
        //ac2.deposit(amount);
        System.out.println("Transit successful");

         Lock lock0 = new ReentrantLock();
        if(lock0.tryLock()){

        }else{
            lock0.unlock();
        }
//        Lock lock0 = new ReentrantLock();
//        lock0.lock();
//        try{
//
//            Lock lock1 = new ReentrantLock();
//            lock1.lock();
//            try{
//                ac1.withdraw(amount);
//                ac2.deposit(amount);
//            }
//            finally {
//                System.out.println("Transited");
//                lock1.unlock();
//            }
//        }
//        finally {
//            lock0.unlock();
//            System.out.println("Transit successful");
//        }


        System.out.println("A balance: " + ac1.getBalance());
        System.out.println("B balance: " + ac2.getBalance());

//        synchronized (ac1){
//            try {
////                Thread.sleep(100);
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
//
//            synchronized (ac2){
//                ac1.withdraw(amount);
//                ac2.deposit(amount);
//                System.out.println("Transit successful");
//            }
//        }


    }


}