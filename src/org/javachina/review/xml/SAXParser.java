package org.javachina.review.xml;

import java.util.List;
import java.io.IOException;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class SAXParser {
	public static void main(String[] args) throws Exception {
		//创建一个SAX解析器
		SAXBuilder builder = new SAXBuilder();
		//告诉解析器文档的路径
		Document doc = builder.build("./src/org/javachina/review/xml/exam.xml");
		
		Element root = doc.getRootElement();
		
		//取得根元素的属性值
		String rootAttrId = root.getAttributeValue("id");
		String rootAttrLabel = root.getAttributeValue("label");
		System.out.println(rootAttrId);
		System.out.println(rootAttrLabel);
		//取得根元素的直系子元素description
		Element description = root.getChild("description");
		//取得元素中的文本
		String desvalue = description.getText();
		System.out.println(desvalue);
		
		Element requires = root.getChild("requires");
		
		List<Element> imports = requires.getChildren();
		for (Element element : imports) {
			String plugin = element.getAttributeValue("plugin");
			System.out.println(plugin);
		}
		
		
	}
}
