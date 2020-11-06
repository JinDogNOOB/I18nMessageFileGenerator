package i18n_message_file_generator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;



public class I18nTranslatorUsingJson extends I18nTranslator{

	public I18nTranslatorUsingJson(String srcFile, String srcLangCode, String desFile, String desLangCode, String engine) {
		super(srcFile, srcLangCode, desFile, desLangCode, engine);
		// TODO Auto-generated constructor stub
	}

	public void execute(){
		// 작업 시작
		JsonObject jsonObject = getJsonFile(srcFile);
		JsonObject result = doJsonRecurWithTranslation(jsonObject);
		
		try(FileWriter file = new FileWriter(desFile)){
			// Gson 
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			
			String prettyJsonString = gson.toJson(result);
			file.write(prettyJsonString);
			
			file.flush();
			file.close();
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}
		/*
		여기는 더럽게 한줄로 프린팅한다
		try {
			FileOutputStream fos = new FileOutputStream(new File(desFile));
			fos.write(result.toString().getBytes());
		}catch(IOException e) {
			e.printStackTrace();
		}	
		*/
	}
	
	private JsonObject doJsonRecurWithTranslation(JsonObject jsonObject) {
		JsonObject result = new JsonObject();
		Set<Entry<String, JsonElement>> set = jsonObject.entrySet();
		for(Entry<String, JsonElement> s : set) {
			
			if(s.getValue().isJsonObject()) result.add(s.getKey(), doJsonRecurWithTranslation(s.getValue().getAsJsonObject()));
			else if(s.getValue().isJsonPrimitive()) result.addProperty(s.getKey(), Translator.translate(s.getValue().getAsString(), srcLangCode , desLangCode, engine));
			else System.out.println("?");
		}
		return result;
	}
	
	private void doJsonRecur(JsonObject jsonObject) {
		Set<Entry<String, JsonElement>> set = jsonObject.entrySet();
		for(Entry<String, JsonElement> s : set) {
			
			if(s.getValue().isJsonObject()) doJsonRecur(s.getValue().getAsJsonObject());
			else if(s.getValue().isJsonPrimitive()) System.out.println(s.getKey() +" : " + s.getValue().toString());
			else System.out.println("?");
		}
		
	}
	
	private JsonObject getJsonFile(String src) {
		// JsonParser jsonParser = new JsonParser();
		// json is supposed to be encoded in utf-8
		JsonObject jsonObject = null;
		
		try {
			jsonObject = JsonParser.parseReader(new FileReader(new File(src))).getAsJsonObject();
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonObject;
	}
	
	
}
