package com.phuocthanh.mapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import com.phuocthanh.annotation.Column;
import com.phuocthanh.annotation.Entity;

public class ResultSetMapper<T> {
	public List<T> mapRow(ResultSet rs, Class<T> zClass) {
		List<T> results = new ArrayList<>();
		int countField=zClass.getDeclaredFields().length;
		boolean check=true;
		try {
			if (zClass.isAnnotationPresent(Entity.class)) {
				ResultSetMetaData resultSetMetaData = rs.getMetaData();
				Field[] fields = zClass.getDeclaredFields();
				while (rs.next()) {
					T object = zClass.newInstance();	
					for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
						String columnName = resultSetMetaData.getColumnName(i + 1);
						Object columnValue = rs.getObject(i + 1);
						for (Field field : fields) {
							if (field.isAnnotationPresent(Column.class)) {	
								Column column = field.getAnnotation(Column.class);
								
								if (column.name().equals(columnName) && columnValue!=null) {									
//									if(columnName.equals("createddate") || columnName.equals("modifieddate")) {
//										PropertyUtils.setProperty(object, columnName, columnValue);
//										break;
//									}else {
//										BeanUtils.setProperty(object, columnName, columnValue);							
//										break;
//									}
									BeanUtils.setProperty(object, field.getName(), columnValue);							
									break;
								}

							}

						}
						Class<?> parentClass=zClass.getSuperclass();
						while(parentClass!=null) {
							if(check) countField+=parentClass.getDeclaredFields().length;
							for (Field field : parentClass.getDeclaredFields()) {
								if (field.isAnnotationPresent(Column.class)) {
									Column column = field.getAnnotation(Column.class);
								
									if (column.name().equals(columnName) && columnValue!=null) {	
//										if(columnName.equals("createddate") || columnName.equals("modifieddate")) {
//											PropertyUtils.setProperty(object, columnName, columnValue);
//											break;
//										}else {
//											BeanUtils.setProperty(object, columnName, columnValue);							
//											break;
//										}
										BeanUtils.setProperty(object, field.getName(), columnValue);							
										break;
										
									}

								}
							}
							parentClass=parentClass.getSuperclass();
							
						}
						check=false;
						if(countField-1 == i)
							break; 
					}
					results.add(object);
					
				}
			}
		} catch (SQLException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		return results;
	}
}
