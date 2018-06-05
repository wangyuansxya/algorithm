package com.reflex;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ReflexMain {
	public static void main(String[] args) {
		
		try {
			Student stu1 = new Student();
			Class<Student> c1 = (Class<Student>) stu1.getClass();
			
			Class<Student> c2 = Student.class;
			
			Class<Student> c = (Class<Student>) Class.forName("com.reflex.Student");
			
			System.out.println("是否c1=c2" + (c1 == c2));
			System.out.println("是否c=c1" + (c == c1));
			//证明在运行期间，一个类，只有一个Class对象产生
			
			Student stu = c.newInstance();
			Field f = c.getDeclaredField("name");
			f.setAccessible(true);
			f.set(stu, "刘德华");
			Field courseName = c.getDeclaredField("courseName");
			courseName.setAccessible(true);
			courseName.set(stu, "语文课");
			System.out.println("学生的姓名是=" + stu.getName());
			System.out.println("学生的课程是=" + stu.getCourseName());


			//构造方法
			Constructor<Student> constructor = c.getDeclaredConstructor(String.class);
			Student student = constructor.newInstance("rekkar");
//			student.setTeaName("rekkar");
			System.out.println("学生的课程老师是=" + student.getTeaName());


			//方法
			Method method = c.getDeclaredMethod("setName", String.class);
			method.invoke(stu, "kevin");

			Method getName = c.getDeclaredMethod("getName");
			String name = (String) getName.invoke(stu);

			System.out.println("学生的姓名反射设置=" + name);


			String className = getProperty("className");
			String methodName = getProperty("methodName");

			Class<Student> propertyName = (Class<Student>) Class.forName(className);
			Method propertyMethod = propertyName.getDeclaredMethod(methodName, String.class);
			Student propertyStudent = propertyName.newInstance();
			propertyMethod.invoke(propertyStudent, "rekkarTest");

			Field teaName = propertyName.getDeclaredField("teaName");
			teaName.setAccessible(true);

			System.out.println("学生的姓名反射设置2=" + teaName.get(propertyStudent));


			//通过反射越过泛型检查
			//Field list = propertyName.getDeclaredField("list");
			//list.setAccessible(true);

			List<?> list = propertyStudent.getList();
			Class<?> listClass = list.getClass();

			Method listAdd = listClass.getDeclaredMethod("add", Object.class);

			listAdd.invoke(list, 100);

			System.out.println("list设置=" + list.get(0));

		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}



	private static String getProperty(String key) throws IOException {
		Properties properties = new Properties();
		FileReader reader = new FileReader("setting.txt");
		properties.load(reader);
		reader.close();
		return properties.getProperty(key);
	}


}
