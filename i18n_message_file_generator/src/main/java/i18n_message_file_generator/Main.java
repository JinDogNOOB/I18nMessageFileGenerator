package i18n_message_file_generator;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class Main{
	public static void main(String[] args) throws IOException {
		// new MainGui();
		
//		String text = "안녕하세요";
//		
//		Translate translate = TranslateOptions.getDefaultInstance().getService();
//		
//		Translation translation = translate.translate(text, TranslateOption.sourceLanguage("ko"), TranslateOption.targetLanguage("en"));
//		
//		String result = translation.getTranslatedText();
//		
//		System.out.println("Text: "+text);
//		System.out.println("Translation: "+result);

		// new MainCli();
		
		if(args.length != 4) {
			System.out.println("Usage: <srcFileName> <srcLanguage> <desLanguage> <engineName>");
			System.out.println("전체 언어는 all");
			I18nTranslator.printLangCodes();
		}else {
			if(args[2].contentEquals("all")) {
				String[] tempLangList = I18nTranslator.langCode;
				for(String langName : tempLangList) {
					if(langName.contentEquals(args[1])) {
						System.out.println("같은언어 패스");
					}else {
						MainCli.test(args[0], args[1], langName, args[3]);
					}
				}
				
			}else {
				MainCli.test(args[0], args[1], args[2], args[3]);
			}
			
		}
		
		
		

		
		return;
	}
	

}

