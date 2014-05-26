package com.wyu.jframe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.URL;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class MainManagerFace  extends JFrame {
	
	private RecordManagerFace recordFace;
	private BaseStaffFace baseStaffFace;
	private static MainManagerFace mainFace;
	private CheckInManagerJFrame checkInJFrame;
	
public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainManagerFace frame =getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private MainManagerFace() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1026, 724);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel TitleLable = new JLabel("New label");
		TitleLable.setBounds(0, 0, 157, 100);
		URL resource = this.getClass().getResource("/img/logo.JPG");
		ImageIcon icon = new ImageIcon(resource);
		TitleLable.setIcon(icon);
		panel.add(TitleLable);
		
		JButton RecordButton = new JButton("");
		RecordButton.setBounds(257, 0, 89, 100);
		resource = this.getClass().getResource("/img/record.JPG");
		icon = new ImageIcon(resource);
		RecordButton.setIcon(icon);
		panel.add(RecordButton);
		RecordButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				recordFace = RecordManagerFace.getInstance();
				recordFace.setVisible(true);
				setVisible(false);
				
			}
		});
		
		JButton CheckInButton = new JButton("");
		CheckInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkInJFrame = CheckInManagerJFrame.getInstence();
				checkInJFrame.setVisible(true);
				setVisible(false);
			}
		});
		CheckInButton.setBounds(407, 0, 89, 100);
		resource = this.getClass().getResource("/img/timecard.JPG");
		icon = new ImageIcon(resource);
		CheckInButton.setIcon(icon);
		panel.add(CheckInButton);
		
		JButton StatisticsButton = new JButton("");
		StatisticsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reprot1Frame();
				new ReportFrame();
			}
		});
		StatisticsButton.setBounds(557, 0, 89, 100);
		resource = this.getClass().getResource("/img/stat.JPG");
		icon = new ImageIcon(resource);
		StatisticsButton.setIcon(icon);
		panel.add(StatisticsButton);
		
		JButton StaffButton = new JButton("");
		StaffButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				baseStaffFace = BaseStaffFace.getInstance();
				baseStaffFace.setVisible(true);
				setVisible(false);
			}
		});
		StaffButton.setBounds(708,0, 89, 100);
		resource = this.getClass().getResource("/img/data.JPG");
		icon = new ImageIcon(resource);
		StaffButton.setIcon(icon);
		panel.add(StaffButton);
		
		JButton ExitButton = new JButton("");
		ExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ExitButton.setBounds(857, 0, 89, 100);
		resource = this.getClass().getResource("/img/exit.JPG");
		icon = new ImageIcon(resource);
		ExitButton.setIcon(icon);
		panel.add(ExitButton);
		ExitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		JLabel BackLabel = new JLabel("");
		BackLabel.setBounds(155, 99, 860, 587);
		resource = this.getClass().getResource("/img/back.JPG");
		icon = new ImageIcon(resource);
		BackLabel.setIcon(icon);
		panel.add(BackLabel);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setText("<html>档案中心 <br> 经理可以进行所有操作<br>主管只能查询<br>员工没有权限使用</html>");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 136, 157, 114);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setText("<html>考勤管理 <br> 经理可以进行所有操作<br>主管只能查询<br>员工没有权限使用</html>");
		lblNewLabel_1.setBounds(0, 286, 157, 107);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setText("<html>统计报表 <br> 经理可以进行所有操作<br>主管只能查询<br>员工没有权限使用</html>");
		lblNewLabel_2.setBounds(0, 429, 157, 100);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setText("<html>基本资料 <br>都可以使用</html>");
		lblNewLabel_3.setBounds(0, 565, 157, 89);
		panel.add(lblNewLabel_3);
		
		
	}
	
	public static MainManagerFace getInstance()
	{
		if( mainFace == null)
			mainFace = new MainManagerFace();
		return mainFace;
	}
}
