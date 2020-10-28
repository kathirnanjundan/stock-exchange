package io.swagger.common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

	public static String getStartDate() {
	    
		LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String formatDateTime = now.format(formatter);

        return formatDateTime;
	}
	
	public static void main(String[] args) {
		getStartDate();
	}
}
