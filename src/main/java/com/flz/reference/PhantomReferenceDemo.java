package com.flz.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

public class PhantomReferenceDemo {
    public static void main(String[] args) {
        User user = new User("p");
        ReferenceQueue<User> referenceQueue = new ReferenceQueue<>();
        PhantomReference<User> phantomReference = new PhantomReference<>(user, referenceQueue);
        user = null;

        while (true) {
            // 无法从虚引用中获取关联的对象，get出来永远为null
            System.out.println("Directly get object from phantom reference:" + phantomReference.get());
            Reference<? extends User> reference = referenceQueue.poll();
            // 关联的对象被gc后就能从引用队列中拿到虚引用对象了
            if (reference != null) {
                System.out.println("Phantom reference from queue:" + reference);
                break;
            }
        }
    }
}
