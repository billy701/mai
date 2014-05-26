package com.wyu.jframe;

import java.util.List;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import com.wyu.dao.StaffDAO;
import com.wyu.mapping.Staff;

public class ReportFrame extends JFrame {

	public ReportFrame() {

		int worker = 0, money = 0, manager = 0;
		List list = StaffDAO.findAll();

		for (int i = 0; i < list.size(); i++)
			switch (((Staff) list.get(i)).getDuty().toString().trim()) {
			case "Ա��":
				worker++;
				break;
			case "����":
				money++;
				break;
			case "����":
				manager++;
			}

		DefaultPieDataset dpd = new DefaultPieDataset(); // ����һ��Ĭ�ϵı�ͼ
		dpd.setValue("��ͨԱ��", worker); // ��������
		dpd.setValue("����", money);
		dpd.setValue("����", manager);

		JFreeChart chart = ChartFactory.createPieChart("��Ա��֯����ͼ", dpd, true,
				true, false);
		// ���Բ�����API�ĵ�,��һ�������Ǳ��⣬�ڶ���������һ�����ݼ���������������ʾ�Ƿ���ʾLegend�����ĸ�������ʾ�Ƿ���ʾ��ʾ�������������ʾͼ���Ƿ����URL
		ChartFrame chartFrame = new ChartFrame("��Ա��֯����ͼ", chart);
		// chartҪ����Java��������У�ChartFrame�̳���java��Jframe�ࡣ�õ�һ�������������Ƿ��ڴ������Ͻǵģ��������м�ı��⡣
		chartFrame.pack(); // �Ժ��ʵĴ�Сչ��ͼ��
		chartFrame.setVisible(true);// ͼ���Ƿ�ɼ�
		chartFrame.setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new ReportFrame();
	}

}
