package com.wyu.jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFace extends JFrame {

	private JPanel contentPane;
	private JTextField MangerCountField;
	private JTextField ManagerPasswordField;
	private JTextField ChargeCountField;
	private JTextField ChargePasswordField;
	private JTextField StaffCountField;
	private JTextField StaffPasswordField;
	private JTabbedPane tabbedPane;
	private LoginWork loginwork;
	private MainManagerFace mainManagerFace;
	private MainChargeFace mainChargeFace;
	private MainStaffFace mainStaffFace;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
			UIManager
					.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFace frame = new LoginFace();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFace() {
		loginwork = LoginWork.getInstance();

		setTitle("\u85AA\u916C\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		JPanel staffPanel = new JPanel();
		JPanel managerPanel = new JPanel();

		tabbedPane.add(managerPanel, "经理");

		tabbedPane.setToolTipTextAt(0, "经理");
		JPanel chargePanel = new JPanel();
		tabbedPane.add(chargePanel, "主管");
		tabbedPane.add(staffPanel, "员工");
		tabbedPane.setToolTipTextAt(1, "主管");
		tabbedPane.setToolTipTextAt(2, "员工");

		JLabel count = new JLabel("账号");
		count.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel password = new JLabel("密码");
		password.setHorizontalAlignment(SwingConstants.CENTER);
		managerPanel.add(count);
		managerPanel.add(password, BorderLayout.CENTER);
		managerPanel.setLayout(null);
		count.setBounds(40, 20, 100, 100);
		password.setBounds(40, 70, 100, 100);

		MangerCountField = new JTextField();
		MangerCountField
				.setText("\u8BF7\u8F93\u5165\u59D3\u540D\u4F5C\u4E3A\u8D26\u53F7");
		MangerCountField.setHorizontalAlignment(SwingConstants.CENTER);
		ManagerPasswordField = new JTextField();
		ManagerPasswordField.setHorizontalAlignment(SwingConstants.CENTER);
		managerPanel.add(MangerCountField);
		managerPanel.add(ManagerPasswordField);
		MangerCountField.setBounds(150, 53, 200, 36);
		ManagerPasswordField.setBounds(150, 103, 200, 36);

		JButton mangerLoginButton = new JButton("\u767B\u5165");
		mangerLoginButton.setBounds(234, 175, 93, 23);
		managerPanel.add(mangerLoginButton);

		chargePanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u8D26\u53F7");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(40, 20, 100, 100);
		chargePanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(40, 70, 100, 100);
		chargePanel.add(lblNewLabel_1);

		ChargeCountField = new JTextField();
		ChargeCountField.setHorizontalAlignment(SwingConstants.CENTER);
		ChargeCountField
				.setText("\u8BF7\u8F93\u5165\u59D3\u540D\u4F5C\u4E3A\u8D26\u53F7");
		ChargeCountField.setBounds(150, 53, 200, 36);
		chargePanel.add(ChargeCountField);
		ChargeCountField.setColumns(10);

		ChargePasswordField = new JTextField();
		ChargePasswordField.setHorizontalAlignment(SwingConstants.CENTER);
		ChargePasswordField.setBounds(150, 103, 200, 36);
		chargePanel.add(ChargePasswordField);
		ChargePasswordField.setColumns(10);

		JButton ChargeCancelButton = new JButton("\u53D6\u6D88");
		ChargeCancelButton.setBounds(88, 175, 93, 23);
		chargePanel.add(ChargeCancelButton);

		JButton ChargeLoginButton = new JButton("\u767B\u5165");
		ChargeLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ChargeLoginButton.setBounds(234, 175, 93, 23);
		chargePanel.add(ChargeLoginButton);
		staffPanel.setLayout(null);

		JLabel label = new JLabel("\u8D26\u53F7");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(40, 20, 100, 100);
		staffPanel.add(label);

		JLabel label_1 = new JLabel("\u5BC6\u7801");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(40, 70, 100, 100);
		staffPanel.add(label_1);

		StaffCountField = new JTextField();
		StaffCountField.setHorizontalAlignment(SwingConstants.CENTER);
		StaffCountField
				.setText("\u8BF7\u8F93\u5165\u59D3\u540D\u4F5C\u4E3A\u8D26\u53F7");
		StaffCountField.setBounds(150, 53, 200, 36);
		staffPanel.add(StaffCountField);
		StaffCountField.setColumns(10);

		StaffPasswordField = new JTextField();
		StaffPasswordField.setHorizontalAlignment(SwingConstants.CENTER);
		StaffPasswordField.setBounds(150, 103, 200, 36);
		staffPanel.add(StaffPasswordField);
		StaffPasswordField.setColumns(10);

		JButton StaffCancelButton = new JButton("\u53D6\u6D88");
		StaffCancelButton.setBounds(88, 175, 93, 23);
		staffPanel.add(StaffCancelButton);

		JButton StaffLoginButton = new JButton("\u767B\u5165");
		StaffLoginButton.setBounds(234, 175, 93, 23);
		staffPanel.add(StaffLoginButton);

		JButton managerCancelButton = new JButton("\u53D6\u6D88");
		managerCancelButton.setBounds(88, 175, 93, 23);
		managerPanel.add(managerCancelButton);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		managerCancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		ChargeCancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		StaffCancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		mangerLoginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (loginwork.checkAccount(new Account(MangerCountField
						.getText(), ManagerPasswordField.getText(), tabbedPane
						.getTitleAt(0)))) {
					JOptionPane.showMessageDialog(null, "登入成功");
					MangerCountField.setText("");
					ManagerPasswordField.setText("");
					mainManagerFace = MainManagerFace.getInstance();
					mainManagerFace.setVisible(true);
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "账号或密码不对");
				}

			}
		});

		ChargeLoginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (loginwork.checkAccount(new Account(ChargeCountField
						.getText(), ChargePasswordField.getText(), tabbedPane
						.getTitleAt(1)))) {
					JOptionPane.showMessageDialog(null, "登入成功");
					ChargeCountField.setText("");
					ChargePasswordField.setText("");
					mainChargeFace = mainChargeFace.getInstance();
					mainChargeFace.setVisible(true);
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "账号或密码不对");
				}

			}
		});

		StaffLoginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (loginwork.checkAccount(new Account(StaffCountField
						.getText(), StaffPasswordField.getText(), tabbedPane
						.getTitleAt(2)))) {
					JOptionPane.showMessageDialog(null, "登入成功");
					StaffCountField.setText("");
					StaffPasswordField.setText("");
					mainStaffFace = mainStaffFace.getInstance();
					mainStaffFace.setVisible(true);
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "账号或密码不对");
				}

			}
		});
	}
}
