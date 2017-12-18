package document;

/**
 * 解析
 * 
 * @author sxx.xu
 *
 */
public class DocResolveUtil {

	private String filePath;

	public DocResolveUtil(String filePath) {
		this.filePath = filePath;

		try {
			if (filePath.endsWith("doc")) {
				resolveWord2003();
			} else if (filePath.endsWith("docx")) {
				resolveWord2007();
			} else if (filePath.endsWith("pdf")) {
				resolvePDF();
			} else {
				System.out.println(filePath + "并非合法文件!");
				return;
			}
		} catch (Exception e) {

			try {
				resolveWPS();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

	/**
	 * 解析word2007
	 * 
	 * @throws Exception
	 */
	private void resolveWord2007() throws Exception {
		Doc doc = new WordDocx();
		// doc.readeOriginText("./doc/300英雄比赛修改及活动需求.docx");
		doc.readeOriginText(filePath);
	}

	/**
	 * 解析word2003
	 */
	private void resolveWord2003() throws Exception {
		Doc doc = new WordDoc();
		// doc.readeOriginText("./doc/300英雄比赛修改及活动需求.docx");
		doc.readeOriginText(filePath);
	}

	/**
	 * 解析PDF
	 */
	private void resolvePDF() throws Exception {
		Doc doc = new PdfDoc();
		// doc.readeOriginText("./doc/yyl.pdf");
		doc.readeOriginText(filePath);
	}

	/**
	 * 解析wps
	 * 
	 * @throws Exception
	 */
	private void resolveWPS() throws Exception {
		Doc doc = new HtmlDoc();
		// doc.readeOriginText("./doc/zzj.docx");
		doc.readeOriginText(filePath);
	}
}
