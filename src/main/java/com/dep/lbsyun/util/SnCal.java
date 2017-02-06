package com.dep.lbsyun.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;

public class SnCal {

	/**
	 * 计算SN
	 * @param url 不需要带问号.eg:/location/ip
	 * @param paramsMap Map参数
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String getSn(String url, Map<String, String> paramsMap) throws UnsupportedEncodingException {
		String paramsStr = toQueryString(paramsMap);
		String wholeStr = new String(url + "?" + paramsStr + Constant.sk);
		String tempStr = URLEncoder.encode(wholeStr, "UTF-8");
		return Encryption.MD5EncryptionStr(tempStr);
	}

	protected static String toQueryString(Map<?, ?> data) throws UnsupportedEncodingException {
		StringBuffer queryString = new StringBuffer();
		for (Entry<?, ?> pair : data.entrySet()) {
			queryString.append(pair.getKey() + "=");
			queryString.append(URLEncoder.encode((String) pair.getValue(), "UTF-8") + "&");
		}
		if (queryString.length() > 0) {
			queryString.deleteCharAt(queryString.length() - 1);
		}
		return queryString.toString();
	}
}
