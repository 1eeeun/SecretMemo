package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Encrypt.Encryptor;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	private JButton btEncrypt, btDecrypt;

	//ÇÁ·¹ÀÓ »ý¼º
	public Main() {
		this.setTitle("Secret Memo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		initGUI();

		class Listener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource().equals(btEncrypt)) {
					//Encrypt·Î ÀÌµ¿
				}
				else if(e.getSource() == btDecrypt) {
					//Decrypt·Î ÀÌµ¿
				}
			}
		}
	}

	public void initGUI() {
		btEncrypt = new JButton("Encrypt");
		btEncrypt.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 20));
		btEncrypt.setBounds(120, 70, 180, 30);
		contentPane.add(btEncrypt);

		btDecrypt = new JButton("Decrypt");
		btDecrypt.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 20));
		btDecrypt.setBounds(118, 141, 182, 27);
		contentPane.add(btDecrypt);
	}


	public static void main(String[] args) {

		Main M = new Main();
		M.setVisible(true);
	}


}
