package com.skf.management.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.tomcat.util.codec.binary.Base64;

public class StringUtil {

	public static String encodeBase64(String str) throws Exception {

		return new String(Base64.encodeBase64(str.getBytes("UTF-8")), "UTF-8");
	}

	public static String decodeBase64(String str) throws Exception {

		return new String(Base64.decodeBase64(str.getBytes("UTF-8")), "UTF-8");
	}
	
	public static boolean isChinaPhoneLegal(String str)   {  
        String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";  
        Pattern p = Pattern.compile(regExp);  
        Matcher m = p.matcher(str);  
        return m.matches();  
    }  
	
    public static boolean isValidEmail(String email) {
        String reg = "\\w+@(\\w+\\.){1,3}\\w+";
        Pattern pattern = Pattern.compile(reg);
        boolean flag = false;
        if (email != null) {
            Matcher matcher = pattern.matcher(email);
            flag = matcher.matches();
        }
        return flag;
    }
    
    public static boolean isValidUserName(String userName) {
        String reg = "[a-z0-9A-Z]+$";
        Pattern pattern = Pattern.compile(reg);
        boolean flag = false;
        if (userName != null) {
            Matcher matcher = pattern.matcher(userName.replaceAll(" ", ""));
            flag = matcher.matches();
        }
        return flag;
    }
    
    
	
	public static void main(String[] args) {
		System.out.println(isValidUserName("d11 33"));
	}

}
