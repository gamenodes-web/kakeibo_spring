package kakeibo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KakeiboController {

    @GetMapping("/")
    public String index(Model model) {
        int sunyuu = 243000;
        int shishutsu = 41000;
        int chokin = sunyuu - shishutsu;
        
        model.addAttribute("sunyuu", sunyuu);
        model.addAttribute("shishutsu", shishutsu);
        model.addAttribute("chokin", chokin);
        
        return "index";
    }
}
