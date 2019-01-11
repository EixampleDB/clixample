package model;

public class Header {
    
	public static String createHeader(String key) {
	    try {
	        int d = Integer.parseInt(key);
	    } catch (NumberFormatException | NullPointerException nfe) {
	        return "STR";
	    }
	    return "NUM";
	}

}
