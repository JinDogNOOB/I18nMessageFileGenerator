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
	public static final String[] langName = {"�ѱ���", "����", "�Ϻ���", "���Ͼ�", "�߱���(��ü)", "�߱���(��ü)", "���þƾ�", "�����ξ�", "��������"};
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
			System.out.println(i+". ����̸� : " +langName[i] + "����ڵ� : " + langCode[i]);
		}
		
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