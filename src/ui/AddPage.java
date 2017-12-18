package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import document.DocResolveUtil;

/**
 * 添加
 * 
 * @author sxx.xu
 *
 */
public class AddPage extends ParentJPanel {
	private static final long serialVersionUID = 1L;

	public AddPage() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = getSize();
		JLabel fileKey = new JLabel("文件(夹):");
		JTextField fileValue = new JTextField(60);
		JButton chooseFile = new JButton("选  择");

		Box hbox0 = Box.createHorizontalBox();// 姓名,性别
		hbox0.add(fileKey);
		hbox0.add(Box.createHorizontalStrut(kvSpace));
		hbox0.add(fileValue);
		hbox0.add(Box.createHorizontalStrut(kvSpace));
		hbox0.add(chooseFile);

		Box vbox = Box.createVerticalBox();
		vbox.add(hbox0);
		vbox.add(Box.createVerticalStrut(itemVSpace));

		add(vbox, BorderLayout.CENTER);

		chooseFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				jfc.setCurrentDirectory(new File("D:\\"));// 设置默认路径
				jfc.setDialogTitle("选择目标文件(夹)");
				int state = jfc.showOpenDialog(null);
				if (state == 1) {
					return;
				}
				File f = jfc.getSelectedFile();
				fileValue.setText(f.getAbsolutePath());
				if (f.exists()) {
					if (f.isDirectory()) {
						File[] files = f.listFiles();
						for (int i = 0; i < files.length; i++) {
							new DocResolveUtil(files[i].getAbsolutePath());
							System.out.println(files[i].getAbsolutePath());
						}
					} else {
						new DocResolveUtil(f.getAbsolutePath());
					}
				} else {
					JOptionPane.showMessageDialog(getParent(), "error:文件不存在！");
				}
			}
		});

	}

	private void saveResume(String path) {

	}
}
