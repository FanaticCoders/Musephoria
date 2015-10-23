/**
 *
 */
package com.musephoria.helper;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Fanatic Coders
 *
 */
public class Helper {

	public static void LogError(Exception ex, Level logLevel) {
		final Logger logger = Logger.getLogger(ex.getClass().getName());
		logger.log(logLevel, ex.getMessage());
	}

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
			Helper.LogError(e, Level.FINER);
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
			List<String> parameterList) {
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
	public static String ProcessQuery(List<String> parameterList, String rawQuery) {
		String processedString = StringUtils.EMPTY;
		int i = 1;
		if (!parameterList.isEmpty()) {
			for (String item : parameterList) {
				processedString = rawQuery.replace("@param" + i, item.toString());
				i++;
			}
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
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");

		try {
			date = dateFormat.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
}
