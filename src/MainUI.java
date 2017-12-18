import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import ui.MainPage;

/**
 * 程序入口
 * 
 * @author sxx.xu
 *
 */
public class MainUI {

	public static void main(String[] args) {
		try {
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
			BeautyEyeLNFHelper.launchBeautyEyeLNF();
		} catch (Exception e) {
			e.printStackTrace();
		}
		new MainPage();
	}
}
