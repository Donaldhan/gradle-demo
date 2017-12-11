package cn.home;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author donald
 * 2017年12月10日
 * 下午9:38:35
 */
public class CheckNumeric {
	private static final Logger log = LoggerFactory.getLogger(CheckNumeric.class);

	public static void main(String[] args) {
		String text1 = "a12340";
		String text2 = "1234";
		boolean result1 = StringUtils.isNumeric(text1);
		boolean result2 = StringUtils.isNumeric(text2);
		log.info("{} is a numeric: {}",text1,result1);
		log.info("{} is a numeric: {}",text2,result2);
	}
}
