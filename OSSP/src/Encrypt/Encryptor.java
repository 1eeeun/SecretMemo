package Encrypt;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JButton;

public class Encryptor extends JFrame {

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
		
		init();
		
	}
	
	//ÇÁ·¹ÀÓ ÃÊ±âÈ­
	public void init() {
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
		
		btEncrypt = new JButton("Encrypt");
		btEncrypt.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 15));
		btEncrypt.setBounds(272, 534, 105, 27);
		contentPane.add(btEncrypt);
	}

	class Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource().equals(btEncrypt)) {
				/**
				 * ÆÄÀÏ ÀúÀå
				 */
			}
		}
		
	}
	
	public static void main(String[] args) {
		Encryptor E = new Encryptor();
		E.setVisible(true);
	}
}
