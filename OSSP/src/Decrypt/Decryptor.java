package Decrypt;

import java.awt.BorderLayout;
import java.io.*;
import java.awt.EventQueue;
import javax.crypto.Cipher;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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


public class Decryptor extends JFrame {

	private JPanel contentPane;
	private JTextField tf;
	private JButton keyId;
	private JTextField textField;
	private JFileChooser fc;
	/**
	 * Create the frame.
	 */
	public Decryptor() {
		this.setTitle("Decryptor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 625);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tf = new JTextField();
		tf.setBounds(60, 120, 555, 400);
		contentPane.add(tf);
		tf.setColumns(10);
		
		JButton button = new JButton("ºÒ·¯¿À±â");
		button.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 15));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					fc = new JFileChooser(new File("C:\\"));
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
							tf.setText(data);
							if (br != null)
								br.close();
						}catch(Exception e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage());;
						}
					}
				}
		});
		button.setBounds(510, 58, 105, 27);
		contentPane.add(button);
		
		JLabel label = new JLabel("DECRYPTOR");
		label.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.BOLD, 17));
		label.setBounds(60, 15, 150, 18);
		contentPane.add(label);
		
		keyId = new JButton("Å° È®ÀÎ");
		keyId.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 15));
		keyId.setBounds(386, 58, 105, 27);
		contentPane.add(keyId);
		
		textField = new JTextField();
		textField.setBounds(60, 59, 296, 24);
		contentPane.add(textField);
		textField.setColumns(10);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Decryptor D = new Decryptor();
		D.setVisible(true);
	}


}
