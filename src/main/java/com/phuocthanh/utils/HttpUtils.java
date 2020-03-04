package com.phuocthanh.utils;

import java.io.BufferedReader;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;


//thằng này được dùng khi tất cả dữ liệu để trong body
public class HttpUtils {
	private String value;
	public HttpUtils(String value) {
		this.value=value;
		
	}
	public <T> T toModel(Class<T> tClass) { //<T>: is referred to as any type
			try {
				return new ObjectMapper().readValue(value, tClass);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		return null;
	}
	public static HttpUtils of(BufferedReader reader) {
		
		StringBuilder sb=new StringBuilder();
	
		try {
			String line;
			while((line=reader.readLine())!=null) {
				sb.append(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return new HttpUtils(sb.toString());
	}
}
