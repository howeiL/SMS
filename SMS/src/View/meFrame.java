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

public class meFrame {

	private JDialog frame;

	/**
	 * Launch the application.
	

	/**
	 * Create the application.
	 */
	public meFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JDialog();
		
		
		frame.setTitle("\u4F5C\u8005\u4FE1\u606F");
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
		
		JLabel lblKubi = new JLabel("\u8F6F\u4EF61607\u67D0\u4E2A\u7231\u5B66\u4E60\u7684\u597D\u540C\u5B66");
		lblKubi.setFont(new Font("ËÎÌו", Font.BOLD, 25));
		lblKubi.setBackground(Color.WHITE);
		lblKubi.setBounds(102, 117, 342, 63);
		panel.add(lblKubi);
		
		
		frame.setLocationRelativeTo(null);
		frame.setModal(true);
		frame.setVisible(true);
	}
}
