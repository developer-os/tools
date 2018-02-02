package mail.tools.builder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import mail.DataTranslateTools;
import mail.tools.enums.ZoneIdEnum;

public class Builder {
	public static void main(String[] args) {
		builderMail();
	}

	public static void builderMail() {
		try {
			String publishDate="2018/02/03 13:30";//sz
			String evn="live";
			String pendTime="2 Hours";
			String hight="N/A";
			ArrayList<String> systemList = new ArrayList<String>();
			systemList.add("MEDS");
			systemList.add("NFS");
			systemList.add("ERDC");
			systemList.add("HDR/OPM");
			
			
			
			Configuration configuration = new Configuration();
			configuration.setDirectoryForTemplateLoading(new File("D:\\Download\\mailtools\\mail\\src\\main\\webapp"));
			configuration.setObjectWrapper(new DefaultObjectWrapper());
			configuration.setDefaultEncoding("UTF-8");
			Template template = configuration.getTemplate("mailTemplate.html");
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("head", "HELLO ALL");
			paramMap.put("description1", "Please follow");
			paramMap.put("descriptionUrl", " xxxxxx ");
			paramMap.put("description2", "  to receive data collection system updates.");
			paramMap.put("description3", "  If you use the");
			paramMap.put("description4", "Collection Platforms, please read on.");
			String s="We plan to have a "+evn+" standard release on.";
			paramMap.put("description6", s);
			paramMap.put("date", publishDate);
			paramMap.put("description7", "The collection platforms will be partially unavailable during the release interval.");
			paramMap.put("description8", "</br>Impacted Systems:");
			
			paramMap.put("syslist", systemList);
			
			HashMap<String, String> timeMap = new HashMap<String, String>();
			timeMap.put(ZoneIdEnum.getZoneKeyByNum(2),DataTranslateTools.getGlobalTime(2, publishDate, "yyy-MM-dd HH:mm:ss"));
			timeMap.put(ZoneIdEnum.getZoneKeyByNum(1),DataTranslateTools.getGlobalTime(1, publishDate, "yyy-MM-dd HH:mm:ss"));
			timeMap.put(ZoneIdEnum.getZoneKeyByNum(3),DataTranslateTools.getGlobalTime(3, publishDate, "yyy-MM-dd HH:mm:ss"));
			paramMap.put("timeMap", timeMap);
			
			paramMap.put("spendTime", pendTime);
			paramMap.put("h", "hight");
	
			Writer writer = new OutputStreamWriter(new FileOutputStream(
					"D:\\Download\\mailtools\\mail\\src\\main\\webapp\\successMail.html"), "UTF-8");
			try {
				template.process(paramMap, writer);
				System.out.println("鎭枩锛岀敓鎴愭垚鍔焴~");
			} catch (TemplateException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void test() {
		try {
			Configuration configuration = new Configuration();
			configuration.setDirectoryForTemplateLoading(new File("D:\\Download\\mailtools\\mail\\src\\main\\webapp"));
			configuration.setObjectWrapper(new DefaultObjectWrapper());
			configuration.setDefaultEncoding("UTF-8");
			Template template = configuration.getTemplate("test.html");
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("description", "鎴戞鍦ㄥ涔犱娇鐢‵reemarker鐢熸垚闈欐�佹枃浠讹紒");
			List<String> nameList = new ArrayList<String>();
			nameList.add("闄堥潠浠�");
			nameList.add("鐜夊効");
			nameList.add("瀹囨枃鎷�");
			paramMap.put("nameList", nameList);

			Map<String, Object> weaponMap = new HashMap<String, Object>();
			weaponMap.put("first", "杞╄緯鍓�");
			weaponMap.put("second", "宕嗗硳鍗�");
			weaponMap.put("third", "濂冲ú鐭�");
			weaponMap.put("fourth", "绁炲啘榧�");
			weaponMap.put("fifth", "浼忕静鐞�");
			weaponMap.put("sixth", "鏄嗕粦闀�");
			weaponMap.put("seventh", null);
			paramMap.put("weaponMap", weaponMap);
			Writer writer = new OutputStreamWriter(
					new FileOutputStream("D:\\\\Download\\\\mailtools\\\\mail\\\\src\\\\main\\\\webapp\\success.html"),
					"UTF-8");
			try {
				template.process(paramMap, writer);
				System.out.println("鎭枩锛岀敓鎴愭垚鍔焴~");
			} catch (TemplateException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
