package com.flz.reference;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class WeakReferenceDemo {
    public static void main(String[] args) {
        User user = new User("w");
        User user2 = new User("s");
        WeakReference<User> weakReference = new WeakReference<>(user);
        SoftReference<User> softReference = new SoftReference<>(user2);
        user = null;
        user2 = null;

        System.out.println("before gc,weak ref:" + weakReference.get());
        System.out.println("before gc,soft ref:" + softReference.get());
        System.gc();
        System.out.println("after gc,weak ref:" + weakReference.get());
        System.out.println("after gc,soft ref:" + softReference.get());
    }
}
