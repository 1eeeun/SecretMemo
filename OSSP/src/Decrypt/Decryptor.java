package Decrypt;

import java.awt.BorderLayout;
import java.io.*;
import java.awt.EventQueue;
import javax.crypto.Cipher;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
		tf.setBounds(59, 53, 556, 469);
		contentPane.add(tf);
		tf.setColumns(10);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Decryptor D = new Decryptor();
		D.setVisible(true);
	}


}
