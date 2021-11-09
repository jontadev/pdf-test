package pdftest;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.util.Matrix;

public class PDFBox {

	private static final String TEXT = "My text is: A1B2C3D4F5G6H7I8J9";

	public static void main(String[] args) throws IOException {
		// load the file and get the first page
		PDDocument document = PDDocument.load(PDFBox.class.getClassLoader().getResourceAsStream("test.pdf"));
		PDPage firstPage = document.getPage(0);

		// create the font of the text
		PDFont font = PDType1Font.HELVETICA;

		// start a new content stream
		PDPageContentStream contentStream = new PDPageContentStream(document, firstPage, AppendMode.APPEND, false);

		// define the text content, set the font, rotorate
		contentStream.beginText();
		contentStream.setFont(font, 12);
		contentStream.setTextMatrix(Matrix.getRotateInstance(Math.toRadians(90), 50, 600));
		contentStream.showText(TEXT);
		contentStream.endText();

		// close the content stream
		contentStream.close();

		// save the pdf document
		document.save("C:\\Users\\jonso\\Documents\\Java Projects\\PDFbox.pdf");

		document.close();
	}
}
