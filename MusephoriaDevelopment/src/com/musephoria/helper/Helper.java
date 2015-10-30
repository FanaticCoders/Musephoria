/**
 *
 */
package com.musephoria.helper;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Fanatic Coders
 *
 */
public class Helper {

	private static final Log log = LogFactory.getLog(Helper.class);

	/**
	 * Loads the property file using the below parameters.
	 *
	 * @param propertyKey
	 * @param className
	 * @return
	 */
	public static Properties LoadProperty(String propertyFileName) {
		// Reference :
		// http://stackoverflow.com/questions/333363/loading-a-properties-file-from-java-package

		Properties property = new Properties();

		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream inputStream = loader.getResourceAsStream(propertyFileName);

		try {
			if (inputStream != null) {
				property.load(inputStream);
			}

		} catch (IOException e) {
			log.error(e.getLocalizedMessage(), e);
		}
		return property;
	}

	/**
	 * Fetches the property value when property key is passed.
	 *
	 * @param propertyObj
	 * @param propertyKey
	 * @return
	 */
	public static String FetchPropertyAndProcessQuery(Properties propertyObj, String propertyKey,
			List<?> parameterList) {
		String rawQuery = StringUtils.EMPTY;
		String processedQuery = StringUtils.EMPTY;

		if (!propertyObj.equals(null)) {
			rawQuery = propertyObj.getProperty(propertyKey);
		}

		if (parameterList != null) {
			processedQuery = ProcessQuery(parameterList, rawQuery);
		} else {
			processedQuery = rawQuery;
		}

		return processedQuery;
	}

	/**
	 * Processes the query string by replacing @param parameters with actual
	 * parameters.
	 *
	 * @param parameterList
	 * @param rawQuery
	 * @return
	 */
	public static String ProcessQuery(List<?> parameterList, String rawQuery) {
		String processedString = rawQuery;
		int i = 1;

		Iterator<?> iterator = parameterList.iterator();
		while(iterator.hasNext())
		{
			processedString = processedString.replace("@param" + i, iterator.next().toString());
			i++;
		}

		return processedString;
	}

	/**
	 * Formats the date in YYYY/MM/DD Format
	 *
	 * @param dateString
	 * @return
	 */
	public static Date FormatDate(String dateString) {
		// Reference :
		// http://www.mkyong.com/java/java-date-and-calendar-examples/

		Date date = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

		try {
			date = dateFormat.parse(dateString);
		} catch (ParseException e) {
			log.error(e.getLocalizedMessage(), e);
		}
		return date;
	}
}
