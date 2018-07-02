package felixgu.start.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.krysalis.barcode4j.BarcodeDimension;
import org.krysalis.barcode4j.HumanReadablePlacement;
import org.krysalis.barcode4j.impl.AbstractBarcodeBean;
import org.krysalis.barcode4j.impl.codabar.CodabarBean;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.impl.int2of5.Interleaved2Of5Bean;
import org.krysalis.barcode4j.impl.postnet.POSTNETBean;
import org.krysalis.barcode4j.impl.upcean.EAN13Bean;
import org.krysalis.barcode4j.impl.upcean.EAN8Bean;
import org.krysalis.barcode4j.impl.upcean.UPCABean;
import org.krysalis.barcode4j.impl.upcean.UPCEBean;
import org.krysalis.barcode4j.output.java2d.Java2DCanvasProvider;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class BarcodeImage {


//    * org.krysalis.barcode4j.impl.codabar.CodabarBean
//    * org.krysalis.barcode4j.impl.code128.Code128Bean
//    * org.krysalis.barcode4j.impl.code39.Code39Bean
//    * org.krysalis.barcode4j.impl.int2of5.Interleaved2Of5Bean
//    * org.krysalis.barcode4j.impl.postnet.POSTNETBean
//    * org.krysalis.barcode4j.impl.upcean.EAN13Bean
//    * org.krysalis.barcode4j.impl.upcean.EAN8Bean
//    * org.krysalis.barcode4j.impl.upcean.UPCABean
//    * org.krysalis.barcode4j.impl.upcean.UPCEBean

    public static Image getBarcodeCodabar(String value, String ext) {
        AbstractBarcodeBean barcode = new CodabarBean();
        barcode.setMsgPosition(HumanReadablePlacement.HRP_BOTTOM);
        return getBarcode(value, barcode, ext);
    }

    public static Image getBarcodeCode39(String value, String ext) {
        AbstractBarcodeBean barcode = new Code39Bean();
        barcode.setMsgPosition(HumanReadablePlacement.HRP_BOTTOM);
        return getBarcode(value, barcode, ext);
    }

    public static Image getBarcodeInterleaved2Of5(String value, String ext) {
        AbstractBarcodeBean barcode = new Interleaved2Of5Bean();
        barcode.setMsgPosition(HumanReadablePlacement.HRP_BOTTOM);
        return getBarcode(value, barcode, ext);
    }

    public static Image getBarcodePOSTNET(String value, String ext) {
        AbstractBarcodeBean barcode = new POSTNETBean();
        barcode.setMsgPosition(HumanReadablePlacement.HRP_BOTTOM);
        return getBarcode(value, barcode, ext);
    }

    public static Image getBarcodeUPCA(String value, String ext) {
        AbstractBarcodeBean barcode = new UPCABean();
        barcode.setMsgPosition(HumanReadablePlacement.HRP_BOTTOM);
        return getBarcode(value, barcode, ext);
    }

    public static Image getBarcodeUPCE(String value, String ext) {
        AbstractBarcodeBean barcode = new UPCEBean();
        barcode.setMsgPosition(HumanReadablePlacement.HRP_BOTTOM);
        return getBarcode(value, barcode, ext);
    }

    public static Image getBarcodeEAN13(String value, String ext) {
        AbstractBarcodeBean barcode = new EAN13Bean();
        barcode.setMsgPosition(HumanReadablePlacement.HRP_BOTTOM);
        return getBarcode(value, barcode, ext);
    }

    public static Image getBarcodeEAN8(String value, String ext) {
        AbstractBarcodeBean barcode = new EAN8Bean();
        barcode.setMsgPosition(HumanReadablePlacement.HRP_BOTTOM);
        return getBarcode(value, barcode, ext);
    }

    public static Image getBarcode128(String value, String ext) {
        AbstractBarcodeBean barcode = new Code128Bean();
        barcode.setMsgPosition(HumanReadablePlacement.HRP_NONE);
        return getBarcode(value, barcode, ext);
    }

    private static Image getBarcode(String value, AbstractBarcodeBean barcode, String ext) {

        barcode.setModuleWidth(1.0);
        barcode.setHeight(30);
        barcode.setBarHeight(40);
        barcode.setFontSize(10.0);
        barcode.setQuietZone(10.0);
        barcode.doQuietZone(true);
        BarcodeDimension dim = barcode.calcDimensions(value);
        //System.out.println("code width :" + dim.getWidth());
        //System.out.println("code height :" + dim.getHeight());
        int width = (int) dim.getWidth(0) + 20;
        int height = (int) dim.getHeight(0) + 40;

        //System.out.println("pic width" + width);
        //System.out.println("pic height" + height);
        BufferedImage imgtext = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = imgtext.createGraphics();

        g2d.fillRect(0, 0, width, height);

        g2d.setColor(Color.BLACK);

        g2d.drawString(ext,10, (int) (dim.getHeight() + 10));

        try {
            barcode.generateBarcode(new Java2DCanvasProvider(g2d, 0), value);
        } catch (IllegalArgumentException e) {
        }

        g2d.dispose();

        return imgtext;
    }

    public static void main(String[] args) {
        try {
            //ImageIO.write((RenderedImage) getBarcodeCode39("55555555"),"jpg",new File("test.jpg"));

            //ArrayList<String > list= new ArrayList<>();
            ObjectMapper mapper = new ObjectMapper();

            Map<String, String> list = new HashMap<>();
            list.put("param1","value1value1value1");
            list.put("param2","value2value2value2");

            String value = mapper.writeValueAsString(list);
            value = "1";

            ImageIO.write((RenderedImage) getBarcode128(value,"codabar extinfo"),"jpg",new File("/Users/circle/Documents/pic/codabar.jpg"));
            ImageIO.write((RenderedImage) getBarcode128(value,"code39 extinfo"),"jpg",new File("/Users/circle/Documents/pic/code39.jpg"));
            ImageIO.write((RenderedImage) getBarcode128(value,"interleaved extinfo"),"jpg",new File("/Users/circle/Documents/pic/interleaved.jpg"));
            ImageIO.write((RenderedImage) getBarcode128(value,"postnet extinfo"),"jpg",new File("/Users/circle/Documents/pic/postnet.jpg"));
            ImageIO.write((RenderedImage) getBarcode128(value,"upca extinfo"),"jpg",new File("/Users/circle/Documents/pic/upca.jpg"));
            ImageIO.write((RenderedImage) getBarcode128(value,"upce extinfo"),"jpg",new File("/Users/circle/Documents/pic/upce.jpg"));
            ImageIO.write((RenderedImage) getBarcode128(value,"ean13 extinfo"),"jpg",new File("/Users/circle/Documents/pic/ean13.jpg"));
            ImageIO.write((RenderedImage) getBarcode128(value,"ean8 extinfo"),"jpg",new File("/Users/circle/Documents/pic/ean8.jpg"));
            ImageIO.write((RenderedImage) getBarcode128(value,"code128 extinfo"),"jpg",new File("/Users/circle/Documents/pic/code128.jpg"));





            //ImageIO.write((RenderedImage) getBarcode128("codabar","codabar extinfo"),"jpg",new File("/Users/circle/Documents/pic/codabar.jpg"));
            //ImageIO.write((RenderedImage) getBarcode128("code39","code39 extinfo"),"jpg",new File("/Users/circle/Documents/pic/code39.jpg"));
            //ImageIO.write((RenderedImage) getBarcode128("interleaved","interleaved extinfo"),"jpg",new File("/Users/circle/Documents/pic/interleaved.jpg"));
            //ImageIO.write((RenderedImage) getBarcode128("postnet","postnet extinfo"),"jpg",new File("/Users/circle/Documents/pic/postnet.jpg"));
            //ImageIO.write((RenderedImage) getBarcode128("upca","upca extinfo"),"jpg",new File("/Users/circle/Documents/pic/upca.jpg"));
            //ImageIO.write((RenderedImage) getBarcode128("upce","upce extinfo"),"jpg",new File("/Users/circle/Documents/pic/upce.jpg"));
            //ImageIO.write((RenderedImage) getBarcode128("ean13","ean13 extinfo"),"jpg",new File("/Users/circle/Documents/pic/ean13.jpg"));
            //ImageIO.write((RenderedImage) getBarcode128("ean8","ean8 extinfo"),"jpg",new File("/Users/circle/Documents/pic/ean8.jpg"));
            //ImageIO.write((RenderedImage) getBarcode128("code128","code128 extinfo"),"jpg",new File("/Users/circle/Documents/pic/code128.jpg"));
            //
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}