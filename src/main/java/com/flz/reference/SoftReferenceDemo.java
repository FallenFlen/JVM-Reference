package com.flz.reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class SoftReferenceDemo {
    public static void main(String[] args) throws InterruptedException {
        User user = new User("s");
        ReferenceQueue<User> userReferenceQueue = new ReferenceQueue<>();
        SoftReference<User> userSoftReference = new SoftReference<>(user, userReferenceQueue);
        // 销毁强引用
        user = null;
        System.gc();
        System.out.println("after gc at 1st time");
        // 空间还够的情况，即使强行gc也不会销毁软引用关联的对象
        System.out.println(userSoftReference.get());

        // 一直添加字节数组直到oom
        List<byte[]> bytes = new ArrayList<>();

        int i = 0;
        while (true) {
            bytes.add(new byte[1024 * 1024]);
            System.out.printf("after %s times:%s \n", ++i, userSoftReference.get());
            // 当软引用关联的对象被gc后，该软引用对象本身会被加入引用队列
            System.out.println("reference queue:" + userReferenceQueue.remove(1));
        }


    }
}
