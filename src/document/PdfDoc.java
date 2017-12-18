package document;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 * 识别文字pdf
 * 
 * @author sxx.xu
 *
 */
public class PdfDoc extends Doc {
	@Override
	public void readeOriginText(String path) throws Exception {
		PDDocument doc = null;
		File file = null;

		file = new File(path);
		doc = PDDocument.load(file);
		PDFTextStripper pts = new PDFTextStripper();
		content = pts.getText(doc);
		doc.close();
		System.out.println("pdf获取的内容:\n" + content);

	}
}
