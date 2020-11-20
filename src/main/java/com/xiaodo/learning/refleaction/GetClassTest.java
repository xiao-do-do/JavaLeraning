package com.xiaodo.learning.refleaction;

public class GetClassTest {

	/**
	 * 三种方式获得class
	 * 1*对象.getClass()
	 * 2*类.class
	 * 3*Class.forName("")
	 */

	public static void main(String[] args) {
		Class<?> _class;
		// ***1*对象.getClass()
		String str = "";
		_class = str.getClass();
		System.out.println(_class + "-----对象名.getClass()");
		// ***2*类.class
		_class = String.class;
		System.out.println(_class + "-----类名.class");
		// ***3*Class.forName("")
		try {
			_class = Class.forName("java.lang.String");
			System.out.println(_class + "-----Class.forName(...)");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}


	}
}