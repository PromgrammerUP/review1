package org.javachina.review.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestReflect {
	public static void main(String[] args) throws Exception{
		String path = "org.javachina.review.reflect.Person";
		Class clazz = Class.forName(path);
		//clazz.newInstance();
		Constructor conn = clazz.getDeclaredConstructor();
		conn.setAccessible(true);
		Object obj = conn.newInstance();
		conn.setAccessible(false);
		
		Constructor conn2 = clazz.getDeclaredConstructor(new Class[]{int.class,java.lang.String.class});
		conn2.setAccessible(true);
		Object obj2 = conn2.newInstance(1001,"lilei");
		conn2.setAccessible(false);
		
		Field idField = clazz.getDeclaredField("id");
		String type = idField.getType().getName();
		System.out.println(type);
		idField.setAccessible(true);
		idField.set(obj2, 1003);
		idField.setAccessible(false);
		
		idField.setAccessible(true);
		Object idValue = idField.get(obj2);
		System.out.println(idValue);
		idField.setAccessible(false);
		
		Method method = clazz.getDeclaredMethod("setId",int.class);
		method.invoke(obj2, 1005);
		
		Method getMethod = clazz.getDeclaredMethod("getId");
		Object result = getMethod.invoke(obj2);
		System.out.println(result);
		
		
	}
}
