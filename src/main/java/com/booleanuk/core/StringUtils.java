package com.booleanuk.core;

public class StringUtils {
	public static String leftAlignStringWithPadding(String s, int pad){
		return String.format("%" + pad + "s", s);
	}
	public static String rightAlignStringWithPadding(String s, int pad){
		return String.format("%-" + pad + "s", s);
	}
	public static String centerAlignStringWithPadding(String s, int pad){
		return String.format("%" + ((pad + s.length())/2) + "s", s); // only pads half to left. not center with padding on
		// both sides
	}

}
