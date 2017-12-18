package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 主页,控制几个选项卡的切换
 * 
 * @author sxx.xu
 *
 */
public class MainPage extends ParentJFrame {

	private JTabbedPane tabbedPane;

	// frame 使用layout排布容器
	// layout控制容器
	// 容器盛放组件
	public MainPage() throws HeadlessException {
		super();
		String items[] = { "搜索", "添加", "修改", "删除", "更多" };
		this.setTitle("西邻人才管理系统 beat1.0");
		Dimension d = new Dimension(800, 480);
		this.setMinimumSize(d);
		this.setSize(800, 480);
		centerInScreen(800, 480);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		tabbedPane = new JTabbedPane();
		for (String item : items) {
			tabbedPane.add(item, null);
		}
		tabbedPane.setTabPlacement(JTabbedPane.LEFT);
		add(tabbedPane, "Center");
		loadTab(0);
		tabbedPane.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				int n = tabbedPane.getSelectedIndex();
				loadTab(n);
			}
		});
	}

	public void loadTab(int n) {
		switch (n) {
		case 0:
			tabbedPane.setComponentAt(n, new SearchPage());
			break;
		case 1:
			tabbedPane.setComponentAt(n, new AddPage());
			break;
		case 2:
			tabbedPane.setComponentAt(n, new UpdatePage("修改"));
			break;
		case 3:
			tabbedPane.setComponentAt(n, new UpdatePage("删除"));
			break;
		case 4:
			tabbedPane.setComponentAt(n, new MoreInfoPage());
			break;
		default:
			break;
		}
	}
}
