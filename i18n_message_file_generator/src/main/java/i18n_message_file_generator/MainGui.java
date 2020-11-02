package i18n_message_file_generator;

import java.awt.Container;
import java.awt.FileDialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainGui extends JFrame{
	// https://unikys.tistory.com/178 참고
	public MainGui() {
		super("Event Fire");
		
		// 위치와 크기 설정 x y width height
		setBounds(100, 100, 500, 500);
		// 닫기 버튼 눌렀을때 어떻게할지
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 가시
		Container contentPane = this.getContentPane();
		
		
		
		
		// i18n 파일로 번역 시작 버튼
		JButton testStartButton = new JButton("TaskStart");
		testStartButton.setMnemonic('S');
		testStartButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				selectFile();
			}
		});
		
		

		
		JLabel inputSrcMessageFileText = new JLabel("srcMessageFile :");
		JLabel srcMessageFilePath= new JLabel("empty");
		
		JLabel srcLangText = new JLabel("Src Lang Code :");
		JLabel srcLang = new JLabel("empty");
		
		
		JLabel dscLangText = new JLabel("Des Lang Code :");
		JLabel dscLang = new JLabel("empty");
		
		
		
		// ############################### 패널
		JPanel pane1 = new JPanel();
		pane1.setLayout(new GridLayout(0, 2, 1, 1));
		pane1.add(inputSrcMessageFileText);
		pane1.add(srcMessageFilePath);
		
		JPanel pane2 = new JPanel();
		pane2.setLayout(new GridLayout(0, 2, 1, 1));
		pane2.add(srcLangText);
		pane2.add(srcLang);
		
		
		JPanel pane3 = new JPanel();
		pane3.setLayout(new GridLayout(0, 2, 1, 1));
		pane3.add(dscLangText);
		pane3.add(dscLang);
		
		contentPane.add(pane1);
		contentPane.add(pane2);
		contentPane.add(pane3);
		
		setVisible(true);
	}
	
	
	private String selectFile() {
		FileDialog fd = new FileDialog(this, "file select", FileDialog.LOAD);
		fd.setVisible(true);
		
		StringBuilder sb = new StringBuilder();
		sb.append(fd.getDirectory());
		sb.append(fd.getFile());
		return sb.toString();
	}
	
//	private String selectDir() {
//		FileDialog fd = new FileDialog(this, "select dir", FileDialog.SAVE);
//		fd.setVisible(true);
//		
//		StringBuilder sb = new StringBuilder();
//		sb.append(fd.getDirectory());
//		sb.append(fd.getFile());
//		return sb.toString();
//	}

}
