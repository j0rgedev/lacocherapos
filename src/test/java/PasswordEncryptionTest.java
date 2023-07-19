import model.utils.HashedPassword;
import model.utils.PasswordEncryption;


public class PasswordEncryptionTest {
    public static void main(String[] args) throws Exception {
        String password = "angelayloslibros";
        HashedPassword hashedPassword = PasswordEncryption.hashPassword(password);
        System.out.println("Hashed password: " + hashedPassword.hashedPassword());
        System.out.println("Salt: " + hashedPassword.salt());
    }
}
