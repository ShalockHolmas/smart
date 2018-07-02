package felixgu.start.util;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.lang.StringUtils;
import org.krysalis.barcode4j.TextAlignment;
import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.output.java2d.Java2DCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;
import sun.awt.FontDescriptor;
import sun.font.FontFamily;

/**
 * 条形码工具类
 *
 * @author tangzz
 * @createDate 2015年9月17日
 *
 */
public class BarCodeUtil {

    /**
     * 生成文件
     *
     * @param msg
     * @param path
     * @return
     */
    public static File generateFile(String msg, String path) {
        File file = new File(path);
        try {
            generate(msg, new FileOutputStream(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return file;
    }

    /**
     * 生成字节
     *
     * @param msg
     * @return
     */
    public static byte[] generate(String msg) {
        ByteArrayOutputStream ous = new ByteArrayOutputStream();
        generate(msg, ous);
        return ous.toByteArray();
    }

    /**
     * 生成到流
     *
     * @param msg
     * @param ous
     */
    public static void generate(String msg, OutputStream ous) {
        if (StringUtils.isEmpty(msg) || ous == null) {
            return;
        }

        Code39Bean bean = new Code39Bean();

        // 精细度
        final int dpi = 100;
        // module宽度
        final double moduleWidth = UnitConv.in2mm(1.0f / dpi);

        // 配置对象
        bean.setModuleWidth(moduleWidth);
        bean.setWideFactor(3);
        bean.setHeight(10);
        //bean.setModuleWidth(150);
        bean.doQuietZone(false);

        String format = "image/png";

        int barCodeWidth=150;
        int barCodeHeight=60;
        int HEIGHT_SPACE = 20;

        //图片宽度
        int imageWidth = barCodeWidth;
        // 图片高度
        int imageHeight = barCodeHeight + HEIGHT_SPACE ;
        Graphics2D graphics2D = (Graphics2D) new BufferedImage(imageWidth,imageHeight,BufferedImage.TYPE_INT_RGB).getGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        graphics2D.fillRect(0,0,imageWidth,imageHeight);
        //Font font = new Font("", F)
        graphics2D.setColor(Color.black);

        graphics2D.drawString("asdad",0,0);
        graphics2D.drawLine(10,10,20,20);


        //graphics2D.setBackground(Color.white);
        //graphics2D.create();
        // 输出到流
        //BitmapCanvasProvider canvas = new BitmapCanvasProvider(ous, format, dpi,
        //        BufferedImage.TYPE_BYTE_BINARY, false, 0);

        //canvas.deviceText("asdsad",2,10,4,null,10,TextAlignment.TA_CENTER);

        Java2DCanvasProvider provider = new Java2DCanvasProvider(graphics2D, 0);
        // 生成条形码
        bean.generateBarcode(provider, msg);

        // 结束绘制
        //try {
        //    canvas.finish();
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}
    }

    public static void main(String[] args) {
        String msg = "" +
                "test" +
                "";
        String path = "barcode.png";
        generateFile(msg, path);
    }
}