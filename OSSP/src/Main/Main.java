package Main;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import javax.swing.JLabel;

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
	private static JTextField tfEKey;
	private static JTextField tfDKey;
	String tempE, tempD, tempEKey, tempDKey;
	private JLabel lbKey2;
	private JLabel lbKey1;
	public Main() {
		super("Secret Memo");
		setSize(1200, 900);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		initGUI();
	}

	public void initGUI() {
		EPanel = new JPanel();
		DPanel = new JPanel();

		Tab.addTab("ENCRYPTOR", null, EPanel, "Plain Text -> Cipher Text");
		Tab.addTab("DECRYPTOR", null, DPanel, "Cipher Text -> Plain Text");


		tfEP = new JTextField("암호화 할 평문");
		tfEP.setBounds(50, 85, 450, 650);
		tfEP.setHorizontalAlignment(SwingConstants.CENTER);
		tfEC = new JTextField("암호문");
		tfEC.setBounds(675, 85, 450, 650);
		tfEC.setHorizontalAlignment(SwingConstants.CENTER);
		EPanel.setLayout(null);

		EPanel.add(tfEP);

		btEncrypt = new JButton(">>ENCRYPT>>");
		btEncrypt.setBounds(510, 400, 155, 30);
		btEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tempEKey = tfEKey.getText();
				tempE = tfEP.getText();
				try {
					if(tempEKey.length() < 20) {
						JOptionPane.showMessageDialog(null, "Key의 길이는 최소 20자 입니다.");
					}else{
						tfEC.setText(Encryption(tempE, tempEKey));
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btSave = new JButton("SAVE");
		btSave.setBounds(510, 760, 155, 30);
		btSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser fc = new JFileChooser(new File("C:\\"));				//파일 저장 기본 위치는 C:\\
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

		tfEKey = new JTextField("");
		tfEKey.setHorizontalAlignment(SwingConstants.LEFT);
		tfEKey.setBounds(408, 30, 361, 24);
		EPanel.add(tfEKey);
		tfEKey.setColumns(10);

		lbKey1 = new JLabel("Key");
		lbKey1.setBounds(332, 33, 62, 18);
		EPanel.add(lbKey1);
		tfDC = new JTextField("복호화 할 암호문");
		tfDC.setBounds(50, 85, 450, 650);
		tfDC.setHorizontalAlignment(SwingConstants.CENTER);
		tfDP = new JTextField("평문");
		tfDP.setBounds(675, 85, 450, 650);
		tfDP.setHorizontalAlignment(SwingConstants.CENTER);
		DPanel.setLayout(null);
		DPanel.add(tfDC);

		btLoad = new JButton("LOAD");
		btLoad.setBounds(510, 760, 155, 30);
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
		btDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tempDKey = tfDKey.getText();
				tempD = tfDC.getText();

				try {
					if(tempDKey.length() < 20) {
						JOptionPane.showMessageDialog(null, "Key의 길이는 최소 20자 입니다.");
					}else {
						tfEC.setText(Decryption(tempD, tempDKey));
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btDecrypt.setBounds(510, 400, 155, 30);
		DPanel.add(btDecrypt);
		DPanel.add(tfDP);

		tfDKey = new JTextField();
		tfDKey.setColumns(10);
		tfDKey.setBounds(408, 30, 361, 24);
		DPanel.add(tfDKey);

		lbKey2 = new JLabel("Key");
		lbKey2.setBounds(332, 33, 62, 18);
		DPanel.add(lbKey2);

		getContentPane().add(Tab, BorderLayout.CENTER);
	}

	/*final static String KEY = tfEKey.getText();
	final static String KEY_128 = KEY.substring(0, 128/8);

	public static String encrypt(String data) {
		try {
			byte[] keyData = KEY_128.getBytes(CharEncoding.UTF_8);
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

			cipher.init(Cipher.ENCRYPT_MODE,new SecretKeySpec(keyData, "AES"));

			byte[] encrypted = cipher.doFinal(data.getBytes(CharEncoding.UTF_8));
			byte[] base64Encoded = Base64.encodeBase64(encrypted);

			String result = new String(base64Encoded, CharEncoding.UTF_8);

			return result;
		}
		catch(Exception e) {
			return null;
		}
	}

	public static String decrypt(String data) {
		try {
			byte[] keyData = KEY_128.getBytes(CharEncoding.UTF_8);

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

			cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(keyData, "AES"), new IvParameterSpec(keyData));

			byte[] base64Decoded = Base64.decodeBase64(data.getBytes(CharEncoding.UTF_8));

			byte[] decrypted = cipher.doFinal(base64Decoded);

			String result = new String(decrypted, CharEncoding.UTF_8);

			return result;
		}
		catch(Exception e) {
			return null;
		}


	}*/
	public String Encryption(String msg, String key) throws Exception{
		byte[] bytes = key.getBytes();
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		sr.setSeed(bytes);
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		kgen.init(128, sr);

		SecretKey skey = kgen.generateKey();
		SecretKeySpec skeySpec = new SecretKeySpec(skey.getEncoded(), "AES");

		Cipher c = Cipher.getInstance("AES");
		c.init(Cipher.ENCRYPT_MODE, skeySpec);

		byte[] encrypted = c.doFinal(msg.getBytes());
		return Hex.encodeHexString(encrypted);
	}

	public String Decryption(String msg, String key) throws Exception{
		byte[] bytes = key.getBytes();
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		sr.setSeed(bytes);
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		kgen.init(128, sr);

		SecretKey skey = kgen.generateKey();
		SecretKeySpec skeySpec = new SecretKeySpec(skey.getEncoded(), "AES");

		Cipher c = Cipher.getInstance("AES");
		c.init(Cipher.DECRYPT_MODE, skeySpec);

		byte[] decrypted = c.doFinal(Hex.decodeHex(msg.toCharArray()));
		return new String(decrypted);
	}


	public static void main(String args[]) {
		Main M = new Main();
		M.setVisible(true);
	}
}