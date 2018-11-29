package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import action.Action;
import dao.StudentDao;
import model.Student;
import java.awt.SystemColor;

public class addFrame {

	private static   JDialog frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;


	public addFrame() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new  JDialog();	
		frame.setTitle("\u6DFB\u52A0\u6570\u636E");
		
		frame.setModal(true);
		frame.setBounds(100, 100, 854, 590);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaptionBorder);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblJdialog = new JLabel("ID\uFF1A");
		lblJdialog.setFont(new Font("宋体", Font.BOLD, 22));
		lblJdialog.setBounds(268, 98, 47, 31);
		panel.add(lblJdialog);
		
		textField = new JTextField();
		textField.setBackground(SystemColor.menu);
		textField.setFont(new Font("宋体", Font.BOLD, 18));
		textField.setBounds(323, 100, 220, 32);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u59D3\u540D\uFF1A");
		label.setFont(new Font("宋体", Font.BOLD, 22));
		label.setBounds(253, 163, 69, 31);
		panel.add(label);
		
		JLabel label_1 = new JLabel("\u6027\u522B\uFF1A");
		label_1.setFont(new Font("宋体", Font.BOLD, 22));
		label_1.setBounds(253, 229, 69, 31);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\u5E74\u9F84\uFF1A");
		label_2.setFont(new Font("宋体", Font.BOLD, 22));
		label_2.setBounds(253, 293, 69, 31);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("\u73ED\u7EA7\uFF1A");
		label_3.setFont(new Font("宋体", Font.BOLD, 22));
		label_3.setBounds(253, 359, 69, 31);
		panel.add(label_3);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				String id=textField.getText();
				String name =textField_1.getText();
				String sex =textField_2.getText();
				String age =textField_3.getText();
				String clazz =textField_4.getText();
					
				Action a = new Action();
				boolean b = false;
				try {
					b = a.isget(Integer.valueOf(id));
				}catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				if(id.matches("\\d++")){
					if(!b){
					if(name.matches("\\D++")){
						
						if(sex.matches("男|女|不详")){
							
							if(age.matches("\\d++")){
								
								if(clazz.matches("[\u4E00-\u9FA5]{2,}\\d{4}")){

									JOptionPane.showMessageDialog(null,"成功添加");
								
									Student s = new Student();
									s.setAge(Integer.parseInt(age));
									s.setClazz(clazz);
									s.setId(Integer.parseInt(id));
									s.setSex(sex);
									s.setName(name);
									
									try {
										a.add(s);
									} catch (Exception e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									deltext();
							
									 String[] args=s.toString().split(",");
									 Frame2.model.addRow(args);
									 
									 
								}else{
									JOptionPane.showMessageDialog(null,"班级错误,请正确输入");				
									
									
								}
							}else{
								JOptionPane.showMessageDialog(null,"年龄错误，输入数字");
								
							}
						}else{
							JOptionPane.showMessageDialog(null,"性别只能输入:男,女,不详");
							
						}
					}else{
						JOptionPane.showMessageDialog(null,"姓名错误,输入字符");
						
					}
				}else{
					JOptionPane.showMessageDialog(null,"该id已存在");
				}
			  }else{
					JOptionPane.showMessageDialog(null,"id错误,输入数字");
					
					
				}
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnNewButton.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton.setFont(new Font("华文中宋", Font.BOLD, 18));
		btnNewButton.setBounds(348, 453, 124, 39);
		panel.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBackground(SystemColor.menu);
		textField_1.setFont(new Font("宋体", Font.BOLD, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(323, 163, 220, 32);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBackground(SystemColor.menu);
		textField_2.setFont(new Font("宋体", Font.BOLD, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(323, 229, 220, 32);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBackground(SystemColor.menu);
		textField_3.setFont(new Font("宋体", Font.BOLD, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(323, 293, 220, 32);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBackground(SystemColor.menu);
		textField_4.setFont(new Font("宋体", Font.BOLD, 18));
		textField_4.setColumns(10);
		textField_4.setBounds(323, 359, 220, 32);
		panel.add(textField_4);
		
		frame.setLocationRelativeTo(Frame2.frame);
	       frame.setVisible(true);
	}

	
	public void deltext(){
		
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		
	}
}
