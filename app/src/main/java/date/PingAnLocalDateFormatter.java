package date;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.format.Formatter;

public class PingAnLocalDateFormatter implements Formatter<LocalDate>{
	public static final String NORMAL_PATTERN = "yyyy-MM-dd";
	public static final String US_PATTERN = "MM/dd/yyyy";

	@Override
	public String print(LocalDate object, Locale locale) {
		return DateTimeFormatter.ofPattern(getPattern(locale)).format(object);
	}

	@Override
	public LocalDate parse(String text, Locale locale) throws ParseException {
		return LocalDate.parse(text, DateTimeFormatter.ofPattern(getPattern(locale)));
	}
	
	public static String getPattern(Locale locale) {
		return isUnitedStates(locale) ? US_PATTERN : NORMAL_PATTERN;
	}
	
	private static boolean isUnitedStates(Locale locale) {
		return Locale.US.getCountry().equals(locale.getCountry());
	}
	
	

}
