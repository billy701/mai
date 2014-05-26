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
			case "员工":
				worker++;
				break;
			case "经理":
				money++;
				break;
			case "主管":
				manager++;
			}

		DefaultPieDataset dpd = new DefaultPieDataset(); // 建立一个默认的饼图
		dpd.setValue("普通员工", worker); // 输入数据
		dpd.setValue("经理", money);
		dpd.setValue("主管", manager);

		JFreeChart chart = ChartFactory.createPieChart("人员组织数据图", dpd, true,
				true, false);
		// 可以查具体的API文档,第一个参数是标题，第二个参数是一个数据集，第三个参数表示是否显示Legend，第四个参数表示是否显示提示，第五个参数表示图中是否存在URL
		ChartFrame chartFrame = new ChartFrame("人员组织数据图", chart);
		// chart要放在Java容器组件中，ChartFrame继承自java的Jframe类。该第一个参数的数据是放在窗口左上角的，不是正中间的标题。
		chartFrame.pack(); // 以合适的大小展现图形
		chartFrame.setVisible(true);// 图形是否可见
		chartFrame.setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new ReportFrame();
	}

}
