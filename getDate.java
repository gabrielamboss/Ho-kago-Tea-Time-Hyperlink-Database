package boot;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
 
public class getDate{
	private static String data;
	public static String pegarData(){
		Date today = Calendar.getInstance().getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		data = formatter.format(today);
		return data;
	}
}
