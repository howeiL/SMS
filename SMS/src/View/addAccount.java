package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import dao.AccountDao;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class addAccount {

	private JDialog frame;
	private JTextField textField;
	private JTextField textField_1;

	

	/**
	 * Create the application.
	 */
	public addAccount() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JDialog();
		
		
		frame.setTitle("\u6DFB\u52A0\u8D26\u53F7");
		frame.setBounds(100, 100, 552, 472);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String a=textField_1.getText();
				String p = textField.getText();
				
				AccountDao ad = new AccountDao();
				
					try {
						
						System.out.println(a);
					if(!ad.ishave(a)){
						ad.add(a, p);
						
						JOptionPane.showMessageDialog(null,"成功添加");
						textField_1.setText("");
						textField.setText("");
					}else{
						
						JOptionPane.showMessageDialog(null,"已存在该账号");
					}
					
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
		btnNewButton.setBounds(201, 349, 104, 38);
		panel.add(btnNewButton);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.BOLD, 18));
		textField.setColumns(10);
		textField.setBackground(SystemColor.menu);
		textField.setBounds(184, 222, 220, 32);
		panel.add(textField);
		
		JLabel label = new JLabel("\u5BC6\u7801\uFF1A");
		label.setFont(new Font("宋体", Font.BOLD, 22));
		label.setBounds(114, 221, 69, 31);
		panel.add(label);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.BOLD, 18));
		textField_1.setColumns(10);
		textField_1.setBackground(SystemColor.menu);
		textField_1.setBounds(184, 132, 220, 32);
		panel.add(textField_1);
		
		JLabel label_1 = new JLabel("\u8D26\u53F7\uFF1A");
		label_1.setFont(new Font("宋体", Font.BOLD, 22));
		label_1.setBounds(114, 125, 69, 43);
		panel.add(label_1);
		
		
		frame.setLocationRelativeTo(null);
		frame.setModal(true);
		frame.setVisible(true);
	}
}
