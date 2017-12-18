package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import database.JdbcUtils;
import database.SQLConstant;

/**
 * 查询页面
 * 
 * @author sxx.xu
 *
 */
public class SearchPage extends ParentJPanel {

	private static final long serialVersionUID = 1L;

	public SearchPage() {
		JLabel nameKey = new JLabel("姓    名:");
		JLabel genderKey = new JLabel("性    别:");
		JLabel posKey = new JLabel("职    位:");
		JLabel companyKey = new JLabel("公    司:");
		JLabel workYearKey = new JLabel("工作年限:");
		JLabel eduKey = new JLabel("学    历:");

		JTextField nameValue = new JTextField(textLen);
		JComboBox<String> genderValue = new JComboBox<String>();
		genderValue.addItem("男");
		genderValue.addItem("女");
		genderValue.addItem("保密");
		genderValue.setSelectedIndex(0);

		JTextField posValue = new JTextField(textLen);
		JTextField companyValue = new JTextField(textLen);
		JTextField workYearValue = new JTextField(textLen);
		JComboBox<String> eduValue = new JComboBox<String>();
		eduValue.addItem("本科");
		eduValue.addItem("硕士");
		eduValue.addItem("博士");
		eduValue.addItem("未知(不限)");
		JButton search = new JButton("搜  索");

		Box hbox0 = Box.createHorizontalBox();// 姓名
		hbox0.add(nameKey);
		hbox0.add(Box.createHorizontalStrut(kvSpace));
		hbox0.add(nameValue);

		Box hbox1 = Box.createHorizontalBox();// 性别,职位,公司
		hbox1.add(genderKey);
		hbox1.add(Box.createHorizontalStrut(kvSpace));
		hbox1.add(genderValue);

		Box hbox2 = Box.createHorizontalBox();// 工作年限,学历
		hbox2.add(posKey);
		hbox2.add(Box.createHorizontalStrut(kvSpace));
		hbox2.add(posValue);

		Box hbox3 = Box.createHorizontalBox();
		hbox3.add(companyKey);
		hbox3.add(Box.createHorizontalStrut(kvSpace));
		hbox3.add(companyValue);

		Box hbox4 = Box.createHorizontalBox();
		hbox4.add(workYearKey);
		hbox4.add(Box.createHorizontalStrut(kvSpace));
		hbox4.add(workYearValue);

		Box hbox5 = Box.createHorizontalBox();
		hbox5.add(eduKey);
		hbox5.add(Box.createHorizontalStrut(kvSpace));
		hbox5.add(eduValue);

		Box hboxN = Box.createHorizontalBox();
		hboxN.add(search);

		Box vbox = Box.createVerticalBox();
		vbox.add(hbox0);
		vbox.add(Box.createVerticalStrut(itemVSpace));
		vbox.add(hbox1);
		vbox.add(Box.createVerticalStrut(itemVSpace));
		vbox.add(hbox2);
		vbox.add(Box.createVerticalStrut(itemVSpace));
		vbox.add(hbox3);
		vbox.add(Box.createVerticalStrut(itemVSpace));
		vbox.add(hbox4);
		vbox.add(Box.createVerticalStrut(itemVSpace));
		vbox.add(hbox5);
		vbox.add(Box.createVerticalStrut(itemVSpace));
		vbox.add(hboxN);
		add(vbox, BorderLayout.CENTER);

		search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder();
				List<Object> params = new ArrayList<Object>();
				String gender = (String) genderValue.getSelectedItem();
				String edu = (String) eduValue.getSelectedItem();
				sb.append("select * from personal_info  where gender = ? ");
				params.add(gender);

				if (!edu.equals("未知(不限)")) {
					sb.append(" and hightestEdu= ?");
					params.add(edu);
				}
				String name = nameValue.getText();
				if (!name.trim().isEmpty()) {
					sb.append(" and name like ?");
					params.add("%" + name + "%");
				}
				String position = posValue.getText();
				if (!position.trim().isEmpty()) {
					sb.append(" and position like  ?  ");
					params.add("%" + position + "%");
				}
				String company = companyValue.getText();
				if (!company.trim().isEmpty()) {
					sb.append(" and company like   ?  ");
					params.add("%" + company + "%");
				}
				int workyear = 0;
				if (workYearValue.getText().matches("[0-9]+")) {
					workyear = Integer.parseInt(workYearValue.getText());
					sb.append(" and  wrokYears >= ");
					params.add(workyear);
				}

				JdbcUtils jdbcUtils = new JdbcUtils();
				jdbcUtils.getConnection();
				SearchResultPage srp = new SearchResultPage();

				try {
					List<Map<String, Object>> results = jdbcUtils.findModeResult(sb.toString(), params);
					if (results.isEmpty()) {
						JOptionPane.showMessageDialog(getParent(), "搜索结果为空,请更换筛选条件!");
					} else {
						srp.init(results);
						for (int i = 0; i < results.size(); i++) {
							Map<String, Object> map = results.get(i);
							System.out.println(map.values());
						}
					}

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(getParent(), "错误：" + e1.getLocalizedMessage());
				}
			}
		});
	}

}
