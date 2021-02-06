package i18n_message_file_generator;

import java.io.File;
import java.io.IOException;

import i18n_message_file_generator.constants.AvailableLanguages;


public class Main{
	
	public static void main(String[] args) throws IOException {

	
		if(args.length != 4) {
			System.out.println("Usage: <srcFileName> <srcLanguageName> <desLanguageName> <engineName>");
			System.out.println("Example: java -jar this /usr/local/ko.json korean english bing");
			System.out.println("if you want all language file just input 'all' at desLanguage");
			System.out.println("=============================================================");
			AvailableLanguages.printLangCodes();
		}else {
			if(args[2].contentEquals("all")) {
				for(AvailableLanguages lang : AvailableLanguages.values()) {
					if(lang.getLangCode().contentEquals(AvailableLanguages.valueOf(args[1].toUpperCase()).getLangCode())) {
						continue;
					}else {
						init(args[0],AvailableLanguages.valueOf(args[1].toUpperCase()).getLangCode(), lang.getLangCode(), args[3]);
					}
				}
			}else {
				init(args[0], 
				AvailableLanguages.valueOf(args[1].toUpperCase()).getLangCode(), 
				AvailableLanguages.valueOf(args[2].toUpperCase()).getLangCode(), 
				args[3]);
			}
		}
		
		return;
	}
	


	public static void init(String srcFileName, String srcLangCode, String desLangCode, String engineName) throws IOException {

		String extension = getExtension(srcFileName);
		String srcFilePath = System.getProperty("user.dir") + File.separator + srcFileName;
		String desFilePath = System.getProperty("user.dir") + File.separator + desLangCode + "." + extension;
		


		
		System.out.println("##########################");
		System.out.println("srcFilePath: " + srcFilePath);
		System.out.println("srcLangCode : " + srcLangCode);
		System.out.println("desFilePath : " + desFilePath);
		System.out.println("desLangCode : " + desLangCode);
		System.out.println("engine : " + engineName);
		System.out.println("##########################");


		I18nTranslator i18n;
		
		switch(extension) {
			case "PROPERTIES" :{
				// properties
				i18n = new I18nTranslatorProperties(srcFilePath, srcLangCode, desFilePath, desLangCode, engineName);
				break;
			}
			case "JSON":{
				// json
				i18n = new I18nTranslatorJson(srcFilePath, srcLangCode, desFilePath, desLangCode, engineName);
				break;
			}
			default:{
				i18n = new I18nTranslatorJson(srcFilePath, srcLangCode, desFilePath, desLangCode, engineName);
				break;
			}
		}
		 
		i18n.execute();
	
		return;	
	}

	/** return fileNames extension without dot  ex) JSON */
	private static String getExtension(String fileNameWithExtension){
		for(int i = 0; i < fileNameWithExtension.length(); i++){
			if(fileNameWithExtension.charAt(i) == '.'){
				return fileNameWithExtension.substring(i+1, fileNameWithExtension.length()).toUpperCase();
			}
		}
		return "TXT";
	}

}

