package bg.softuni.cookiesdemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CookieController {

    @GetMapping("/cookies")
    public String cookies(@CookieValue(
            name = "lang",
            defaultValue = "en") String lang,
                          Model model) {
        model.addAttribute("lang", lang);
        return "cookies";
    }

    @PostMapping("/cookies")
    public String submitCookies(@RequestParam String lang,
                                HttpServletResponse response) {

        Cookie langCookie = new Cookie("lang", lang);
        response.addCookie(langCookie);

        System.out.println("Preferred user language is: " + lang);
        return "redirect:/cookies";
    }
}
