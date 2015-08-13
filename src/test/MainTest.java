package test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

public class MainTest {
	public static void main(String[] args) throws Exception{
		Scanner scan = new Scanner(System.in);
		
		String INFO;
		System.out.println("主人请输入你的指令：");
		
		while(scan.hasNext()){
			String info = scan.nextLine();
			System.out.println("输入info为："+info);
				INFO = URLEncoder.encode(info, "utf-8");
				
				//byte[] b = info.getBytes("utf-8");  
		        //INFO =new String(b,"utf-8");
				
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
				System.out.println(util.getJsonText(sb));
				System.out.println("主人是否继续？继续 1  不继续-1");
				int a = scan.nextInt();
				if(a==1){
					System.out.println("主人请输入你的指令：");
				}else {
					System.out.println("退出喽。。。");
					break;
				}
		}
		
	}
}
