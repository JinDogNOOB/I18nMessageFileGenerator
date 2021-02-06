package i18n_message_file_generator;


import java.nio.charset.Charset;

import java.util.Properties;
import java.util.Set;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


// https://zinblog.tistory.com/96 ����
public class I18nTranslatorProperties extends I18nTranslator{
	
	public I18nTranslatorProperties(String srcFile, String srcLangCode, String desFile, String desLangCode, String engine) {
		super(srcFile, srcLangCode, desFile, desLangCode, engine);
	}


	public void execute(){
		// �۾� ����
		Properties properties = getPropertiesFile(srcFile);
		
		Properties desProperties = new Properties();
		
		Set<String> keys = properties.stringPropertyNames();
		
		// Translator.translate(srcString, srcLangCode, desLangCode);
		for(String key : keys) {
			System.out.println(properties.getProperty(key) + " to=>");
			String temp = Translator.translate(properties.getProperty(key), srcLangCode , desLangCode, engine);
			
			desProperties.put(key, temp);
			
		}
		
		System.out.println("�����Ϸ� ���� ������");
		
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

