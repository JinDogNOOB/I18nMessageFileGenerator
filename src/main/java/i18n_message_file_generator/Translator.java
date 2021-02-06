package i18n_message_file_generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Translator {
	
	/**
	 * https://cofs.tistory.com/365
     * cmd 명령어 실행
     *
     * @param cmd
     */
	
    public static String translate(String srcString, String srcLangCode, String desLangCode, String engine) {
        Process process = null;
        Runtime runtime = Runtime.getRuntime();
        StringBuffer successOutput = new StringBuffer(); // 성공 스트링 버퍼
        StringBuffer errorOutput = new StringBuffer(); // 오류 스트링 버퍼
        BufferedReader successBufferReader = null; // 성공 버퍼
        BufferedReader errorBufferReader = null; // 오류 버퍼
        String msg = null; // 메시지
        String result = "null";
 
        List<String> cmdList = new ArrayList<String>();
 
        // 운영체제 구분 (window, window 가 아니면 무조건 linux 로 판단)

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
            // 명령어 실행
            process = runtime.exec(array);
 
            // shell 실행이 정상 동작했을 경우
            successBufferReader = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
 
            while ((msg = successBufferReader.readLine()) != null) {
                successOutput.append(msg + System.getProperty("line.separator"));
            }
 
            // shell 실행시 에러가 발생했을 경우
            errorBufferReader = new BufferedReader(new InputStreamReader(process.getErrorStream(), "UTF-8"));
            while ((msg = errorBufferReader.readLine()) != null) {
                errorOutput.append(msg + System.getProperty("line.separator"));
            }
 
            // 프로세스의 수행이 끝날때까지 대기
            process.waitFor();
 
            // shell 실행이 정상 종료되었을 경우
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
