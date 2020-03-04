package com.phuocthanh.utils;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class FormUtils {
	@SuppressWarnings("unchecked") //tắt mấy cái lèm bèm mà compiler báo l
	public static <T> T toModel(Class<T> zClass,HttpServletRequest request){ // <T>, can be any non-primitive type you specify: any class type, any interface type, any array type, or even another type variable.
	//<T : là bất kì loại nào kiểu nào cung được nó là return ,còn T là 1 tham số loại bất kì cái nào cug dc
		T object =null;
		try {
			
			object = zClass.newInstance();
			BeanUtils.populate(object, request.getParameterMap()); //nó map các value của request/getParameterMap nếu trùng với field của java bean 
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} 
		return object;
		
	}
}
