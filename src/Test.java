import document.Doc;
import document.HtmlDoc;
import document.PdfDoc;
import document.WordDocx;
import util.FileUtil;

public class Test {

	public static void main(String[] args) throws Exception {
		// testPDF();
		testWPS();
	}

	static void testWPS() throws Exception {
		Doc doc = new HtmlDoc();
		doc.readeOriginText("./doc/zzj.docx");
		// doc.readeOriginText("./doc/jmy.doc");
		// doc.readeOriginText("./doc/300英雄比赛修改及活动需求.docx");
	}

	static void testWord2007() throws Exception {
		Doc doc = new WordDocx();
		doc.readeOriginText("./doc/300英雄比赛修改及活动需求.docx");
	}

	static void testPDF() throws Exception {
		Doc doc = new PdfDoc();
		doc.readeOriginText("./doc/yyl.pdf");
	}
}
