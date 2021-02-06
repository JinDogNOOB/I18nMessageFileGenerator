package i18n_message_file_generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Translator {
	
	/**
	 * https://cofs.tistory.com/365
     * cmd ��ɾ� ����
     *
     * @param cmd
     */
	
    public static String translate(String srcString, String srcLangCode, String desLangCode, String engine) {
        Process process = null;
        Runtime runtime = Runtime.getRuntime();
        StringBuffer successOutput = new StringBuffer(); // ���� ��Ʈ�� ����
        StringBuffer errorOutput = new StringBuffer(); // ���� ��Ʈ�� ����
        BufferedReader successBufferReader = null; // ���� ����
        BufferedReader errorBufferReader = null; // ���� ����
        String msg = null; // �޽���
        String result = "null";
 
        List<String> cmdList = new ArrayList<String>();
 
        // �ü�� ���� (window, window �� �ƴϸ� ������ linux �� �Ǵ�)

        cmdList.add("crow");
        cmdList.add("-b");
        cmdList.add("-e");
        cmdList.add(engine);
        cmdList.add("-s");
        cmdList.add(srcLangCode);
        cmdList.add("-t");
        cmdList.add(desLangCode);
        cmdList.add(srcString);
        
        String[] array = cmdList.toArray(new String[cmdList.size()]);
 
        
        try {
            // ��ɾ� ����
            process = runtime.exec(array);
 
            // shell ������ ���� �������� ���
            successBufferReader = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
 
            while ((msg = successBufferReader.readLine()) != null) {
                successOutput.append(msg + System.getProperty("line.separator"));
            }
 
            // shell ����� ������ �߻����� ���
            errorBufferReader = new BufferedReader(new InputStreamReader(process.getErrorStream(), "UTF-8"));
            while ((msg = errorBufferReader.readLine()) != null) {
                errorOutput.append(msg + System.getProperty("line.separator"));
            }
 
            // ���μ����� ������ ���������� ���
            process.waitFor();
 
            // shell ������ ���� ����Ǿ��� ���
            if (process.exitValue() == 0) {
            	result = successOutput.toString();
                System.out.println(result);
                
            }
 
 
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                process.destroy();
                if (successBufferReader != null) successBufferReader.close();
                if (errorBufferReader != null) errorBufferReader.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return result;
        
    }


	
	

}
