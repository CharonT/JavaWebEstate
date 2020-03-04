

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		String[] buildi= {"TANG_TRET","NGUYEN_CAN"};
//		StringBuilder buil=new StringBuilder();
//		Arrays.asList(buildi).stream().forEach(x->buil.append(x+",")); //x la item của cái list 
//		System.out.println(buil.a);
		String str=Arrays.toString(buildi);
		str=str.substring(str.indexOf("[")+1,str.indexOf("]") );
		System.out.println(str);
		
	}

}
