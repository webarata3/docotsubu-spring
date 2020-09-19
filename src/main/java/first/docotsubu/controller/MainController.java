package first.docotsubu.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import first.docotsubu.dto.User;
import first.docotsubu.entity.Mutter;
import first.docotsubu.service.MutterService;

@Controller
public class MainController {
    @Autowired
    private HttpSession session;

    @Autowired
    private MutterService mutterService;

    @GetMapping("/Main")
    public String main(Model model) {
        var user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        model.addAttribute("mutters", mutterService.getAllMutter());
        return "main";
    }

    @PostMapping("/Main")
    public String mainPost(@RequestParam("text") String text, Model model) {
        var user = (User) session.getAttribute("user");

        if (text.isEmpty()) {
            model.addAttribute("errorMsg", "つぶやきが入力されていません");
        } else {
            var mutter = new Mutter(user.getName(), text);
            mutterService.add(mutter);
        }

        model.addAttribute("user", user);
        model.addAttribute("mutters", mutterService.getAllMutter());
        return "main";
    }
}
