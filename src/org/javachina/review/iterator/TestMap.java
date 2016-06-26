package org.javachina.review.iterator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class TestMap {
	public static void main(String[] args) {
		HashMap<String, String> map  = new HashMap<>();
		// 添加
		map.put("name", "zhangsan");
		map.put("id", "1001");
		//修改
		map.put("name","lisi");//key值相同的添加操作相当于覆盖旧的值
		//删除
		//String value = map.remove("name");
		//System.out.println(value);
		
		//遍历
		Set<String> keys = map.keySet();
//		for (String key : keys) {
//			String value = map.get(key);
//			System.out.println(key+":"+value);
//		}
		Iterator<String> it = keys.iterator();
		while(it.hasNext()){
			String key = it.next();
			String value = map.get(key);
			System.out.println(key+":"+value);
		}
	//-------1.2之前-------
		//hashtable实现了线程安全
		Hashtable<String, String> table = new Hashtable<>();
		//添加
		table.put("name", "zhangsan");
		table.put("age", "20");
		
		//修改
		table.put("name", "lisi");
		
		//删除
		//String value = table.remove("name");
		//System.out.println(value);
		Set<String> s = table.keySet();
		for (String string : s) {
			String val = table.get(string);
			System.out.println(string+":"+val);
		}
		
	}
}
