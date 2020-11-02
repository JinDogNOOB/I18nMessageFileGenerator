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
		
		
		// 기반파일 경로 입력
		Scanner sc = new Scanner(System.in);
		
		System.out.println("원본파일경로 입력하세요");
		srcFilePath = System.getProperty("user.dir") + File.separator + sc.next();
		
		System.out.println("원본파일의 언어를 입력하세요");
		I18nTranslator.printLangCodes();
		srcLang = I18nTranslator.getLangCode(sc.nextInt());
		
		
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("저장할 경로를 입력하세요");
		desFilePath = System.getProperty("user.dir") + File.separator + sc.next();
		
		System.out.println("원하시는 언어를 입력하세요");
		I18nTranslator.printLangCodes();
		desLang = I18nTranslator.getLangCode(sc.nextInt());
		
		System.out.println("######################");
		System.out.println("원본파일경로 : " + srcFilePath);
		System.out.println("원본파일언어 : " + srcLang);
		System.out.println("목표경로 : " + desFilePath);
		System.out.println("목표언어 : " + desLang);
		System.out.println("아무키");
		sc.next();
		sc.close();
		
		I18nTranslator i18n = new I18nTranslator(srcFilePath, srcLang, desFilePath, desLang);
		i18n.execute();
		
		
		
		
		
	}
}
