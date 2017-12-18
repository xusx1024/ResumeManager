package ui;

import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.mysql.jdbc.TimeUtil;

import database.JdbcUtils;
import database.SQLConstant;

enum EditType {
	/** 备注. */
	MARK,
	/** 推荐公司. */
	RECOMMEND_COMPANY;
}

public class EditPage extends ParentJFrame {
	private static final long serialVersionUID = -5996377204347698754L;
	private boolean successSaved = false;
	private String originMarkStr;
	private String id;
	private SearchResultPage parent;
	String sql = SQLConstant.UPDATE_MARK_TEXT;
	String note = "你要保存改变后的公司吗?";

	public EditPage(SearchResultPage parent, String originMarkStr, String id, EditType type) throws HeadlessException {
		this.parent = parent;
		this.originMarkStr = originMarkStr;
		this.id = id;
		String title = "添加备注";
		switch (type) {
		case MARK:
			title = "添加备注";
			note = "你要保存改变后的备注吗?";
			sql = SQLConstant.UPDATE_MARK_TEXT;
			break;
		case RECOMMEND_COMPANY:
			title = "推荐公司";
			note = "你要保存改变后的公司吗?";
			sql = SQLConstant.UPDATE_RECOMMEND_COMPANY;
			break;
		}

		this.setTitle(title);
		try {
			this.setIconImage(ImageIO.read(new File("./img/xilinyinzhang.png")));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		JTextArea area = new JTextArea(3, 10);
		area.setSize(900, 450);
		JScrollPane panel = new JScrollPane(area);
		panel.setSize(900, 450);
		// area.setLineWrap(true);
		// area.setWrapStyleWord(false);
		setSize(900, 450);
		centerInScreen(900, 450);
		area.setText(originMarkStr);
		add(panel);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				if (area.getText().equals(originMarkStr)) {
					dispose();
				} else {
					int resp = JOptionPane.showConfirmDialog(null, note);
					if (resp == JOptionPane.YES_OPTION) {
						parent.setSelectedValue(area.getText());
						List<Object> params = new ArrayList<Object>();
						params.add(area.getText());
						params.add(new Date(System.currentTimeMillis()));
						params.add(id);
						JdbcUtils jdbcUtils = new JdbcUtils();
						jdbcUtils.getConnection();
						try {
							jdbcUtils.updateByPreparedStatement(sql, params);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						dispose();
					} else if (resp == JOptionPane.NO_OPTION) {
						dispose();
					}
				}
			}
		});
		setVisible(true);
	}
}
