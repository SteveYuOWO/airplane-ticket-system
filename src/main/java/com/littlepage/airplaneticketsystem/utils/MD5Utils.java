package com.littlepage.airplaneticketsystem.utils;

import java.security.*;

/**
 * To deal with MD5 algorithm
 */
public class MD5Utils {

    /**
     * encrypt MD5 message
     * @param str not encrypt message
     * @return    encrypted message
     */
    public static String code(String str){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] byteDigest = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < byteDigest.length; offset++) {
                i = byteDigest[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            //32 bit encryption
            return buf.toString();
            // 16 bit encryption
            //return buf.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

    }
}
