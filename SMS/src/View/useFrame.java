package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class useFrame {

	private JDialog frame;

	

	/**
	 * Create the application.
	 */
	public useFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JDialog();
		
		
		frame.setTitle("\u4F7F\u7528\u8BF4\u660E");
		frame.setBounds(100, 100, 562, 402);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("ËÎÌו", Font.PLAIN, 16));
		btnNewButton.setBounds(215, 265, 101, 31);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u57FA\u672C\u4E0A\u6CA1\u5565\u95EE\u9898\uFF0C\u770B\u5F97\u61C2\u6C49\u5B57\u5C31\u80FD\u7528\u5566\uFF01");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("ËÎÌו", Font.BOLD, 25));
		lblNewLabel.setBounds(39, 109, 468, 63);
		panel.add(lblNewLabel);
		
		
		frame.setLocationRelativeTo(null);
		frame.setModal(true);
		frame.setVisible(true);
	}
}
