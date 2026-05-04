package kakeibo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KakeiboController {

    private final KakeiboRepository repository;

    public KakeiboController(KakeiboRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("list", repository.findAll());
        return "index";
    }

    @PostMapping("/keisan")
    public String keisan(
        @RequestParam int sunyuu,
        @RequestParam int shishutsu,
        Model model) {

        int chokin = sunyuu - shishutsu;
        KakeiboData data = new KakeiboData(sunyuu, shishutsu, chokin);
        repository.save(data);
        model.addAttribute("list", repository.findAll());
        return "index";
    }
}
