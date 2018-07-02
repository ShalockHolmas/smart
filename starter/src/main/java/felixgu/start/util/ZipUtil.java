package felixgu.start.util;

import org.springframework.util.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtil {

    private static final String zipChildName = "zip";

    private static String generateZip(String toFile, List<File> fromFiles, String tmpPath) throws Exception {

        verify(toFile, fromFiles, tmpPath);

        File file = new File(tmpPath);

        File zipFile = new File(tmpPath + File.separator + toFile);

        InputStream input = null;

        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFile));
            
            if (file.isDirectory()) {

                //添加压缩包内容
                for (File f :
                        fromFiles) {

                    input = new FileInputStream(f);

                    zipOutputStream.putNextEntry(new ZipEntry(zipChildName + File.separator + f.getName()));

                    int index = 0;

                    while ((index = input.read()) != -1) {
                        zipOutputStream.write(index);
                    }

                    input.close();
                }

                zipOutputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }

        return tmpPath + File.separator + toFile;

    }

    private static void verify(String toFile, List<File> fromFiles, String tmpPath) throws Exception {
        if (StringUtils.isEmpty(toFile)) {
            throw new Exception("zip util >>> output file is null");
        }

        if (StringUtils.isEmpty(fromFiles)) {
            throw new Exception("zip util >>> input files is null");
        }

        if (StringUtils.isEmpty(tmpPath)) {
            throw new Exception("zip util >>> save path is null");
        }
    }

    public static void main(String[] args) {

        List<File> list = new ArrayList<>();
        list.add(new File("/Users/circle/Documents/pic/upca.jpg"));
        list.add(new File("/Users/circle/Documents/pic/upce.jpg"));

        try {
            generateZip("test.zip",list,"/Users/circle/Documents/pic");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

