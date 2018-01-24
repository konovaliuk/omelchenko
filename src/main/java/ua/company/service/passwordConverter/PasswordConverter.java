package ua.company.service.passwordConverter;

import org.apache.log4j.Logger;
import ua.company.service.logger.MyLogger;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * PasswordConverter.java - convert password to store in database.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 24.01.2018
 */
public class PasswordConverter {
    private static final Logger LOGGER = MyLogger.getLOGGER(PasswordConverter.class);
    /**
     * Ñonvert password to store in database.
     *
     * @param password password of user.
     * @return coded password for storing in database
     * vice versa
     */
    public static String passwordConverter(String password){
        MessageDigest messageDigest = null;
        byte[] digest = new byte[0];
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(password.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            LOGGER.info("Password was not converted", e);
        }
        BigInteger bigInt = new BigInteger(1, digest);
        String md5Hex = bigInt.toString(16);

        while( md5Hex.length() < 32 ){
            md5Hex = "0" + md5Hex;
        }
        return md5Hex;
    }
}
