package lbsyun.test;

import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map;

import com.dep.lbsyun.util.Constant;
import com.dep.lbsyun.util.HttpUtil;
import com.dep.lbsyun.util.SnCal;
import com.dep.lbsyun.util.UnicodeUtil;

public class Test {

	public static void main(String[] args) throws UnsupportedEncodingException {
		Map paramsMap = new LinkedHashMap<String, String>();
		String ip="101.231.60.132";
        paramsMap.put("ip", ip);
        paramsMap.put("ak", Constant.ak);
        String sn=SnCal.getSn("/location/ip",paramsMap);
        System.out.println(sn);
        String result=HttpUtil.sendGet("http://api.map.baidu.com/location/ip", "ip="+ip+"&ak="+Constant.ak+"&sn="+sn);
        System.out.println(UnicodeUtil.unicodeToUtf8(result));
	}

}
