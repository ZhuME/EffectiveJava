package com.zme.effectiveJava.静态工厂代替构造器;

import java.io.Serializable;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;

/**
 * @auth zme on 2019/1/28 11:48
 **/
public class Person implements Serializable  {
    private static int count = 0;//当使用反射机制获取对象的时候可以在类的声明中添加计数器，超过计数器之后抛出异常
    private static final Person INSTANCE = new Person();
    private Person(){
        if(count > 0) {
            throw new IllegalArgumentException("Cannot create Elvis twice");
        }
        count++;
    }
    public static Person getInstance(){
        return INSTANCE;
    }
    public void testMethod(){
        System.out.println("method");
    }
    //实现Serilizable接口之后只能保证对象能够序列化，但是反序列化之后的对象跟原对象不是一个对象，也不能保证singleTone
    //实现该方法，在反序列化之后也能保证对象是单例
    private Object readResolve(){
        return INSTANCE;
    }
    public static void main(String[] args) throws Exception{
        //通过反射拿到的对象，这样的话，在运行环境里面就不会是singletone了
//        Constructor<?> declaredConstructors = Person.class.getDeclaredConstructors()[0];
//        declaredConstructors.setAccessible(true);
//        Person o = (Person)declaredConstructors.newInstance();

//        Person instance2 = Person.getInstance();
//        Person instance = Person.getInstance();
//        System.out.println(instance2.equals(instance));
//        instance.testMethod();
        //采用反射机制创建对象，抛出异常
//        Person instance = Person.getInstance();
//        Constructor<?> declaredConstructors = Person.class.getDeclaredConstructors()[0];
//        declaredConstructors.setAccessible(true);
//        Person o = (Person)declaredConstructors.newInstance();


    }

}
