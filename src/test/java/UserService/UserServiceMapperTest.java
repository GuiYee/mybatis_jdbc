package UserService;

import com.sunwei.mybatis.mapper.User;
import com.sunwei.mybatis.service.UserService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserServiceMapperTest {

    private UserService userService;
    @Before
    public void before() {
        userService = new UserService();
    }

    @Test
    public void testFindById() {
        User byId = userService.findById(5);
        System.out.println(byId) ;
    }

    @Test
    public void testSaveUser() {
        User user  = new User();
        user.setName("小绿");
        user.setAge(23);
        user.setAddress("梨花北路");
        userService.saveUser(user);
        System.out.println(user);
    }

    @Test
    public void testUpdate() {
        User user  = new User();
        user.setId(7);
        user.setName("xiao");
        user.setAge(22);
        user.setAddress("丽华");
        int update = userService.updateUser(user);
        System.out.println(update);
    }

    @Test
    public void testDeleteUserById() {
        int deleteUserById = userService.deleteUserById(7);
        System.out.println(deleteUserById);
    }

    @Test
    public void testFindAgeById() {
        List<User> ageById = userService.findAgeById(21);
        System.out.println(ageById) ;
    }

    @Test
    public void testLimitUser() {
        List<User> limitUser = userService.limitUser(2, 2);
        System.out.println(limitUser) ;
    }

    @Test
    public void testLimitUserplugin() {
        List<User> users = userService.limitUserPlugin(2, 2);
        System.out.println(users);
    }

    @Test
    public void testfindByAgeWhere() {
        List<User> users = userService.findByAgeWhereService(11);
        System.out.println(users);
    }

    @Test
    public void testfindByUserForEach() {
        List<Integer> userIds = new ArrayList<>();
        userIds.add(1);
        userIds.add(5);
        List<User> users = userService.findUserListByIds(userIds);
        System.out.println(users);
    }

}
