package methods;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvert {
	public static String convert_date(String inputpattern,String outputpattern,String givendate)
	{
		givendate = givendate.replaceAll(" 00:00:00.0","");
        SimpleDateFormat inputformat = new SimpleDateFormat(inputpattern);
        SimpleDateFormat outputformat = new SimpleDateFormat(outputpattern);
        Date date = null;
        String reqdate=null;
        try {
			date = inputformat.parse(givendate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        reqdate = outputformat.format(date);
        
        return reqdate;
	}
}
