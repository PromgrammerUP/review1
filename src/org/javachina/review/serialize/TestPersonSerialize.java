package org.javachina.review.serialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;

import javax.swing.text.FieldView;

public class TestPersonSerialize {
	public void writeObject() {
		Person p = new Person();
		p.setId(1001);
		p.setName("张三");
		p.setAge(23);
		OutputStream os =null;
		ObjectOutputStream oos = null;
		try {
			os = new FileOutputStream("f:/testperson.dat");
			oos = new ObjectOutputStream(os);
			oos.writeObject(p);
			oos.flush();
			
			oos.close();
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
	}
	public static void main(String[] args) throws Exception{
		new TestPersonSerialize().writeObject();
		InputStream is = new FileInputStream("f:/testperson.dat");
		ObjectInputStream ois = new ObjectInputStream(is);
		Object obj = ois.readObject();
		String className = obj.getClass().getName();
		Class clazz = Class.forName(className);
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			String fieldName = field.getName();
			Object fieldValue = field.get(obj);
			System.out.println(fieldName+":"+fieldValue);
			
			field.setAccessible(false);
		}
		
	}
}
