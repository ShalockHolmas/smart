import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import felixgu.start.util.EncryptUtils;
import org.krysalis.barcode4j.impl.code39.Code39Bean;
import sun.jvm.hotspot.debugger.Page;

import java.io.*;
import java.util.*;

public class Test {


    public static void main(String[] args) {


        //OutputStream outputStream = null;
        //String filePath = null;
        //try{
        //    Code39Bean bean = new Code39Bean();
        //} catch (Exception e) {
        //
        //System.out.println(new String("http://shieldtest.circle.us/finance/recharge/manualRecharge.cloud").contains("shield"));
        //}
        //System.out.println(Integer.MAX_VALUE);
        System.exit(0);

        long s = System.nanoTime();
        double k = Math.random();
        HashSet<String> m = new HashSet<String>();
        Boolean r = false;
        String a = "";
        for (int i = 0; i < 10000; i++) {
            a = (EncryptUtils.md5("05440_" + String.valueOf(1528257816) + "_" + String.valueOf(Math.random())));
            if (m.contains(a)) {
                System.out.println(a);
                r = true;
            } else {
                m.add(a);
            }
            a = (EncryptUtils.md5("09789_" + String.valueOf(1528111882) + "_" + String.valueOf(Math.random())));
            if (m.contains(a)) {
                System.out.println(a);
                r = true;
            } else {
                m.add(a);
            }
            a = (EncryptUtils.md5("09882_" + String.valueOf(1528218427) + "_" + String.valueOf(Math.random())));
            if (m.contains(a)) {
                System.out.println(a);
                r = true;
            } else {
                m.add(a);
            }
            a = (EncryptUtils.md5("20684_" + String.valueOf(1528198861) + "_" + String.valueOf(Math.random())));
            if (m.contains(a)) {
                System.out.println(a);
                r = true;
            } else {
                m.add(a);
            }
        }
        ;
        //05440	1528257816
        //09789	1528111882
        //09882	1528218427
        //20684	1528198861

    }

    @org.junit.Test
    public void tt() {
        System.out.println(String.format("%10d", 1));
    }

    @org.junit.Test
    public void szz() {
        Object z = null;
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        System.out.println(list.size());
    }

    @org.junit.Test
    public void zcz() throws DocumentException, IOException {
        Document document = new Document(PageSize.A9);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PdfWriter writer = PdfWriter.getInstance(document, byteArrayOutputStream);
        document.open();
        Image image = Image.getInstance("https://img.circle.us/logos/logoS.png");
        image.scaleAbsolute(PageSize.A9.getWidth(), PageSize.A9.getHeight());
        image.setAbsolutePosition(0, 0);
        document.add(image);
        document.close();
        File file = new File("A9.pdf");
        if (!file.exists()) {
            file.createNewFile();
        }

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(byteArrayOutputStream.toByteArray());

        fileOutputStream.close();
        byteArrayOutputStream.close();
    }
}
