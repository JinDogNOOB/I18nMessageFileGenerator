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
		
		String engine = "google";
		
		String ex = "txt";
		
		
		// 기반파일 경로 입력
		Scanner sc = new Scanner(System.in);
		
		System.out.println("원본파일이름 입력하세요");
		srcFilePath = System.getProperty("user.dir") + File.separator + sc.next();
		
		System.out.println("원본파일의 언어를 입력하세요");
		I18nTranslator.printLangCodes();
		srcLang = I18nTranslator.getLangCode(sc.nextInt());
		
		// System.out.println(srcFilePath.substring(srcFilePath.length() - "json".length(), srcFilePath.length()-1));
		// System.out.println("파일 확장자를 선택하세요 0:properties 1:json");
		if(srcFilePath.length() > "json".length() &&
				srcFilePath.substring(srcFilePath.length() - "json".length(), srcFilePath.length()).contentEquals("json")) {
			System.out.println(".json 확인");
			ex = "properties";
			mode = 1;
		}
		else if(srcFilePath.length() > "properties".length() && 
				srcFilePath.substring(srcFilePath.length() - "properties".length(), srcFilePath.length()).contentEquals("properties")) {
			System.out.println(".properties 확인");
			ex = "properties";
			mode = 0;
		}
		else {
			System.out.println("default...properties");
			ex = "properties";
			mode = 0;
		}
		
		System.out.println("원하시는 언어를 입력하세요");
		I18nTranslator.printLangCodes();
		desLang = I18nTranslator.getLangCode(sc.nextInt());
		
		desFilePath = System.getProperty("user.dir") + File.separator + desLang + "." + ex;
		
		
		System.out.println("엔진 입력하세요. google, yandex, bing");
		engine = sc.next();

		
		System.out.println("######################");
		System.out.println("원본파일경로 : " + srcFilePath);
		System.out.println("원본언어 : " + srcLang);
		System.out.println("목표파일경로 : " + desFilePath);
		System.out.println("목표언어 : " + desLang);
		System.out.println("엔진 : " + engine);
		System.out.println("아무키");
		sc.next();
		sc.close();
		
		I18nTranslator i18n;
		switch(mode) {
			case 0:{
				// properties
				i18n = new I18nTranslatorUsingProperties(srcFilePath, srcLang, desFilePath, desLang, engine);
				break;
			}
			case 1:{
				// json
				i18n = new I18nTranslatorUsingJson(srcFilePath, srcLang, desFilePath, desLang, engine);
				break;
			}
			default:{
				// properties
				i18n = new I18nTranslatorUsingProperties(srcFilePath, srcLang, desFilePath, desLang, engine);
				break;
			}
		}
		 
		i18n.execute();
		
		
		
		return;
		
	}
}
