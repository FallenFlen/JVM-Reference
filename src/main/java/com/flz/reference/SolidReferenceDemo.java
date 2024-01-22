package com.flz.reference;

/**
 * 强引用
 */
public class SolidReferenceDemo {
    public static void main(String[] args) {
        User user = getUser("a");
        // 显示赋值null
        user = null;
    }

    private static User getUser(String name) {
        // 方法调用结束后，obj没有return出去，无法在外部使用，强引用obj关联的对象被回收
        Object obj = new Object();
        User user = new User(name);
        return user;
    }
}
