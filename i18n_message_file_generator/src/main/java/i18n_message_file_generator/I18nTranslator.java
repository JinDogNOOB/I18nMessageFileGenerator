package i18n_message_file_generator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;
import java.util.Set;

public abstract class I18nTranslator {
	protected String srcFile;
	protected String srcLangCode;
	protected String desFile;
	protected String desLangCode;
	protected String engine;
	// Map<Integer, String> langCode = new HashMap<Integer, String>();
	public static final String[] langName = {"한국어", "영어", "일본어", "독일어", "중국어(간체)", "중국어(번체)", "러시아어", "스페인어", "프랑스어"};
	public static final String[] langCode = {"ko", "en", "ja", "de", "zh-CN", "zh-TW", "ru", "es", "fr"};
	/**
	 * 
	 * @param srcFile
	 * @param srcLangCode
	 * @param desFile
	 * @param desLangCode
	 */
	public I18nTranslator(String srcFile, String srcLangCode, String desFile, String desLangCode, String engine) {
		this.srcFile = srcFile;
		this.srcLangCode = srcLangCode;
		this.desFile = desFile;
		this.desLangCode = desLangCode;
		this.engine = engine;
		
	}
	
	public abstract void execute();

	
	public static String getLangCode(int num) {
		if(num >= 0 && num < langName.length) {
			return langCode[num];
		}else return null;
	}
	
	public static void printLangCodes() {
		for(int i = 0; i < langName.length; i++) {
			System.out.println(i+". 언어이름 : " +langName[i] + "언어코드 : " + langCode[i]);
		}
		
	}
	
	
	
}


/*

한국어 	ko
영어 	en
일본어 	ja
독일어 	de
중국어(간체) 	zh
중국어(번체) 	zh-TW
러시아어 	ru
스페인어 	es
프랑스어 	fr


*/