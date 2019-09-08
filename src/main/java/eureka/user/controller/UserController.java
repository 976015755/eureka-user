package eureka.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user/")
public class UserController {
    @RequestMapping(value = "login")
    public String login(@RequestParam(value = "name", defaultValue = "") String name, HttpServletRequest request) {
        return name + "登陆" + request.getRequestURL();
    }

}
