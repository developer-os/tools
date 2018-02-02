package mail;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import mail.tools.enums.ZoneIdEnum;

/**
 * @author rchen7
 *
 */
public class DataTranslateTools {
	public static void main(String[] args) {
		System.out.println(getGlobalTime(2, "2018/02/01 12:00", "yyy-MM-dd HH:mm:ss"));
		System.out.println(getGlobalTime(1, "2018/02/01 12:00", "yyy-MM-dd HH:mm:ss"));
		System.out.println(getGlobalTime(3, "2018/02/01 12:00", "yyy-MM-dd HH:mm:ss"));
	}

	public static String getGlobalTime(int zoneNum, String strData, String formatStr) {
		TimeZone timeZone = TimeZone.getTimeZone(ZoneIdEnum.getZoneIdByNum(zoneNum));
		Date date = new Date(strData);
		SimpleDateFormat df = new SimpleDateFormat(formatStr);
		df.setTimeZone(timeZone);
		return df.format(date);
	}

}
