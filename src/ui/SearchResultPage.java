package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import util.FileUtil;

/**
 * 搜索结果页
 * 
 * @author sxx.xu
 *
 */
public class SearchResultPage extends ParentJFrame {

	private static final long serialVersionUID = -4473692617790395457L;
	private final String[] columnNames = { "id", "姓名", "拼音", "花名", "性别", "生日", "电话号码", "年龄", "邮箱", "学历", "工作年限", "婚姻状况",
			"工作城市", "居住城市", "职位", "公司", "文件地址", "最近修改时间", "目标公司", "推荐公司职位", "备注" };
	private List<Map<String, Object>> datas;
	private Object markStr;
	private String id;
	private int selectedRow, selectedCol;
	private SearchResultPage page;
	private Dimension dimension;

	public SearchResultPage() throws HeadlessException {
		super();
		this.setTitle("搜索结果");
		JLabel nameKey = new JLabel("姓    名:");
		JTextArea example2 = new JTextArea(8, 6);
		page = this;
		dimension = Toolkit.getDefaultToolkit().getScreenSize();// 获取屏幕大小
		int width = dimension.width * 8 / 10;
		int height = dimension.height * 8 / 10;
		dimension.setSize(width, height);
		centerInScreen(width, height);
	}

	JTable results;

	public void init(List<Map<String, Object>> datas) {

		Object[][] rowData = new Object[datas.size()][columnNames.length];
		Map<String, Object> map;
		int j = 0;
		for (int i = 0; i < datas.size(); i++) {
			map = datas.get(i);
			j = 0;
			for (String str : map.keySet()) {
				rowData[i][j] = map.get(str);
				System.out.println("rowData[" + i + "][" + j + "]=" + map.get(str));
				j++;
			}
		}

		results = new JTable(rowData, columnNames);
		results.setPreferredScrollableViewportSize(new Dimension(600, 100));// 设置表格的大小
		results.setRowHeight(60);// 设置每行的高度为60
		// friends.setRowHeight(0, 20);// 设置第1行的高度为15
		results.setRowMargin(5);// 设置相邻两行单元格的距离
		results.setEnabled(false);
		// friends.setRowSelectionAllowed(true);// 设置可否被选择.默认为false
		results.setSelectionBackground(Color.white);// 设置所选择行的背景色
		results.setSelectionForeground(Color.red);// 设置所选择行的前景色
		results.setGridColor(Color.black);// 设置网格线的颜色
		// friends.selectAll();// 选择所有行
		// results.setRowSelectionInterval(0, 1);// 设置初始的选择行,这里是1到3行都处于选择状态
		// results.clearSelection();// 取消选择
		results.setDragEnabled(true);//
		results.setShowGrid(true);// 是否显示网格线
		results.setShowHorizontalLines(true);// 是否显示水平的网格线
		results.setShowVerticalLines(true);// 是否显示垂直的网格线
		// friends.setValueAt("tt", 0, 0);// 设置某个单元格的值,这个值是一个对象
		results.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JTextArea area = new JTextArea(3, 10);

		results.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Point p = e.getPoint();
				selectedRow = results.rowAtPoint(p);
				selectedCol = results.columnAtPoint(p);

				if (e.getClickCount() == 2) {
					markStr = results.getValueAt(selectedRow, selectedCol);
					id = (String) results.getValueAt(selectedRow, 0);
					if ("备注".equals(results.getColumnName(selectedCol))) {
						new EditPage(page, String.valueOf(markStr), id, EditType.MARK);
					} else if ("推荐公司职位".equals(results.getColumnName(selectedCol))) {
						new EditPage(page, String.valueOf(markStr), id, EditType.RECOMMEND_COMPANY);
					} else if ("文件地址".equals(results.getColumnName(selectedCol))) {
						Object[] options = { "文件夹", "文件", "取消" };
						int flag = JOptionPane.showOptionDialog(null, "要打开所在文件夹吗?", "打开",
								JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
						if (flag == JOptionPane.YES_OPTION) {
							FileUtil.INSTANCE.openFolder(markStr.toString());
						} else if (flag == JOptionPane.NO_OPTION) {
							FileUtil.INSTANCE.openFile(markStr.toString());
						}
					} else if (!markStr.toString().isEmpty()) {
						Toolkit.getDefaultToolkit().getSystemClipboard()
								.setContents(new StringSelection(markStr.toString()), null);
						JOptionPane.showMessageDialog(null, "已复制:" + markStr.toString());
					}

				}
			}
		});
		results.doLayout();
		results.setBackground(new Color(199, 237, 204));

		JScrollPane pane3 = new JScrollPane(results);
		Box vbox = Box.createVerticalBox();
		vbox.add(Box.createVerticalStrut(5));
		vbox.add(pane3);

		vbox.setPreferredSize(dimension);
		fullScreen();
		setContentPane(vbox);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
	}

	/**
	 * 设置备注,推荐公司的值
	 */
	public void setSelectedValue(String str) {
		if (results != null) {
			results.setValueAt(str, selectedRow, selectedCol);
		}
	}
}
