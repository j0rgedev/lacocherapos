package model.utils;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

public class PasswordEncryption {
    private static final String HASH_ALGORITHM = "SHA-256";

    public static HashedPassword hashPassword(String password){
        try {
            byte[] salt = generateSalt();

            byte[] combinedBytes = concatBytes(password.getBytes(StandardCharsets.UTF_8), salt);

            byte[] hashedBytes = calculateHash(combinedBytes);

            return new HashedPassword(Base64.getEncoder().encodeToString(hashedBytes), Base64.getEncoder().encodeToString(salt));

        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error al generar el hash de la contraseña");
            return null;
        }
    }

    public static boolean verifyCredentials(String password, String saltValue, String hashedPassword) {
        try {
            byte[] salt = Base64.getDecoder().decode(saltValue);
            byte[] combinedBytes = concatBytes(password.getBytes(StandardCharsets.UTF_8), salt);
            byte[] hashedBytes = PasswordEncryption.calculateHash(combinedBytes);

            String calculatedHashedPassword = Base64.getEncoder().encodeToString(hashedBytes);

            return calculatedHashedPassword.equals(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            return false;
        }
    }

    private static byte[] generateSalt() throws NoSuchAlgorithmException {
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        return salt;
    }

    private static byte[] concatBytes(byte[] a, byte[] b) {
        byte[] result = new byte[a.length + b.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

    private static byte[] calculateHash(byte[] input) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
        return digest.digest(input);
    }
}
