package i18n_message_file_generator;



public abstract class I18nTranslator {
	protected String srcFile;
	protected String srcLangCode;
	protected String desFile;
	protected String desLangCode;
	protected String engine;


	/**
	 * @param srcFile : src file path ex) /usr/local/en.json
	 * @param srcLangCode : lang of src file ex) en
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
	
	/**
	 * start translation
	 */
	public abstract void execute();
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