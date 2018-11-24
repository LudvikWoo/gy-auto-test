package com.guoyasoft.gyautotest.topic.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
	public static void main(String[] args) {
		Class student=Student.class;
		Field[] fields=student.getDeclaredFields();
		for(Field f:fields){
			System.out.println(f.getName());
		}

		Method[] methos=student.getDeclaredMethods();
		for(Method m:methos){
			//System.out.println(m.getName());
			Annotation a=(Annotation) m.getAnnotation(org.testng.annotations.Test.class);
			if(a!=null){
				try {
					m.invoke(student.newInstance(), null);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
