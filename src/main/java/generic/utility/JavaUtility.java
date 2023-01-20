package generic.utility;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber() {
		Random r = new Random();
		int randomNumber = r.nextInt(1000);
		return randomNumber;
	}
	public String sysDate() {
		Date d = new Date();
		String date = d.toString();
		return date;
	}
	public int sysYear() {
		Date d = new Date();
		@SuppressWarnings("deprecation")
		int year = d.getYear();
		return year;
	}
}
