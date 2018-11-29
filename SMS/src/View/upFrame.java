package View;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import action.Action;
import dao.StudentDao;
import model.Student;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class upFrame {

	private JDialog frame;
	private JTextField textField;
	static String  id;


	/**
	 * Create the application.
	 */
	public upFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JDialog();
		frame.setTitle("\u4FEE\u6539\u6570\u636E");
		frame.setModal(true);
		frame.setBounds(100, 100, 625, 459);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		frame.setLocationRelativeTo(Frame2.frame);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(180, 180, 180));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblid = new JLabel("\u8F93\u5165\u5B66\u751F\u7684ID\uFF1A");
		lblid.setFont(new Font("ËÎÌå", Font.BOLD, 25));
		lblid.setBounds(205, 104, 198, 58);
		panel.add(lblid);
		
		textField = new JTextField();
		textField.setBackground(SystemColor.menu);
		textField.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.BOLD, 21));
		textField.setBounds(157, 186, 283, 44);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				 id = textField.getText();
				
				
		if(id.matches("\\d++")){

                Action a =new Action();
                boolean b =false;
			
               try {
				b = a.isget(Integer.valueOf(id));
			} catch (NumberFormatException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
				
               if(b){
				   try {
						new upFrame2();
					   
					
					textField.setText("");
				   }catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				       }
				   
				}else{
						
					JOptionPane.showMessageDialog(null,"²»´æÔÚ¸ÃÑ§Éú");
						
					   }
				
		 }else{
				
					JOptionPane.showMessageDialog(null,"id´íÎó,ÊäÈëÊý×Ö");
					
					}
					
				
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 15));
		btnNewButton.setBounds(237, 316, 112, 38);
		panel.add(btnNewButton);
		
		frame.setVisible(true);
	}
}
