package kakeibo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KakeiboController {

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

@PostMapping("/keisan")
public String keisan(
    @RequestParam int sunyuu,
    @RequestParam int shishutsu,
    Model model) {
    
    System.out.println("収入：" + sunyuu);
    System.out.println("支出：" + shishutsu);
    
    int chokin = sunyuu - shishutsu;
    System.out.println("貯金：" + chokin);
    
    model.addAttribute("chokin", chokin);
    return "index";
}
}
