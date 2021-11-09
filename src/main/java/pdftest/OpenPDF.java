package pdftest;

import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

public class OpenPDF {

	private static final String TEXT = "My text is: A1B2C3D4F5G6H7I8J9";

	public static void main(String[] args) throws IOException {
		// read the current pdf file
		PdfReader reader = new PdfReader(IText.class.getClassLoader().getResourceAsStream("test.pdf"));
		
		// set extra content to the current pdf file
		PdfStamper pdfStamper = new PdfStamper(reader,
				new FileOutputStream("C:\\Users\\jonso\\Documents\\Java Projects\\OpenPDF.pdf"));

		// get first page
		PdfContentByte pageContent = pdfStamper.getOverContent(1);

		// add new text
		pageContent.beginText();
		pageContent.setFontAndSize(BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1250, false), 12);
		pageContent.showTextAligned(PdfContentByte.ALIGN_LEFT, TEXT, 20, 600, 90);
		pageContent.endText();

		// close the stamper
		pdfStamper.close();
	}

}
