package com.wyu.jframe;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.wyu.dao.CheckInDAO;
import com.wyu.dao.RecordDAO;
import com.wyu.dao.StaffDAO;
import com.wyu.mapping.CheckIn;
import com.wyu.mapping.Record;
import com.wyu.mapping.Staff;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class RecordManagerFace extends JFrame {
	private JTextField NameField;
	private JTextField SexField;
	private JTextField BirthdayField;
	private JTextField IdCardField;
	private JTextField NationField;
	private JTextField NativePlaceField;
	private JTextField MarriageField;
	private JTextField PolitisStatusField;
	private JTextField MajorField;
	private JTextField EducationBackgroundField;
	private JTextField DutyField;
	private JTextField DepartmentField;
	private static RecordManagerFace recordFace;
	private MainManagerFace mainFace;
	private RecordManager recordManager;
	private BaseStaffManager baseStaffManager;
	private List<Record> Rlist = new ArrayList<Record>();
	private DefaultListModel defaultListModel = new DefaultListModel();
	private JList jList;
	private int index;
	
	public static void main(String[] args) {

		try {
			UIManager
					.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		} catch (Exception e) {

		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecordManagerFace frame = new RecordManagerFace();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private RecordManagerFace() {

		recordManager = RecordManager.getInstance();
		baseStaffManager = BaseStaffManager.getInstance();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 438);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 64, 143, 336);
		panel.add(scrollPane);
		
		jList = new JList();
		initMyList();
		scrollPane.setViewportView(jList);
		jList.setBorder(new LineBorder(new Color(51, 102, 255), 5));
		jList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				index = jList.getSelectedIndex();
				if (index != -1) {
					Record record = Rlist.get(index);
					NameField.setText(record.getName());
					SexField.setText(record.getSex());
					BirthdayField.setText(record.getBirthday());
					IdCardField.setText(record.getIdCard());
					NationField.setText(record.getNation());
					NativePlaceField.setText(record.getNativePlace());
					MarriageField.setText(record.getMarriage());
					PolitisStatusField.setText(record.getPoliticsStatus());
					EducationBackgroundField.setText(record.getEducationBackground());
					MajorField.setText(record.getMajor());
					DepartmentField.setText(record.getDepartment());
					DutyField.setText(record.getDuty());
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("\u6863\u6848\u4E2D\u5FC3");
		lblNewLabel.setFont(new Font("»ªÎÄçúçê", Font.ITALIC, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(5, 1, 203, 65);
		panel.add(lblNewLabel);
		
		JButton DeleteButton = new JButton("\u5220\u9664\u6863\u6848");
		DeleteButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.ITALIC, 15));
		DeleteButton.setBounds(311, 0, 93, 65);
		panel.add(DeleteButton);
		DeleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (index != -1) {
					Record record = new Record(NameField.getText(), SexField.getText(), 
							BirthdayField.getText(), IdCardField.getText(), NationField.getText(), 
							NativePlaceField.getText(), MarriageField.getText(), 
							PolitisStatusField.getText(), EducationBackgroundField.getText(), 
							MajorField.getText(), DepartmentField.getText(), DutyField.getText());
					Staff staff = new Staff(NameField.getText(), "123456", "0",
							DutyField.getText());
					Record record2 = Rlist.get(index);
					record.setId(record2.getId());
					staff.setId(record2.getId());
		
					try {
						recordManager.delete(record.getId());
						baseStaffManager.delete(staff.getId());
						defaultListModel.remove(index);
						Rlist = recordManager.findAll();
						JOptionPane.showMessageDialog(null, "É¾³ý³É¹¦");
						initUI();
					} catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "É¾³ýÊ§°Ü");
						}
					}
				}
				
		});
		
		JButton ChangeButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		ChangeButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.ITALIC, 15));
		ChangeButton.setBounds(409, 1, 93, 65);
		panel.add(ChangeButton);
		ChangeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				haveNull();
				if (index != -1) {
				Record record = new Record(NameField.getText(), SexField.getText(), 
						BirthdayField.getText(), IdCardField.getText(), NationField.getText(), 
						NativePlaceField.getText(), MarriageField.getText(), 
						PolitisStatusField.getText(), EducationBackgroundField.getText(), 
						MajorField.getText(), DepartmentField.getText(), DutyField.getText());
				Staff staff = new Staff(NameField.getText(), "123456", "0",
						DutyField.getText());
				Record record2 = Rlist.get(index);
				record.setId(record2.getId());
				staff.setId(record2.getId());
	
				try {
					recordManager.update(record);
					baseStaffManager.update(staff);
					defaultListModel.set(index, record.getName());
					Rlist = recordManager.findAll();
					JOptionPane.showMessageDialog(null, "¸üÐÂ³É¹¦");
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "¸üÐÂÊ§°Ü");
					}
				}
			}
		});
		
		JButton ReturnButton = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
		ReturnButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.ITALIC, 12));
		ReturnButton.setBounds(507, 0, 93, 65);
		panel.add(ReturnButton);
		ReturnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFace = MainManagerFace.getInstance();
				mainFace.setVisible(true);
				setVisible(false);
				
			}
		});
		
		JButton AddButton = new JButton("\u6DFB\u52A0\u65B0\u6863\u6848");
		AddButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.ITALIC, 12));
		AddButton.setBounds(213, 0, 93, 65);
		panel.add(AddButton);
		AddButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				haveNull();
				Record record = new Record(NameField.getText(), SexField.getText(), 
						BirthdayField.getText(), IdCardField.getText(), NationField.getText(), 
						NativePlaceField.getText(), MarriageField.getText(), 
						PolitisStatusField.getText(), EducationBackgroundField.getText(), 
						MajorField.getText(), DepartmentField.getText(), DutyField.getText());
				Staff staff = new Staff(NameField.getText(), "123456", "0",
						DutyField.getText());
				
				try {
					recordManager.save(record);
					baseStaffManager.save(staff);
					defaultListModel.addElement(record.getName());
					Rlist = recordManager.findAll();
					JOptionPane.showMessageDialog(null, "±£´æ³É¹¦");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "±£´æÊ§°Ü");
				}
			}
		});
		
		JLabel NameLabel = new JLabel("\u59D3\u540D");
		NameLabel.setBounds(165, 100, 54, 15);
		panel.add(NameLabel);
		
		JLabel SexLabel = new JLabel("\u6027\u522B");
		SexLabel.setBounds(165, 150, 54, 15);
		panel.add(SexLabel);
		
		JLabel BirthdayLabel = new JLabel("\u751F\u65E5");
		BirthdayLabel.setBounds(165, 200, 54, 15);
		panel.add(BirthdayLabel);
		
		JLabel IdCardLabel = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7");
		IdCardLabel.setBounds(165, 250, 54, 15);
		panel.add(IdCardLabel);
		
		JLabel NationLabel = new JLabel("\u56FD\u7C4D");
		NationLabel.setBounds(165, 300, 54, 15);
		panel.add(NationLabel);
		
		JLabel NativePlaceLabel = new JLabel("\u7C4D\u8D2F");
		NativePlaceLabel.setBounds(393, 100, 54, 15);
		panel.add(NativePlaceLabel);
		
		JLabel MarriageLabel = new JLabel("\u662F\u5426\u7ED3\u5A5A");
		MarriageLabel.setBounds(393, 150, 54, 15);
		panel.add(MarriageLabel);
		
		JLabel PaliticsLabel = new JLabel("\u653F\u6CBB\u9762\u8C8C");
		PaliticsLabel.setBounds(393, 200, 54, 15);
		panel.add(PaliticsLabel);
		
		JLabel MajorLabel = new JLabel("\u4E13\u4E1A");
		MajorLabel.setBounds(393, 250, 54, 15);
		panel.add(MajorLabel);
		
		JLabel EdulationBackgroundLabel = new JLabel("\u5B66\u5386");
		EdulationBackgroundLabel.setBounds(393, 300, 54, 15);
		panel.add(EdulationBackgroundLabel);
		
		NameField = new JTextField();
		NameField.setBounds(240, 97, 143, 21);
		panel.add(NameField);
		NameField.setColumns(10);
		
		SexField = new JTextField();
		SexField.setColumns(10);
		SexField.setBounds(240, 147, 143, 21);
		panel.add(SexField);
		
		BirthdayField = new JTextField();
		BirthdayField.setColumns(10);
		BirthdayField.setBounds(240, 197, 143, 21);
		panel.add(BirthdayField);
		
		IdCardField = new JTextField();
		IdCardField.setColumns(10);
		IdCardField.setBounds(240, 247, 143, 21);
		panel.add(IdCardField);
		
		NationField = new JTextField();
		NationField.setColumns(10);
		NationField.setBounds(240, 297, 143, 21);
		panel.add(NationField);
		
		NativePlaceField = new JTextField();
		NativePlaceField.setColumns(10);
		NativePlaceField.setBounds(457, 97, 143, 21);
		panel.add(NativePlaceField);
		
		MarriageField = new JTextField();
		MarriageField.setColumns(10);
		MarriageField.setBounds(457, 147, 143, 21);
		panel.add(MarriageField);
		
		PolitisStatusField = new JTextField();
		PolitisStatusField.setColumns(10);
		PolitisStatusField.setBounds(457, 197, 143, 21);
		panel.add(PolitisStatusField);
		
		MajorField = new JTextField();
		MajorField.setColumns(10);
		MajorField.setBounds(457, 247, 143, 21);
		panel.add(MajorField);
		
		EducationBackgroundField = new JTextField();
		EducationBackgroundField.setColumns(10);
		EducationBackgroundField.setBounds(457, 297, 143, 21);
		panel.add(EducationBackgroundField);
		
		JLabel DutyLabel = new JLabel("\u804C\u4F4D");
		DutyLabel.setBounds(165, 345, 54, 15);
		panel.add(DutyLabel);
		
		JLabel DepartmentLabel = new JLabel("\u5355\u4F4D");
		DepartmentLabel.setBounds(393, 345, 54, 15);
		panel.add(DepartmentLabel);
		
		DutyField = new JTextField();
		DutyField.setColumns(10);
		DutyField.setBounds(240, 342, 143, 21);
		panel.add(DutyField);
		
		DepartmentField = new JTextField();
		DepartmentField.setColumns(10);
		DepartmentField.setBounds(457, 342, 143, 21);
		panel.add(DepartmentField);
		
		JLabel lblNewLabel_1 = new JLabel("\u6240\u6709\u9879\u76EE\u5747\u9700\u8981\u586B\u5199");
		lblNewLabel_1.setBounds(329, 375, 173, 15);
		panel.add(lblNewLabel_1);
		
		JButton ClearButton = new JButton("\u6E05\u7A7A");
		ClearButton.setBounds(467, 371, 93, 23);
		panel.add(ClearButton);
		ClearButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				initUI();
			}
		});
	}
	
	public static RecordManagerFace getInstance()
	{
		if( recordFace == null)
			recordFace = new RecordManagerFace();
		return recordFace;
	}
	
	private void haveNull()
	{
		if(NameField.getText().equals(null))
			System.out.println("ÇëÌîÐ´Ãû×Ö");
		else if(SexField.getText().equals(null))
			System.out.println("ÇëÌîÐ´ÐÔ±ð");
		else if(BirthdayField.getText().equals(null))
			System.out.println("ÇëÌîÐ´ÉúÈÕ");
		else if(IdCardField.getText().equals(null))
			System.out.println("ÇëÌîÐ´Éí·ÝÖ¤ºÅ");
		else if(NationField.getText().equals(null))
			System.out.println("ÇëÌîÐ´¹ú¼®");
		else if(NativePlaceField.getText().equals(null))
			System.out.println("ÇëÌîÐ´¼®¹á");
		else if(MarriageField.getText().equals(null))
			System.out.println("ÇëÌîÐ´ÊÇ·ñÒÑ»é");
		else if(PolitisStatusField.getText().equals(null))
			System.out.println("ÇëÌîÐ´ÕþÖÎÃæÃ²");
		else if(EducationBackgroundField.getText().equals(null))
			System.out.println("ÇëÌîÐ´Ñ§Àú");
		else if(MajorField.getText().equals(null))
			System.out.println("ÇëÌîÐ´×¨Òµ");
		else if(DepartmentField.getText().equals(null))
			System.out.println("ÇëÌîÐ´µ¥Î»");
		else if(DutyField.getText().equals(null))
			System.out.println("ÇëÌîÐ´Ö°Î»");
			
	}
	
	private void initMyList() {
		Rlist = recordManager.findAll();
		for (int i = 0; i < Rlist.size(); i++) {
			Record record = Rlist.get(i);
			defaultListModel.addElement(record.getName());
		}
		jList = new JList(defaultListModel);
		jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	
	private void initUI()
	{
		NameField.setText("");
		SexField.setText("");
		BirthdayField.setText("");
		IdCardField.setText("");
		NationField.setText("");
		NativePlaceField.setText("");
		MarriageField.setText("");
		PolitisStatusField.setText("");
		EducationBackgroundField.setText("");
		MajorField.setText("");
		DepartmentField.setText("");
		DutyField.setText("");
	}
}
