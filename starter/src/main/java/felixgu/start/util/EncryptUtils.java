package felixgu.start.util;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class EncryptUtils {

    private static final String MESSAGE_DIGEST_TYPE_MD5 = "MD5";

    private static final String MESSAGE_DIGEST_TYPE_SHA1 = "SHA1";

    /**
     * 16进制数值
     */
    private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f' };

    /**
     * 生成MD5加密校验码
     *
     * @param string 待加密字符串
     * @return MD5加密校验码
     * @since 0.2
     */
    public static String md5(String string) {
        return encrypt(MESSAGE_DIGEST_TYPE_MD5, string);
    }

    /**
     * 生成MD5加密校验码
     *
     * @param file 待加密文件
     * @return MD5加密校验码
     * @since 0.2
     */
    public static String md5(File file) {
        return encrypt(MESSAGE_DIGEST_TYPE_MD5, file);
    }

    /**
     * 生成SHA1加密校验码
     *
     * @param string 待加密字符串
     * @return SHA1加密校验码
     * @since 0.2
     */
    public static String sha1(String string) {
        return encrypt(MESSAGE_DIGEST_TYPE_SHA1, string);
    }

    /**
     * 生成SHA1加密校验码
     *
     * @param file 待加密文件
     * @return SHA1加密校验码
     * @since 0.2
     */
    public static String sha1(File file) {
        return encrypt(MESSAGE_DIGEST_TYPE_SHA1, file);
    }

    /**
     * 生成指定算法的加密校验码
     *
     * @param algorithm 算法
     * @param str 待加密字符串
     * @return 加密校验码
     * @since 0.21
     */
    public static String encrypt(String algorithm, String str) {
        return encryptString(getEncrypt(algorithm), str);
    }

    /**
     * 生成指定算法的加密校验码
     *
     * @param algorithm 算法
     * @param file 待加密文件
     * @return 加密校验码
     * @since 0.21
     */
    public static String encrypt(String algorithm, File file) {
        return encryptFile(getEncrypt(algorithm), file);
    }

    /**
     * 获得指定的算法加密器
     *
     * @param algorithm 算法
     * @throws CatGroupException 如果没有参数algorithm指定的加密算法则抛出此异常
     * @return 加密器
     * @since 0.2
     */
    private static MessageDigest getEncrypt(String algorithm) {
        try {
            return MessageDigest.getInstance(algorithm);
        }
        catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException("无法创建" + algorithm + "算法加密器", ex);
        }
    }

    /**
     * 计算结果转为16进制表示
     *
     * @param bytes 待转换Byte数组
     * @return 转换结果
     * @since 0.2
     */
    public static String bytesToHex(byte[] bytes) {
        int length = bytes.length;
        StringBuilder sb = new StringBuilder(2 * length);
        for (int i = 0; i < length; i++) {
            sb.append(HEX_DIGITS[(bytes[i] & 0xf0) >> 4]);
            sb.append(HEX_DIGITS[bytes[i] & 0xf]);
        }
        return sb.toString();
    }

    /**
     * 使用加密器对目标字符串进行加密
     *
     * @param digest 加密器
     * @param string 目标字符串
     * @return 计算结果
     * @since 0.2
     */
    private static String encryptString(MessageDigest digest, String string) {
        return bytesToHex(digest.digest(string.getBytes()));
    }

    /**
     * 使用加密器对目标文件进行加密
     *
     * @param digest 加密器
     * @param file 目标文件
     * @throws CatGroupException 当文件未找到或读取错误时抛出此异常
     * @return 计算结果
     * @since 0.2
     */
    private static String encryptFile(MessageDigest digest, File file) {
        InputStream fis = null;
        try {
            fis = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int numRead = 0;
            while ((numRead = fis.read(buffer)) > 0) {
                digest.update(buffer, 0, numRead);
            }
        }
        catch (FileNotFoundException ex) {
            throw new RuntimeException("文件" + file.getName() + "未找到", ex);
        }
        catch (IOException ex) {
            throw new RuntimeException("文件" + file.getName() + "发生I/O错误", ex);
        }
        finally {
            try {
                fis.close();
            }
            catch (IOException ex) {
                throw new RuntimeException("无法关闭文件" + file.getName(), ex);
            }
        }
        return bytesToHex(digest.digest());
    }

//	private static String encryptFile(MessageDigest digest, byte[] bs) {
//		digest.update(bs);
//		return bytesToHex(digest.digest());
//	}

    public static void main(String[] args) {
        System.out.println(md5("123456"));
        System.out.println("123456".hashCode());
    }
}
