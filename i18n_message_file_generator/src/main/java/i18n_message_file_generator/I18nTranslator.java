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

import com.google.common.io.Resources;

// https://zinblog.tistory.com/96 ����
public class I18nTranslator {
	private String srcFile;
	private String srcLangCode;
	private String desFile;
	private String desLangCode;
	// Map<Integer, String> langCode = new HashMap<Integer, String>();
	public static final String[] langName = {"�ѱ���", "����", "�Ϻ���", "���Ͼ�", "�߱���(��ü)", "�߱���(��ü)", "���þƾ�", "�����ξ�", "��������"};
	public static final String[] langCode = {"ko", "en", "ja", "de", "zh-CN", "zh-TW", "ru", "es", "fr"};
	/**
	 * 
	 * @param srcFile
	 * @param srcLangCode
	 * @param desFile
	 * @param desLangCode
	 */
	public I18nTranslator(String srcFile, String srcLangCode, String desFile, String desLangCode) {
		this.srcFile = srcFile;
		this.srcLangCode = srcLangCode;
		this.desFile = desFile;
		this.desLangCode = desLangCode;
		
	}
	
	public void translate() throws IOException {
		// �۾� ����
		Properties properties = getProperties(srcFile);
		
		Properties desProperties = new Properties();
		
		Set<String> keys = properties.stringPropertyNames();
		
		// Translator.translate(srcString, srcLangCode, desLangCode);
		for(String key : keys) {
			System.out.println(properties.getProperty(key) + " to=>");
			String temp = Translator.translate(properties.getProperty(key), srcLangCode , desLangCode);
			
			desProperties.put(key, temp);
		}
		
		System.out.println("�����Ϸ� ���� ������");
		
		FileOutputStream fos = new FileOutputStream(new File(desFile));
		desProperties.store(fos, "completed");
		
	}
	
	
	public static String getLangCode(int num) {
		if(num >= 0 && num < langName.length) {
			return langCode[num];
		}else return null;
	}
	
	public static void printLangCodes() {
		for(int i = 0; i < langName.length; i++) {
			System.out.println(i+". ����̸� : " +langName[i] + "����ڵ� : " + langCode[i]);
		}
		
	}
	
	private Properties getProperties(String src) {
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

/*
 
�ѱ��� 	ko
���� 	en
�Ϻ��� 	ja
���Ͼ� 	de
�߱���(��ü) 	zh
�߱���(��ü) 	zh-TW
���þƾ� 	ru
�����ξ� 	es
�������� 	fr





*/