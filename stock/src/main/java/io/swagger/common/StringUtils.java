package io.swagger.common;

public class StringUtils {

	public static boolean isNullOrEmpty(String str) {
		if (str != null && !str.isEmpty())
			return false;
		return true;
	}

	public static boolean blank(String s) {
		return s == null || s.equals("null") || s.chars().allMatch(Character::isWhitespace) ? true : false;
	}

}
