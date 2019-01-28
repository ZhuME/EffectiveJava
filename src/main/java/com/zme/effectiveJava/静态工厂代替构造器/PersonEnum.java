package com.zme.effectiveJava.静态工厂代替构造器;

import java.lang.reflect.Constructor;

/**
 * @auth zme on 2019/1/28 15:09
 **/
//枚举类型提供了序列化和反序列化的机制，保证序列化前后是一个对象
public enum PersonEnum {
    INSTANCE;

    public static void main(String[] args)  throws Exception{
        PersonEnum personEnum = PersonEnum.INSTANCE;

        Constructor<?> declaredConstructors = PersonEnum.class.getDeclaredConstructors()[0];
        declaredConstructors.setAccessible(true);
        //枚举类型使用反射进行对象创建时，这里会抛出异常，保证了单例
        PersonEnum o = (PersonEnum)declaredConstructors.newInstance();
        System.out.println(personEnum.equals(o));
    }
}
