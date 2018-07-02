import com.itextpdf.text.*;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

public class PdfTest {


    public static void main(String[] args) throws DocumentException, IOException {
        FileOutputStream fileOutputStream = null;
        Document document = new Document(PageSize.A4);
        PdfWriter writer = PdfWriter.getInstance(document,fileOutputStream);
        MyFooter footer = new MyFooter();
        writer.setPageEvent(footer);


        document.open();

        //設置標題和logo
        Font font = new Font(Font.FontFamily.COURIER, 27);
        Paragraph title = new Paragraph("CIRCLE WMS Package List", font);
        title.setLeading(2f);
        title.setSpacingBefore(30);
        title.setAlignment(Element.ALIGN_CENTER);
        Image image = Image.getInstance("https://img.circle.us/logos/logoS.png");
        image.scaleAbsolute(120, 15);
        image.setAbsolutePosition(20, PageSize.A4.getHeight() - 36);
        document.add(image);
        document.add(title);

    }

    void pd() {

    }

    public static class MyFooter extends PdfPageEventHelper {
        Font font = new Font(Font.FontFamily.UNDEFINED, 5, Font.ITALIC);

        public void onEndPage(PdfWriter writer, Document document) {
            PdfContentByte cb = writer.getDirectContent();
            Phrase footer = new Phrase("-" + writer.getPageNumber() + "-", font);
            ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, footer,
                    (document.right() - document.left()) / 2 + document.leftMargin(), document.bottom() - 10, 0);
        }
    }
}
