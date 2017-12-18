package document;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

/**
 * Microsoft office 2007
 * 
 * @author sxx.xu
 *
 */
public class WordDocx extends Doc {
	/*
	 * 可用,读docx apach poi库
	 */
	@Override
	public void readeOriginText(String path) throws Exception {

		OPCPackage op = POIXMLDocument.openPackage(path);
		POIXMLTextExtractor pte = new XWPFWordExtractor(op);
		content = pte.getText();
		System.out.println("word 2007获取的内容:\n" + content);

	}
}
