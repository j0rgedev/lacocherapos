import model.dao.impl.UserDAOImpl;
import model.entity.User;

public class UserDAOImplTest {
    public static void main(String[] args) {
        UserDAOImpl userDAO = new UserDAOImpl();
        User user = userDAO.getUser("U0001");
        if (user == null) {
            System.out.println("User not found");
        } else {
            System.out.println(user.getRole().getRoleName());
        }
    }
}
