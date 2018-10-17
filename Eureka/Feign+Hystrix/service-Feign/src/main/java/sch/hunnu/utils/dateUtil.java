package sch.hunnu.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class dateUtil {

	
	public static String getDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return 	sdf.format(new Date());
	}

	
}
