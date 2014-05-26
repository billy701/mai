package com.wyu.jframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.wyu.dao.CheckInDAO;
import com.wyu.dao.StaffDAO;
import com.wyu.jframe.CheckInManagerJFrame.addAction;
import com.wyu.jframe.CheckInManagerJFrame.deleteAction;
import com.wyu.jframe.CheckInManagerJFrame.exitAction;
import com.wyu.jframe.CheckInManagerJFrame.returnAction;
import com.wyu.jframe.CheckInManagerJFrame.updateAction;
import com.wyu.mapping.CheckIn;
import com.wyu.mapping.Staff;

public class CheckInChargeFace extends JFrame{

	private JTextField projectField;
	private JTextField startField;
	private JTextField endField;
	private JTextField approverField;
	private JTextField approverDateField;
	private JTextArea decriptionArea;
	private JList jList;
	private DefaultListModel defaultListModel = new DefaultListModel();
	private List<CheckIn> dataList = new ArrayList<CheckIn>();
	private int index;
	private MainChargeFace mainFace;
	private static CheckInChargeFace checkInChargeFace;
	
	public static CheckInChargeFace getInstance()
	{
		if(checkInChargeFace == null)
			checkInChargeFace = new CheckInChargeFace();
		return checkInChargeFace;
	}
	
	public static void main(String[] args) {

		try {
			UIManager
					.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		} catch (Exception e) {

		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckInChargeFace frame = getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private CheckInChargeFace() {
		setTitle("考勤管理");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 700);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setForeground(Color.ORANGE);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		// load the picture
		URL resource = CheckInChargeFace.this.getClass()
				.getResource("/img/exit.JPG");
		ImageIcon icon = new ImageIcon(resource);

		URL resource1 = CheckInChargeFace.this.getClass().getResource(
				"/img/backToMain.png");
		ImageIcon icon1 = new ImageIcon(resource1);

		JButton returnBtn = new JButton("New label");
		returnBtn.setIcon(icon1);
		returnBtn.setBounds(810, 10, 70, 89);
		panel.add(returnBtn);
		returnBtn.addActionListener(new returnAction());

		JButton exitBtn = new JButton("New label");
		exitBtn.setIcon(icon);
		exitBtn.setBounds(909, 10, 70, 89);
		panel.add(exitBtn);
		exitBtn.addActionListener(new exitAction());

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 101, 229, 550);
		panel.add(scrollPane);

		// init the jlist and get data from the database
		initMyList();
		scrollPane.setViewportView(jList);

		JLabel nameLable = new JLabel("考勤项目:");
		nameLable.setBounds(281, 119, 70, 29);
		panel.add(nameLable);

		projectField = new JTextField();
		projectField.setBounds(388, 119, 168, 30);
		panel.add(projectField);
		projectField.setColumns(10);

		JLabel label = new JLabel("说明");
		label.setBounds(281, 347, 54, 15);
		panel.add(label);

		decriptionArea = new JTextArea();
		decriptionArea.setBounds(280, 372, 688, 178);
		JScrollPane jScrollPane = new JScrollPane(decriptionArea);
		jScrollPane.setBounds(280, 372, 688, 178);
		panel.add(jScrollPane);

		JLabel label_1 = new JLabel("\u5F00\u59CB\u65E5\u671F:");
		label_1.setBounds(281, 211, 81, 15);
		panel.add(label_1);

		startField = new JTextField();
		startField.setBounds(388, 204, 168, 30);
		panel.add(startField);
		startField.setColumns(10);

		JLabel label_2 = new JLabel("\u7ED3\u675F\u65E5\u671F:");
		label_2.setBounds(597, 211, 85, 15);
		panel.add(label_2);

		endField = new JTextField();
		endField.setBounds(692, 204, 168, 30);
		panel.add(endField);
		endField.setColumns(10);

		JLabel label_3 = new JLabel("\u6279\u51C6\u4EBA:");
		label_3.setBounds(281, 294, 81, 15);
		panel.add(label_3);

		approverField = new JTextField();
		approverField.setBounds(388, 287, 168, 30);
		panel.add(approverField);
		approverField.setColumns(10);

		JLabel label_4 = new JLabel("\u6279\u51C6\u65E5\u671F:");
		label_4.setBounds(597, 294, 85, 15);
		panel.add(label_4);

		approverDateField = new JTextField();
		approverDateField.setBounds(692, 287, 168, 30);
		panel.add(approverDateField);
		approverDateField.setColumns(10);

	

		JLabel label_5 = new JLabel("\u8003\u52E4\u7BA1\u7406");
		label_5.setForeground(Color.YELLOW);
		label_5.setFont(new Font("微软雅黑", Font.ITALIC, 50));
		label_5.setBounds(365, 18, 277, 60);
		panel.add(label_5);

		// 添加List的事件驱动
		jList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				index = jList.getSelectedIndex();
				if (index != -1) {
					CheckIn checkIn = dataList.get(index);
					projectField.setText(checkIn.getProject());
					decriptionArea.setText(checkIn.getExplain());
					startField.setText(checkIn.getStartData());
					endField.setText(checkIn.getEndData());
					approverField.setText(checkIn.getApprover());
					approverDateField.setText(checkIn.getApproverData());
				}
			}
		});

	}

	public void initMyList() {
		dataList = CheckInDAO.findAll();
		for (int i = 0; i < dataList.size(); i++) {
			CheckIn record = (CheckIn) dataList.get(i);
			defaultListModel.addElement(record.getProject());
		}
		jList = new JList(defaultListModel);
		jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}

	// 退出
	public class exitAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}

	}

	// 返回主界面
	public class returnAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			mainFace = MainChargeFace.getInstance();
			mainFace.setVisible(true);
			setVisible(false);
			// new mainUI

		}

	}

	





}
