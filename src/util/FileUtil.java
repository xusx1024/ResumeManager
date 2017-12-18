package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public enum FileUtil {
	INSTANCE;

	public String getTemporaryPath(File file) {
		return file.getParent() + Constant.FILE_SEPARATE + file.getName() + Constant.FILE_EXTENSION;
	}

	/**
	 * 获取文件的总行数
	 * 
	 * @param file
	 * @return
	 */
	public int getFileLines(File file) {
		try {
			int count = 0;
			FileInputStream fis = new FileInputStream(file);
			Scanner scanner = new Scanner(fis);
			while (scanner.hasNext()) {
				scanner.nextLine();
				count++;
			}
			return count;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public void openFolder(String filePath) {
		try {
			filePath = filePath.substring(0, filePath.lastIndexOf("\\"));
			// Runtime.getRuntime().exec("cmd /c start" + filePath);
			java.awt.Desktop.getDesktop().open(new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void openFile(String filePath) {
		try {
			java.awt.Desktop.getDesktop().open(new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
