package first.docotsubu.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import first.docotsubu.dto.User;
import first.docotsubu.service.LoginService;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private HttpSession session;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/Login")
    public String login(@RequestParam(name = "name") String name, @RequestParam(name = "pass") String pass,
            Model model) {
        var user = new User(name, pass);
        if (loginService.login(user)) {
            // セッションを明示して使う
            session.setAttribute("user", user);
            model.addAttribute("user", user);
            return "loginResult";
        } else {
            return "loginResult";
        }
    }
}
