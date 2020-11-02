package i18n_message_file_generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MainCli {

	public MainCli() throws IOException {
		String srcFilePath = "";
		String srcLang = "";
		
		String desFilePath = "";
		String desLang = "";
		
		
		// ������� ��� �Է�
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�������ϰ�� �Է��ϼ���");
		srcFilePath = System.getProperty("user.dir") + File.separator + sc.next();
		
		System.out.println("���������� �� �Է��ϼ���");
		I18nTranslator.printLangCodes();
		srcLang = I18nTranslator.getLangCode(sc.nextInt());
		
		
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("������ ��θ� �Է��ϼ���");
		desFilePath = System.getProperty("user.dir") + File.separator + sc.next();
		
		System.out.println("���Ͻô� �� �Է��ϼ���");
		I18nTranslator.printLangCodes();
		desLang = I18nTranslator.getLangCode(sc.nextInt());
		
		System.out.println("######################");
		System.out.println("�������ϰ�� : " + srcFilePath);
		System.out.println("�������Ͼ�� : " + srcLang);
		System.out.println("��ǥ��� : " + desFilePath);
		System.out.println("��ǥ��� : " + desLang);
		System.out.println("�ƹ�Ű");
		sc.next();
		sc.close();
		
		I18nTranslator i18n = new I18nTranslator(srcFilePath, srcLang, desFilePath, desLang);
		i18n.execute();
		
		
		
		
		
	}
}
