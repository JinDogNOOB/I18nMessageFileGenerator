package i18n_message_file_generator;

import java.io.Reader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.google.common.io.Resources;

// https://zinblog.tistory.com/96 참고
public class I18nTranslatorUsingProperties extends I18nTranslator{
	
	public I18nTranslatorUsingProperties(String srcFile, String srcLangCode, String desFile, String desLangCode) {
		super(srcFile, srcLangCode, desFile, desLangCode);
		// TODO Auto-generated constructor stub
	}


	public void execute(){
		// 작업 시작
		Properties properties = getPropertiesFile(srcFile);
		
		Properties desProperties = new Properties();
		
		Set<String> keys = properties.stringPropertyNames();
		
		// Translator.translate(srcString, srcLangCode, desLangCode);
		for(String key : keys) {
			System.out.println(properties.getProperty(key) + " to=>");
			String temp = Translator.translate(properties.getProperty(key), srcLangCode , desLangCode);
			
			desProperties.put(key, temp);
			
		}
		
		System.out.println("번역완료 이제 저장함");
		
		try {
			FileOutputStream fos = new FileOutputStream(new File(desFile));
			desProperties.store(new OutputStreamWriter(fos, "UTF-8"), "completed");
		}catch(IOException e) {
			e.printStackTrace();
		}	
	}
	
	
	private Properties getPropertiesFile(String src) {
		Properties properties = new Properties();
		try {
			FileInputStream fis = new FileInputStream(new File(src));
			properties.load(new InputStreamReader(fis, Charset.forName("UTF-8")));
		}catch(IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

}

