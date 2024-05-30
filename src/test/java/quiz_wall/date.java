package quiz_wall;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class date {
	public static void main(String[] args) {
		Calendar calendar = Calendar. getInstance();
		Date currentDate = calendar. getTime(); 
		Date currentDateTime = currentDate;
		String currentMonth = new SimpleDateFormat("MMMM").format(new Date()); 
		String currentDate1 = new SimpleDateFormat("dd").format(new Date()); 
		String currentYear = new SimpleDateFormat("YY").format(new Date()); 
		String currentHour = new SimpleDateFormat("hh").format(new Date()); 
		String currentMinute = new SimpleDateFormat("mm").format(new Date()); 
		System.out.println(currentHour);
		System.out.println(currentMinute);
		System.out.println(currentDate1);
		System.out.println(currentMonth);
		System.out.println(currentYear);
		System.out.println(currentDateTime);
	}

}
