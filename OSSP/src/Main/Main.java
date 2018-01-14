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
	//������ ����
	public Main() {
		this.setTitle("Secret Memo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		init();

		class Listener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource().equals(btEncrypt)) {
					new Encryptor();
				}
				else if(e.getSource().equals(btDecrypt)) {
					/**
					 * ���� �ҷ�����
					 */
				}
			}
		}
	}

	public void init() {
		btEncrypt = new JButton("Encrypt");
		btEncrypt.setFont(new Font("������� ExtraBold", Font.PLAIN, 20));
		btEncrypt.setBounds(120, 70, 180, 30);
		contentPane.add(btEncrypt);

		btDecrypt = new JButton("Decrypt");
		btDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fs = new JFileChooser(new File("C:\\"));
				fs.setDialogTitle("File Load");
				int result = fs.showOpenDialog(null);
				if(result == JFileChooser.APPROVE_OPTION) {
					File file = fs.getSelectedFile();
					try {
						BufferedReader br = new BufferedReader(new FileReader(file.getPath()));

						//������ �ε��ϸ� Decryptor�� tf�� �߰Բ� ����
					}catch(Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());;
					}
				}
			}
		});
		btDecrypt.setFont(new Font("������� ExtraBold", Font.PLAIN, 20));
		btDecrypt.setBounds(118, 141, 182, 27);
		contentPane.add(btDecrypt);
	}


	public static void main(String[] args) {

		Main M = new Main();
		M.setVisible(true);
	}


}
