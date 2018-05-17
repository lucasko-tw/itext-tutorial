package org.lucasko.pdf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Hello world!
 *
 */
public class App {

	private String fontstyle = "msjh.ttf"; // chinese shape
	BaseFont bfChinese = null;
	Font fontCN = null;

	App() {
		// 設定中文字體
		try {
			this.bfChinese = BaseFont.createFont(fontstyle, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
			this.fontCN = new Font(bfChinese, 12, Font.NORMAL, new BaseColor(0, 0, 0));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws DocumentException, IOException {

		App app = new App();
		app.run();

	}

	private void run() throws DocumentException, IOException {

		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream("myDocument.pdf"));

		document.open();

		document.add(
				getParagraph("Hello World", 24, Font.BOLD, BaseColor.BLACK, PdfPCell.ALIGN_CENTER));
		document.add(getParagraph("2018-05-17", 14, Font.NORMAL, BaseColor.BLACK, PdfPCell.ALIGN_CENTER));

		document.add(getParagraph("Title：", 18, Font.NORMAL, BaseColor.BLACK, PdfPCell.ALIGN_LEFT));

		PdfPTable table = getInitTable();

		table = this.addTitle(table, "subtitle");
		table = this.addDescript(table);
		table = this.addTitle(table, "subtitle");
		table = this.addSuggestion(table);
		table = this.addHeader(table);
		table = this.addRow(table);
		table = this.addRow(table);
		table = this.addRow(table);
		table = this.addRow(table);

		document.add(table);
		document.close();

	}

	private PdfPTable addTitle(PdfPTable table, String title) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(new BaseColor(230, 230, 230));
		cell.setColspan(7);
		cell.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
		cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		cell.setPadding(6);

		cell.setPhrase(new Phrase(title, fontCN));
		table.addCell(cell);

		return table;
	}

	private PdfPTable addHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(new BaseColor(230, 230, 230));
		cell.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
		cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		cell.setPadding(6);

		List<String> titleList = Arrays.asList("#", "時間", "群組", "使用者", "AAA", "BBB");
		for (String title : titleList) {
			cell.setPhrase(new Phrase(title, fontCN));
			table.addCell(cell);
		}
		return table;
	}

	private PdfPTable addRow(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
		cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		cell.setPadding(6);

		List<String> titleList = Arrays.asList("1", "123", "456", "789", "111", "222");
		for (String title : titleList) {
			cell.setPhrase(new Phrase(title, fontCN));
			table.addCell(cell);
		}
		return table;
	}

	private PdfPTable addDescript(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		// cell_title.setBackgroundColor(new BaseColor(230, 230, 230));
		cell.setColspan(7);
		cell.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
		cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
		cell.setPadding(6);

		String text = "....................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................";

		cell.setPhrase(new Phrase(text, fontCN));
		table.addCell(cell);

		return table;
	}

	private PdfPTable addSuggestion(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		// cell_title.setBackgroundColor(new BaseColor(230, 230, 230));
		cell.setColspan(7);
		cell.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
		cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
		cell.setPadding(6);

		String text = "....................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................";

		cell.setPhrase(new Phrase(text, fontCN));
		table.addCell(cell);

		return table;
	}

	private Paragraph getParagraph(String content, int fontsize, int fontBold, BaseColor basecolor, int ALIGN)
			throws DocumentException, IOException {
		Paragraph p_1 = new Paragraph(content, new Font(bfChinese, fontsize, fontBold, basecolor));
		p_1.setAlignment(ALIGN);
		p_1.setSpacingAfter(15);
		return p_1;
	}

	private PdfPTable getInitTable() throws DocumentException {
		PdfPTable table = new PdfPTable(6); // 新增6列
		table.setWidths(new float[] { 1, 1, 1, 1, 2, 2 });
		table.setTotalWidth(520f);
		table.setLockedWidth(true);
		table.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		table.setSpacingAfter(30);
		return table;
	}

}
