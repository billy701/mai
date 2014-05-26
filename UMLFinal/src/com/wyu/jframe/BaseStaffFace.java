package com.wyu.jframe;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import com.wyu.mapping.Staff;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class BaseStaffFace extends JFrame{
	private JTextField NameField;
	private JTextField PassWordField;
	private JTextField PayField;
	private JTextField DutyField;
	private static BaseStaffFace baseStaffFace;
	private MainManagerFace mainFace;
	private List<Staff> listaccount;
	private BaseStaffManager baseStaffManager;
	
public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaseStaffFace frame =getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private BaseStaffFace() {

		baseStaffManager = BaseStaffManager.getInstance();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 399);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5458\u5DE5\u57FA\u672C\u8D44\u6599\u67E5\u8BE2");
		lblNewLabel.setFont(new Font("»ªÎÄçúçê", Font.ITALIC, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 216, 67);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D");
		lblNewLabel_1.setBounds(60, 80, 54, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801");
		lblNewLabel_2.setBounds(60, 131, 54, 15);
		panel.add(lblNewLabel_2);
		
		NameField = new JTextField();
		NameField.setBounds(174, 77, 187, 21);
		panel.add(NameField);
		NameField.setColumns(10);
		
		PassWordField = new JTextField();
		PassWordField.setHorizontalAlignment(SwingConstants.CENTER);
		PassWordField.setText("\u767B\u5165\u5BC6\u7801");
		PassWordField.setBounds(174, 128, 187, 21);
		panel.add(PassWordField);
		PassWordField.setColumns(10);
		
		JButton FindButton = new JButton("\u67E5\u8BE2");
		FindButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Account account = new Account(NameField.getText(),
						PassWordField.getText(),"");
				listaccount = baseStaffManager.findAll();
				int maxsize = listaccount.size();
				for(int i = 0; i < maxsize;++i)
				{
					Staff staff = listaccount.get(i);
					if(staff.getName().equals(account.getAccount())
							&& staff.getPassword().equals(account.getPassword()))
					{
						System.out.println("0");
						PayField.setText(staff.getSalary());
						DutyField.setText(staff.getDuty());
						break;
					}
						
				}
				
				
			}
		});
		FindButton.setBounds(390, 155, 93, 50);
		panel.add(FindButton);
		
		JLabel lblNewLabel_3 = new JLabel("\u5DE5\u8D44");
		lblNewLabel_3.setBounds(60, 220, 54, 15);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u804C\u4F4D");
		lblNewLabel_4.setBounds(60, 286, 54, 15);
		panel.add(lblNewLabel_4);
		
		PayField = new JTextField();
		PayField.setBounds(174, 217, 187, 21);
		panel.add(PayField);
		PayField.setColumns(10);
		
		DutyField = new JTextField();
		DutyField.setBounds(174, 283, 187, 21);
		panel.add(DutyField);
		DutyField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u8BF7\u8F93\u5165\u59D3\u540D\u548C\u5BC6\u7801\u540E\u8FDB\u884C\u67E5\u8BE2");
		lblNewLabel_5.setBounds(174, 173, 187, 15);
		panel.add(lblNewLabel_5);
		
		JButton ReturnButton = new JButton("\u8FD4\u56DE");
		ReturnButton.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
		ReturnButton.setBounds(390, 248, 93, 53);
		panel.add(ReturnButton);
		ReturnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFace = MainManagerFace.getInstance();
				mainFace.setVisible(true);
				setVisible(false);
				
			}
		});
		
	}
	
	public static BaseStaffFace getInstance()
	{
		if( baseStaffFace == null )
			baseStaffFace = new BaseStaffFace();
		return baseStaffFace;
	}

}
