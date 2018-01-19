package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
Copyright 2018 LeeSeeun 

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

public class Main extends JFrame {
	JTabbedPane Tab = new JTabbedPane();
	JPanel EPanel, DPanel;
	private JTextField tfEP, tfEC, tfDP, tfDC;
	private JButton btEncrypt, btDecrypt, btSave, btLoad;
	private JFileChooser fc;
	public Main() {
		super("Secret Memo");
		setSize(1200, 900);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		EPanel = new JPanel();
		DPanel = new JPanel();

		Tab.addTab("ENCRYPTOR", null, EPanel, "Plain Text -> Ciper Text");
		Tab.addTab("DECRYPTOR", null, DPanel, "Ciper Text -> Plain Text");

		EPanel.setLayout(new BoxLayout(EPanel, BoxLayout.X_AXIS));


		tfEP = new JTextField("암호화 할 평문");
		tfEP.setHorizontalAlignment(SwingConstants.CENTER);
		tfEC = new JTextField("암호문");
		tfEC.setHorizontalAlignment(SwingConstants.CENTER);

		EPanel.add(Box.createVerticalGlue());

		EPanel.add(tfEP);

		btEncrypt = new JButton(">>ENCRYPT>>");
		btEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});

		btSave = new JButton("저장하기");
		btSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//파일 저장 기본 위치는 C:\\
				JFileChooser fc = new JFileChooser(new File("C:\\"));
				fc.setDialogTitle("File Save");
				int result = fc.showSaveDialog(null);
				if(result == JFileChooser.APPROVE_OPTION) {
					String content = tfEC.getText();
					File file = fc.getSelectedFile();
					try{
						FileWriter fw = new FileWriter(file.getPath() + ".txt");
						fw.write(content);
						fw.flush();
						fw.close();
					}
					catch(Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}}	
		});
		
		EPanel.add(btSave);
		btEncrypt.setAlignmentX(Component.RIGHT_ALIGNMENT);
		EPanel.add(btEncrypt);
		EPanel.add(tfEC);
		EPanel.add(Box.createVerticalGlue());

		DPanel.setLayout(new BoxLayout(DPanel, BoxLayout.X_AXIS));
		tfDC = new JTextField("복호화 할 암호문");
		tfDC.setHorizontalAlignment(SwingConstants.CENTER);
		tfDP = new JTextField("평문");
		tfDP.setHorizontalAlignment(SwingConstants.CENTER);
		DPanel.add(Box.createVerticalGlue());
		DPanel.add(tfDC);
		
		btLoad = new JButton("불러오기");
		btLoad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						fc = new JFileChooser(new File("C:\\"));
						FileNameExtensionFilter filter = new FileNameExtensionFilter("텍스트 파일", "txt");
						fc.setDialogTitle("File Load");
						int result = fc.showOpenDialog(null);
						if(result == JFileChooser.APPROVE_OPTION) {
							File file = fc.getSelectedFile();
							try {
								BufferedReader br = new BufferedReader(new FileReader(file.getPath()));
								String l = "";
								String data = "";
								while((l = br.readLine()) != null)
								{
									data += l + "\n";
								}
								tfDC.setText(data);
								if (br != null)
									br.close();
							}catch(Exception e1) {
								JOptionPane.showMessageDialog(null, e1.getMessage());;
							}
						}
					}
			});
		DPanel.add(btLoad);

		btDecrypt = new JButton(">>DECRYPT>>");
		DPanel.add(btDecrypt);
		DPanel.add(tfDP);
		DPanel.add(Box.createVerticalGlue());

		getContentPane().add(Tab, BorderLayout.CENTER);
	}


	public static void main(String args[]) {
		Main M = new Main();
		M.setVisible(true);
	}
}