package commonLibs.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

	public static String getCurrentDateAndTime() {
		LocalDateTime datetime = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss");
		
		String dateTimeFormat = datetime.format(format);
		return dateTimeFormat;
	}
}
