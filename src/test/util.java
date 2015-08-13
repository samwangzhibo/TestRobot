package test;

import net.sf.json.JSONObject;

public class util {
	public static String APIKEY = "54d263a2970dcda61ef214c4852a8dc3";
	public static String API_ENTRY = "http://www.tuling123.com/openapi/api";
	public static String getJsonText(StringBuffer sb){
		String temp = new String(sb);
		JSONObject jsonObject = JSONObject.fromObject(temp);
		if(jsonObject.get("text")!=null){
			return (String)jsonObject.get("text");
		}
		else return null;
	}
}
