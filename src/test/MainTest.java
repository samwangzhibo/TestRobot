package test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class MainTest {
	public static void main(String[] args) throws Exception{
		Scanner scan = new Scanner(System.in);
		scan.useDelimiter("\n");//修改输入数据的分隔符
		String INFO;
		System.out.println("主人请输入你的指令：");
		
		while(scan.hasNext()){
			String info = scan.nextLine();
			//System.out.println("输入info为："+info);
				//INFO = URLEncoder.encode(info, "utf-8");
				
				byte[] b = info.getBytes("utf-8");
		        
		        INFO =new String(b,"utf-8");
				String getUrl = util.API_ENTRY+"?key="+util.APIKEY+"&info="+INFO;
				URL url;
				url = new URL(getUrl);
				HttpURLConnection urlcon = (HttpURLConnection)url.openConnection();
				urlcon.connect();
				
				InputStream is = urlcon.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));
				
				StringBuffer sb = new StringBuffer();
				String line ="";
				while((line=br.readLine())!=null)
				sb.append(line);
				
				
				br.close();
				urlcon.disconnect();
				//String Type_ID = util.getType(new String(sb));
				JSONObject jobj = util.getJsonObjFromSB(sb);
				if(util.getType(new String(sb))==null){
					System.out.println("不识别类型。。。。");
				}else{
				System.out.println("类型：	"+util.getType(new String(sb)));
				System.out.println("助手：	"+util.getJsonText(sb));
				if(util.getJsonObjFromSB(sb).get("url")!=null){
				System.out.println("URL：	"+util.getJsonObjFromSB(sb).get("url"));
				}
				if(util.getJsonObjFromSB(sb).get("list")!=null){
					//舒展业务
					JSONArray ja =  util.getJsonObjFromSB(sb).getJSONArray("list");
					//System.out.println(ja);
					JSONObject job =  ja.getJSONObject(0);
					Iterator it = job.keys();
					while(it.hasNext()){
						String key = (String) it.next();
						String value = (String) job.get(key);
						System.out.print(key+" : "+value+" |||  ");
					}
					System.out.println();
					
				}
				}
				System.out.println("主人是否继续？继续 1  不继续-1");
				System.out.println("----------------精美的换行符------------");
				
				String a= scan.nextLine();
				//System.out.println("输入指令为"+a);
				
				if(a.equals("1")){
					System.out.println("主人请输入你的指令：");
				}else {
					System.out.println("退出喽。。。");
					break;
				}
		}
		
	}
}
