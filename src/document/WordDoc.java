package document;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;

/**
 * Microsoft office 2003
 * 
 * @author sxx.xu
 *
 */
public class WordDoc extends Doc {

	@Override
	public void readeOriginText(String path) throws Exception {
		File file = new File(path);

		System.out.println(file.getName());
		FileInputStream fis = new FileInputStream(file);
		HWPFDocument doc = new HWPFDocument(fis);
		Range rang = doc.getRange();
		content = rang.text();
		System.out.println("word 2003获取的内容:\n" + content);

	}
}
