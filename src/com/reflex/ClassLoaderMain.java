package com.reflex;

import java.lang.reflect.Constructor;

public class ClassLoaderMain {

    public static void main(String[] args) {

        try {
            Class<Student> cls = (Class<Student>) Class.forName("com.reflex.Student");
            Class<?> bindingClass = cls.getClassLoader().loadClass(cls.getName() + "ViewBinding");
            Constructor<?> c = bindingClass.getConstructor();
            Object b = c.newInstance();
            System.out.println("ViewBinding" + b.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
