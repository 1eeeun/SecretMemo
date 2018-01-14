package Decrypt;

import java.awt.BorderLayout;
import java.io.*;
import java.awt.EventQueue;
import javax.crypto.Cipher;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
