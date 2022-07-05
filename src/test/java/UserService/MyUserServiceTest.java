package UserService;
import com.sunwei.jdbc.dao.UserDao;
import com.sunwei.jdbc.pojo.User;
import com.sunwei.jdbc.service.UserService;
import org.junit.Test;

import java.util.List;

public class MyUserServiceTest {

    @Test
    public void testFindUserByAge() {
        UserDao userDao = new UserDao();
        UserService userService = new UserService(userDao);
        List<User> userList = userService.findUserByAge(10);
        System.out.println(userList);
    }
}
