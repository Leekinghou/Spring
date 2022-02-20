package ioc.controlloer;

import ioc.service.UserService;
import org.springframework.stereotype.Controller;

/**
 * @author: lijinhao
 * @date: 2022/02/18 13:40
 */

public class UserController {
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
