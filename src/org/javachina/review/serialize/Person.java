package org.javachina.review.serialize;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Person implements Externalizable {
	private transient int id;//用transient关键字修饰的属性，在实现serializable接口的类进行序列化的时候，该属性不进行序列化。
							//但是在实现Externalizable的类中，属性依然进行序列化
	private String name;
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public Person() {
		super();
	}
	public Person(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	//可以帮助我们自定义序列化
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		//实现简单的加密算法
		out.writeInt(this.id+2500);
		byte[] temp = this.name.getBytes();
		for(int i=0;i<temp.length;i++){
			temp[i]+=1;
		}
		out.writeUTF(new String(temp));
		out.writeInt(this.age+3000);
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		//读取的顺序与写入的顺序应该一直，否则可能产生数据混乱
		this.id = in.readInt()-2500;
//		this.name = in.readUTF();
		String temp = in.readUTF();
		byte[] bytes = temp.getBytes();
		for (int i = 0; i < bytes.length; i++) {
			bytes[i]-=1;
		}
		this.name = new String(bytes);
		this.age = in.readInt()-3000;
	}
}
