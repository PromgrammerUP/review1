package org.javachina.review.iterator;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

public class TestIterator {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("abc");
		list.add("abc");
		list.set(0, "i love china");
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			String value = it.next();
			System.out.println(value);
		}
		System.out.println(list);
		
		HashSet<String> set = new HashSet<>();
		set.add("zhangsan");
		set.add("lisi");
		for (String string : set) {
			System.out.println(string);
		}
		Iterator its = set.iterator();
		while(its.hasNext()){
			Object o = its.next();
			System.out.println(o);
		}
		//vector 是jdk1.2之前的集合，是线程安全的
		Vector vec = new Vector<>();
		vec.addElement("zzzz");
		vec.addElement("bbbb");
		vec.addElement("zzzz");
		vec.setElementAt("cccc", 0);
//		vec.removeElementAt(0);
//		Iterator itv = vec.iterator();
//		while(itv.hasNext()){
//			System.out.println(itv.next());
//		}
//		Enumeration enu = vec.elements();
//		while(enu.hasMoreElements()){
//			System.out.println(enu.nextElement());
//		}
		for(int i=0;i<vec.size();i++ ){
			Object value = vec.elementAt(i);
			System.out.println(value);
		}
		System.out.println(vec);
	}
}
