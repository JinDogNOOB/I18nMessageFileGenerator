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
		
//		String text = "æ»≥Á«œººø‰";
//		
//		Translate translate = TranslateOptions.getDefaultInstance().getService();
//		
//		Translation translation = translate.translate(text, TranslateOption.sourceLanguage("ko"), TranslateOption.targetLanguage("en"));
//		
//		String result = translation.getTranslatedText();
//		
//		System.out.println("Text: "+text);
//		System.out.println("Translation: "+result);

		new MainCli();

		
		return;
	}
	

}

