package View;



import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.TextField;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import action.Action;
import dao.StudentDao;
import model.Student;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.plaf.TableHeaderUI;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;

public class Frame2 {

	public static JFrame frame;
	public static   JTable table;
	public static DefaultTableModel  model;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame2 window = new Frame2();
					
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public Frame2() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		StudentDao st =new StudentDao();
		frame = new JFrame();
		
		frame.setTitle("\u5B66\u751F\u7BA1\u7406\u7CFB\u7EDF");
		frame.setBackground(Color.WHITE);
		frame.getContentPane().setBackground(Color.GRAY);
		frame.getContentPane().setFont(new Font("微软雅黑", Font.PLAIN, 35));
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel  panel = new JPanel();
		panel.setForeground(SystemColor.desktop);
		panel.setBackground(SystemColor.activeCaptionBorder);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 97, 849, 654);
		panel.add(scrollPane);
		
		table = new JTable();	
	    
		table.getTableHeader().setEnabled(false);
	
		table.setForeground(Color.BLACK);
		
		table.setBorder(UIManager.getBorder("CheckBox.border"));
		table.setBackground(SystemColor.inactiveCaptionBorder);
		table.setFont(new Font("宋体", Font.BOLD, 19));
		table.setRowHeight(25);
		
		table.getTableHeader().setFont(new Font("Dialog", 0, 20));
		
		String[] columns={"ID","姓名","性别","年龄","班级"}; //创建列名数组.
		 //创建表格模型.
		  model=new DefaultTableModel(columns,0);
		  //设置表格模型.
		
		table.setModel(model);
		
		 showAll(st);
		
		 
		 DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		 tcr.setHorizontalAlignment(SwingConstants.CENTER);
		 table.setDefaultRenderer(Object.class, tcr);
		
		 scrollPane.setViewportView(table);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.controlShadow);
		menuBar.setBounds(0, 0, 1220, 74);
		panel.add(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("    \u6570\u636E\u64CD\u4F5C    ");
		mnNewMenu_1.setFont(new Font("微软雅黑", Font.BOLD, 30));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem menuItem_3 = new JMenuItem("          \u4FEE\u6539\u6570\u636E            ");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				new upFrame();
				
				
				
			}
		});
		menuItem_3.setFont(new Font("微软雅黑", Font.BOLD, 24));
		menuItem_3.setBackground(SystemColor.activeCaptionBorder);
		mnNewMenu_1.add(menuItem_3);
		
		JMenuItem mntmid = new JMenuItem("          \u6307\u5B9AID\u5220\u9664            ");
		mntmid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				new delFrame();
				 
				
			}
		});
		mntmid.setFont(new Font("微软雅黑", Font.BOLD, 24));
		mntmid.setBackground(SystemColor.activeCaptionBorder);
		mnNewMenu_1.add(mntmid);
		
		JMenuItem menuItem_2 = new JMenuItem("          \u663E\u793A\u6240\u6709\u6570\u636E            ");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				while(table.getRowCount()>0){
					
					model.removeRow(table.getRowCount()-1);
				}
				try {
					showAll(st);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		menuItem_2.setFont(new Font("微软雅黑", Font.BOLD, 24));
		menuItem_2.setBackground(SystemColor.activeCaptionBorder);
		mnNewMenu_1.add(menuItem_2);
		
		JMenu mnNewMenu = new JMenu("    \u67E5\u8BE2    ");
		mnNewMenu.setBackground(SystemColor.window);
		mnNewMenu.setFont(new Font("微软雅黑", Font.BOLD, 30));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("          ID\u641C\u7D22            ");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Queryid();
			}
		});
		mntmNewMenuItem.setBackground(SystemColor.activeCaptionBorder);
		mntmNewMenuItem.setFont(new Font("微软雅黑", Font.BOLD, 24));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem menuItem_4 = new JMenuItem("          \u59D3\u540D\u641C\u7D22            ");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Queryname();
			}
		});
		menuItem_4.setFont(new Font("微软雅黑", Font.BOLD, 24));
		menuItem_4.setBackground(SystemColor.activeCaptionBorder);
		mnNewMenu.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("          \u6027\u522B\u641C\u7D22            ");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Querysex();
			}
		});
		menuItem_5.setFont(new Font("微软雅黑", Font.BOLD, 24));
		menuItem_5.setBackground(SystemColor.activeCaptionBorder);
		mnNewMenu.add(menuItem_5);
		
		JMenuItem menuItem_6 = new JMenuItem("          \u5E74\u9F84\u641C\u7D22            ");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Queryage();
			}
		});
		menuItem_6.setFont(new Font("微软雅黑", Font.BOLD, 24));
		menuItem_6.setBackground(SystemColor.activeCaptionBorder);
		mnNewMenu.add(menuItem_6);
		
		JMenuItem menuItem_7 = new JMenuItem("          \u73ED\u7EA7\u641C\u7D22            ");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Queryclass();
			}
		});
		menuItem_7.setFont(new Font("微软雅黑", Font.BOLD, 24));
		menuItem_7.setBackground(SystemColor.activeCaptionBorder);
		mnNewMenu.add(menuItem_7);
		
		JMenu menu = new JMenu("    \u5176\u4ED6    ");
		menu.setFont(new Font("微软雅黑", Font.BOLD, 30));
		menuBar.add(menu);
		
		JMenuItem menuItem_1 = new JMenuItem("          \u6DFB\u52A0\u7BA1\u7406\u5458            ");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new addAccount();
			}
		});
		menuItem_1.setFont(new Font("微软雅黑", Font.BOLD, 24));
		menuItem_1.setBackground(SystemColor.activeCaptionBorder);
		menu.add(menuItem_1);
		
		JMenuItem mntmexcel = new JMenuItem("        \u53E6\u5B58\u4E3AExcel\u6587\u4EF6          ");
		mntmexcel.setFont(new Font("微软雅黑", Font.BOLD, 24));
		mntmexcel.setBackground(SystemColor.activeCaptionBorder);
		menu.add(mntmexcel);
		
		JMenu menu_1 = new JMenu("    \u5173\u4E8E    ");
		menu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		menu_1.setFont(new Font("微软雅黑", Font.BOLD, 30));
		menuBar.add(menu_1);
		
		JMenuItem menuItem_8 = new JMenuItem("          \u4F7F\u7528\u5E2E\u52A9            ");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new useFrame();
				
			}
		});
		menuItem_8.setFont(new Font("微软雅黑", Font.BOLD, 24));
		menuItem_8.setBackground(SystemColor.activeCaptionBorder);
		menu_1.add(menuItem_8);
		
		JMenuItem menuItem_9 = new JMenuItem("          \u4F5C\u8005\u4FE1\u606F            ");
		menuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new meFrame();
			}
		});
		menuItem_9.setFont(new Font("微软雅黑", Font.BOLD, 24));
		menuItem_9.setBackground(SystemColor.activeCaptionBorder);
		menu_1.add(menuItem_9);
		
		JButton button_1 = new JButton("\u5220\u9664");
		button_1.setBounds(968, 357, 169, 47);
		panel.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int row = table.getSelectedRow();
				
				String id= (String)table.getValueAt(row, 0);
		      
				  model.removeRow(row);
		          
		           Action a = new Action();
                   
		           try {
					a.del(Integer.valueOf(id));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("微软雅黑", Font.PLAIN, 27));
		button_1.setBackground(SystemColor.inactiveCaptionBorder);
		
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.setBounds(968, 235, 169, 47);
		panel.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new addFrame();
			
				
				/*Student s = new Student();
				StudentDao st = new StudentDao();
				
				try {
					st.add(s);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				
			}
		});
		button.setForeground(Color.BLACK);
		button.setFont(new Font("微软雅黑", Font.PLAIN, 27));
		button.setBackground(SystemColor.inactiveCaptionBorder);
		
		JButton button_3 = new JButton("\u9000\u51FA");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				System.exit(0);
			}
		});
		button_3.setForeground(Color.BLACK);
		button_3.setFont(new Font("微软雅黑", Font.PLAIN, 27));
		button_3.setBackground(SystemColor.inactiveCaptionBorder);
		button_3.setBounds(968, 484, 169, 47);
		panel.add(button_3);
		frame.setBounds(100, 100, 1238, 821);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}

	public static void showAll(StudentDao st) throws Exception {
		List<Student> students=st.queryall(); //利用方法传递list集合对象.
		 
		 for(Student s:students){ //遍历学生集合对象.
		 String[] args=s.toString().split(","); //把学生信息拆分为数组,传递给args数组.
		 model.addRow(args);
		
		 }
	}
}
