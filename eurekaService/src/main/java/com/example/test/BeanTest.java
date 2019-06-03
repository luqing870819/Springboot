package com.example.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 
 * @author LQ
 *	把对象解析成JSON格式字符串
 */
public class BeanTest {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("我");
		list.add("你");
		Person p = new Person();
		p.setAge(5);
		p.setGender("男");
		p.setName("大熊");
		p.setList(list);
		StringBuffer sb =new StringBuffer();
		String[] s =getFiledName(p);
		System.out.println(Arrays.toString(s));
		sb.append("{");
		for(String str : s){
			sb.append("\""+ str + "\":");
			Object o = getFieldValueByName(str, p);
			if(o instanceof Integer){
				sb.append(o);
			}
			else if(o instanceof String){
				sb.append("\""+ o + "\"");
			}
			else if(o instanceof List){
				sb.append(o.toString());
			}	
			sb.append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("}");
		System.out.println(sb.toString());
	}
	
	//获取对象的所有属性名称
	private static String[] getFiledName(Object o){          
		Field[] fields=o.getClass().getDeclaredFields();          
		String[] fieldNames=new String[fields.length];          
		for(int i=0;i<fields.length;i++){  
			//打印对象的属性类型
			//System.out.println(fields[i].getType());              
			fieldNames[i]=fields[i].getName();          
		}          return fieldNames;      
	}
	
	// 根据属性名获取属性值      
	private static Object getFieldValueByName(String fieldName, Object o) {          
		try {                
			String firstLetter = fieldName.substring(0, 1).toUpperCase();                
			String getter = "get" + firstLetter + fieldName.substring(1);                
			Method method = o.getClass().getMethod(getter, new Class[] {});                
			Object value = method.invoke(o, new Object[] {});                
			return value;
		} catch (Exception e) {
			return null;            
		}  
	}
	
}
