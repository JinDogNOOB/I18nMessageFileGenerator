package i18n_message_file_generator.constants;

public enum AvailableLanguages{    
    KOREAN("ko"),
    ENGLISH("en"),
    JAPANESE("ja"),
    GERMANY("de"),
    CHINESE("zh-CN"),
    TIWANESE("zh-TW"),
    FRENCH("fr");


    private final String langCode;

    private AvailableLanguages(String code){
        langCode = code;
    }
    
    public String getLangCode(){
        return langCode;
    }

    public static void printLangCodes() {
		for(AvailableLanguages lang : AvailableLanguages.values()) {
			System.out.println("languageName : " +lang.toString() + "\t\t languageCode : " + lang.getLangCode());
		}
		// System.out.println(AvailableLanguages.CN.getLangCode());
		// System.out.println(AvailableLanguages.CN.toString());
		// System.out.println(AvailableLanguages.valueOf("KOREAN").getLangCode());
	}
    
}