package i18n_message_file_generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MainCli {

	public MainCli() throws IOException {
		/**
		 * 0 : properties(default)
		 * 1 : json
		 * */
		int mode = 0;
		
		String srcFilePath = "";
		String srcLang = "";
		
		String desFilePath = "";
		String desLang = "";
		
		
		// ������� ��� �Է�
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���������̸� �Է��ϼ���");
		srcFilePath = System.getProperty("user.dir") + File.separator + sc.next();
		
		System.out.println("���������� �� �Է��ϼ���");
		I18nTranslator.printLangCodes();
		srcLang = I18nTranslator.getLangCode(sc.nextInt());
		
		System.out.println("���� Ȯ���ڸ� �����ϼ��� 0:properties 1:json");
		mode = sc.nextInt();
		
		
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("��ǥ�����̸� �Է��ϼ���");
		desFilePath = System.getProperty("user.dir") + File.separator + sc.next();
		
		System.out.println("���Ͻô� �� �Է��ϼ���");
		I18nTranslator.printLangCodes();
		desLang = I18nTranslator.getLangCode(sc.nextInt());
		
		System.out.println("######################");
		System.out.println("�������ϰ�� : " + srcFilePath);
		System.out.println("������� : " + srcLang);
		System.out.println("��ǥ���ϰ�� : " + desFilePath);
		System.out.println("��ǥ��� : " + desLang);
		System.out.println("�ƹ�Ű");
		sc.next();
		sc.close();
		
		I18nTranslator i18n;
		switch(mode) {
			case 0:{
				// properties
				i18n = new I18nTranslatorUsingProperties(srcFilePath, srcLang, desFilePath, desLang);
				break;
			}
			case 1:{
				// json
				i18n = new I18nTranslatorUsingJson(srcFilePath, srcLang, desFilePath, desLang);
				break;
			}
			default:{
				// properties
				i18n = new I18nTranslatorUsingProperties(srcFilePath, srcLang, desFilePath, desLang);
				break;
			}
		}
		 
		i18n.execute();
		
		
		
		return;
		
	}
}
