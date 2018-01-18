package Encrypt;

import java.awt.BorderLayout;
import java.io.*;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import org.apache.commons.codec.binary.*;
import org.apache.commons.codec.net.URLCodec;

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


public class Encryptor extends JFrame {
	private static final String ALGORITHM = "AES";
	private String iv;
	private static SecretKey key;
	private String plainText;
	
	private JPanel contentPane;
	private JTextField tfFileName, tfKey, tfPlainText;
	private JLabel lbFileName, lbKey, lbPlainText, lbEncryptor;
	private JButton btEncrypt;
	
	//ÇÁ·¹ÀÓ »ý¼º
	public Encryptor() {
		this.setTitle("Encryptor");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 700, 625);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		initGUI();
	}

	//ÇÁ·¹ÀÓ ÃÊ±âÈ­
	public void initGUI() {
		lbFileName = new JLabel("File Name");
		lbFileName.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 15));
		lbFileName.setBounds(59, 40, 100, 20);
		contentPane.add(lbFileName);

		tfFileName = new JTextField();
		tfFileName.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 15));
		tfFileName.setBounds(244, 40, 371, 20);
		contentPane.add(tfFileName);
		tfFileName.setColumns(10);

		lbKey = new JLabel("Key");
		lbKey.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 15));
		lbKey.setBounds(59, 65, 62, 18);
		contentPane.add(lbKey);

		tfKey = new JTextField();
		tfKey.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 15));
		tfKey.setBounds(244, 64, 371, 20);
		contentPane.add(tfKey);
		tfKey.setColumns(10);

		lbPlainText = new JLabel("PlainText");
		lbPlainText.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 15));
		lbPlainText.setBounds(59, 95, 65, 18);
		contentPane.add(lbPlainText);

		tfPlainText = new JTextField();
		tfPlainText.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 15));
		tfPlainText.setBounds(59, 125, 556, 397);
		contentPane.add(tfPlainText);
		tfPlainText.setColumns(10);

		lbEncryptor = new JLabel("ENCRYPTOR");
		lbEncryptor.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.BOLD, 17));
		lbEncryptor.setBounds(59, 10, 150, 18);
		contentPane.add(lbEncryptor);

		//Encrypt ¹öÆ° Å¬¸¯½Ã ÆÄÀÏ ÀúÀå
		btEncrypt = new JButton("Encrypt");
		btEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//ÆÄÀÏ ÀúÀå ±âº» À§Ä¡´Â C:\\
				JFileChooser fc = new JFileChooser(new File("C:\\"));
				fc.setDialogTitle("File Save");
				int result = fc.showSaveDialog(null);
				if(result == JFileChooser.APPROVE_OPTION) {
					String content = tfPlainText.getText();
					File file = fc.getSelectedFile();
					try{
						FileWriter fw = new FileWriter(file.getPath() + ".txt");
						fw.write(content);
						fw.flush();
						fw.close();
					}
					catch(Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				}
			}
		});
		
		btEncrypt.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 15));
		btEncrypt.setBounds(272, 534, 105, 27);
		contentPane.add(btEncrypt);
	}

	public void showEncryptor() {
		
	}

	public static String Encode(String plainKey) throws Exception {
		key = (SecretKey) KeyGenerator.getInstance(ALGORITHM);
		return plainKey;
		
		
	}
	public static void main(String[] args) {
		Encryptor E = new Encryptor();
		E.setVisible(true);
	}
}
