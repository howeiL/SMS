package View;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;

import action.Action;
import dao.StudentDao;
import model.Student;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class Queryclass {

	private JDialog frame;
	private JTextField textField;



	/**
	 * Create the application.
	 */
	public Queryclass() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JDialog();
		frame.setTitle("\u73ED\u7EA7\u67E5\u8BE2");
		frame.setModal(true);
		frame.setBounds(100, 100, 625, 459);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		frame.setLocationRelativeTo(Frame2.frame);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(180, 180, 180));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblid = new JLabel("\u8F93\u5165\u5B66\u751F\u7684\u73ED\u7EA7\uFF1A");
		lblid.setFont(new Font("宋体", Font.BOLD, 25));
		lblid.setBounds(195, 104, 208, 58);
		panel.add(lblid);
		
		textField = new JTextField();
		textField.setBackground(SystemColor.menu);
		textField.setFont(new Font("微软雅黑 Light", Font.BOLD, 21));
		textField.setBounds(157, 186, 283, 44);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u627E");
		btnNewButton.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String clazz = textField.getText();
				StudentDao st = new StudentDao();
				
				
				
				if(clazz.matches("[\u4E00-\u9FA5]{2,}\\d{4}")){
				
					   try {
						List<Student> l =new ArrayList<Student>();
						l = st.queryClass(clazz);
						if(!l.isEmpty()){
							
							while( Frame2.model.getRowCount()>0){
								 Frame2.model.removeRow( Frame2.model.getRowCount()-1);
							 }
							for(Student s:l){ //遍历学生集合对象.
								 String[] args=s.toString().split(","); //把学生信息拆分为数组,传递给args数组.
								 Frame2.model.addRow(args);
								
							 }
							frame.dispose();
						}else{
							
							JOptionPane.showMessageDialog(null,"没有该班级");
						}
						
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					   
				}else{
				
					JOptionPane.showMessageDialog(null,"班级错误,请正确输入");
					
					}
					
				
				
				
				
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 15));
		btnNewButton.setBounds(237, 316, 112, 38);
		panel.add(btnNewButton);
		
		frame.setVisible(true);
	}
}
