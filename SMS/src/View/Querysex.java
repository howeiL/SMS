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

public class Querysex {

	private JDialog frame;
	private JTextField textField;



	/**
	 * Create the application.
	 */
	public Querysex() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JDialog();
		frame.setTitle("\u6027\u522B\u67E5\u8BE2");
		frame.setModal(true);
		frame.setBounds(100, 100, 625, 459);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		frame.setLocationRelativeTo(Frame2.frame);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(180, 180, 180));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblid = new JLabel("\u8F93\u5165\u5B66\u751F\u7684\u6027\u522B\uFF1A");
		lblid.setFont(new Font("����", Font.BOLD, 25));
		lblid.setBounds(195, 104, 208, 58);
		panel.add(lblid);
		
		textField = new JTextField();
		textField.setBackground(SystemColor.menu);
		textField.setFont(new Font("΢���ź� Light", Font.BOLD, 21));
		textField.setBounds(157, 186, 283, 44);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u627E");
		btnNewButton.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String sex = textField.getText();
				StudentDao st = new StudentDao();
				
				
				
				if(sex.matches("��|Ů|����")){
				
					   try {
						List<Student> l =new ArrayList<Student>();
						l = st.querySex(sex);
						if(!l.isEmpty()){
							
							while( Frame2.model.getRowCount()>0){
								 Frame2.model.removeRow( Frame2.model.getRowCount()-1);
							 }
							for(Student s:l){ //����ѧ�����϶���.
								 String[] args=s.toString().split(","); //��ѧ����Ϣ���Ϊ����,���ݸ�args����.
								 Frame2.model.addRow(args);
								
							 }
							frame.dispose();
						}else{
							
							JOptionPane.showMessageDialog(null,"û�и��Ա��ѧ��");
						}
						
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					   
				}else{
				
					JOptionPane.showMessageDialog(null,"�Ա����,ֻ������ ��,Ů,����");
					
					}
					
				
				
				
				
			}
		});
		btnNewButton.setFont(new Font("΢���ź�", Font.BOLD, 15));
		btnNewButton.setBounds(237, 316, 112, 38);
		panel.add(btnNewButton);
		
		frame.setVisible(true);
	}
}
