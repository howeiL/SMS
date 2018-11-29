package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.AccountDao;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class Frame {

	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;
	
	private static String account;
	private static String password;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame window = new Frame();
					
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setTitle("\u767B\u9646");
		frame.getContentPane().setBackground(SystemColor.menu);
		
	
		
		frame.getContentPane().setFont(new Font("华文仿宋", Font.BOLD, 17));
		frame.setBounds(100, 100, 904, 579);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
	    passwordField.setBounds(301, 296, 286, 31);
		frame.getContentPane().add(passwordField);
		
		JLabel label = new JLabel("\u5BC6\u7801\uFF1A");
		label.setFont(new Font("宋体", Font.BOLD, 19));
		label.setBounds(237, 294, 65, 31);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			
			     
			}
		});
		textField.setBounds(301, 229, 286, 31);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 19));
		lblNewLabel.setBounds(237, 227, 65, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("       \u5B66\u751F\u7BA1\u7406\u7CFB\u7EDF");
		
		
		lblNewLabel_1.setFont(new Font("华文行楷", Font.BOLD, 50));
		lblNewLabel_1.setBounds(166, 57, 544, 114);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("\u767B\u9646");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				account=textField.getText();
				password = passwordField.getText();
		
				try {
				
					if(AccountDao.signIn(account, password)){
						
						System.out.println("a");
						frame.setVisible(false);
						Frame2.main(null);
					}else{
						JOptionPane.showMessageDialog(null, "输入错误");
						
						
								
				} 
				    }catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
	
			}

			
		});
		btnNewButton.setFont(new Font("华文细黑", Font.BOLD, 21));
		btnNewButton.setBounds(367, 374, 119, 50);
		frame.getContentPane().add(btnNewButton);
		frame.setLocationRelativeTo(null);
	}
	

}
