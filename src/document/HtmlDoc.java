package document;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import util.FileUtil;

/**
 * wps有些doc是html样式的,所以我们按照html读取
 * 
 * @author sxx.xu
 * @time 2017年11月27日17:21:42
 *
 */
public class HtmlDoc extends Doc {

	/**
	 * 获取文件内容
	 * 
	 * @param path
	 * @return
	 */
	@Override
	public void readeOriginText(String path) {
		String temp;
		BufferedReader br;
		StringBuffer sb = new StringBuffer();
		try {
			File file = new File(path);
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
			while ((temp = br.readLine()) != null) {
				sb.append(temp).append("\n");
			}
			content = clearStyleFContent(sb.toString());
			writeContentInFile(FileUtil.INSTANCE.getTemporaryPath(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 清除文本样式
	 * 
	 * @param content
	 * @return
	 */
	private String clearStyleFContent(String content) {
		String strHtml = content;// HTML文本代码
		String strClear = strHtml.replaceAll(".*?<body.*?>(.*?)<\\/body>", "$1")// 读出body内里所有内容
				.replaceAll("</?[^/?][^><]*>", "") // <br/>
				.replaceAll("&nbsp", "") // <br/>
				.replaceAll(";", "") // <br/>
				.replaceAll("[ ]+", " ")// 移除多余的连续空格，只留下一个空格。 <br/>
				.replaceAll("(?m)^\\s*$(\\n|\\r\\n)", "")// 移除空行 <br/>
				.replaceAll(":\n", ":").replaceAll("：\n", ":")// <br/>
				.replaceAll("：", ":")// <br/>
				.replaceAll("|", "")// <br/>
		;
		return strClear;
	}

}
