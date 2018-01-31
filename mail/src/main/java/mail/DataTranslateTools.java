package mail;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * @author rchen7
 *http://blog.csdn.net/Cwind017/article/details/41021257
 */
public class DataTranslateTools {
	public static void main(String[] args) {
		System.out.println("ss");
//		getDefaultTimeId("",null);
		getGlobalTime("",null);
	}
	
	public static String getGlobalTime(String strZones,Date date ) {
		TimeZone timeZone = TimeZone.getTimeZone("GMT+5:50");
		Calendar calendar = Calendar.getInstance(timeZone);
		System.out.println(calendar.getTime());
		return "";
	}
	
	public static String getDefaultTimeId(String strZones,Date date ) {
		TimeZone timeZone = TimeZone.getDefault();
		for(String strZone:timeZone.getAvailableIDs()) {
			System.out.println(strZone);
		}
		return "";
	}
}
