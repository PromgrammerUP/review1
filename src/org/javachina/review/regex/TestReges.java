package org.javachina.review.regex;

import org.omg.Messaging.SyncScopeHelper;

public class TestReges {
	public static void main(String[] args) {
		//String regex = "\\w{3,10}";//代表单词字符
		String regex = "\\w{3,32}@\\w{3,10}[.\\w{2,10}]+";
		String input = "hhh@sina.com.cn";
		boolean isOk = input.matches(regex);
		System.out.println(isOk);
	}
}
