package test;

import net.sf.json.JSONObject;

public class util {
	public static String APIKEY = "54d263a2970dcda61ef214c4852a8dc3";
	public static String API_ENTRY = "http://www.tuling123.com/openapi/api";
	public static String TYPE_Text = "文本";
	public static String TYPE_Link = "链接";
	public static String TYPE_TRAIN = "列车";
	public static String TYPE_NEWS = "新闻";
	public static String TYPE_Flight = "航班";
	public static String TYPE_Cai = "菜";
	public static String getJsonText(StringBuffer sb){
		String temp = new String(sb);
		JSONObject jsonObject = JSONObject.fromObject(temp);
		if(jsonObject.get("text")!=null){
			return (String)jsonObject.get("text");
		}
		else return null;
	}
	
	public static String getType(String sbb){
		int sb=(Integer) JSONObject.fromObject(sbb).get("code");
		if(sb==100000){
			return TYPE_Text;
		}else if(sb==200000){
			return TYPE_Link;
		}else if(sb==302000){
			return TYPE_NEWS;
		}else if(sb==305000){
			return TYPE_TRAIN;
		}else if(sb==306000){
			return TYPE_Flight;
		}else if(sb==308000){
			return TYPE_Cai;
		}else return null;
	}
	/**
	 * 
	 * @param sb
	 * @return
	 */
	public static JSONObject getJsonObjFromSB(StringBuffer sb){
		String temp = new String(sb);
		JSONObject jsonObject = JSONObject.fromObject(temp);
		return jsonObject;
	}
}
