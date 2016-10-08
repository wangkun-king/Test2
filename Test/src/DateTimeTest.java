import java.util.Calendar;
import java.util.Date;


public class DateTimeTest {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		System.out.print(cal.get(Calendar.YEAR)+"-");
		System.out.print(cal.get(Calendar.MONTH)+"-");
		System.out.print(cal.get(Calendar.DATE)+" ");
		System.out.print(cal.get(Calendar.HOUR_OF_DAY)+":"); 	//24Сʱ
//		System.out.print(cal.get(Calendar.HOUR));			//12Сʱ
		System.out.print(cal.get(Calendar.MINUTE)+":");
		System.out.println(cal.get(Calendar.SECOND));
//		System.out.println(cal.get(Calendar.AM));
//		System.out.println(cal.get(Calendar.AM_PM));
//		System.out.println(cal.get(Calendar.ALL_STYLES));
//		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
//		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
//		System.out.println(cal.get(Calendar.DAY_OF_WEEK_IN_MONTH));
//		System.out.println(cal.get(Calendar.DAY_OF_YEAR));
//		System.out.println(Calendar.DECEMBER);
		cal.add(Calendar.DATE, -1);
		System.out.println(cal.getTime());
		System.out.println(new Date());
	}
}
