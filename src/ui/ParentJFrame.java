package ui;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class ParentJFrame extends JFrame {

	public ParentJFrame() throws HeadlessException {
		super();
		try {
			this.setIconImage(ImageIO.read(new File("xilinyinzhang.png")));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	protected void centerInScreen(int w, int h) throws HeadlessException {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();// 获取屏幕大小
		int width = dimension.width;
		int height = dimension.height;
		int x = (width - w) / 2;
		int y = (height - h) / 2;
		this.setLocation(x, y);
	}

	protected void fullScreen() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();// 获取屏幕大小
		int width = dimension.width;
		int height = dimension.height;
		setSize(width, height);
	}

}
