package com.pearson.eselenium.ls.common.pages.utils;

import com.pearson.eselenium.utils.DateUtils;
import com.pearson.eselenium.utils.StringUtils;

/**
 * 
 * This class has methods Which will help in cleaning up the object
 * 
 * @author Raghav S
 */


public class CleanUpUtil {

	
	public boolean verifyOnedayTimeStamp(String testData) throws Exception
	{
		Long timestamp;
		boolean onedaytimestamp=false;
		try{
			StringUtils stringutil=new StringUtils();
			timestamp=stringutil.stringSplit(testData);
			DateUtils dateutil=new DateUtils();
			onedaytimestamp=dateutil.getTimeOlderThanOneDay(timestamp);
			return onedaytimestamp;
		}catch(Exception e){
			throw new Exception("Not able to Verify one day time stamp"+e.getLocalizedMessage());
		}
			
	}
	
}
