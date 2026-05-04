package kakeibo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class KakeiboController {

    private final KakeiboRepository repository;

    public KakeiboController(KakeiboRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<KakeiboData> list = repository.findAll();
        int goukei = list.stream()
            .mapToInt(KakeiboData::getChokin)
            .sum();
        model.addAttribute("list", list);
        model.addAttribute("goukei", goukei);
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
        List<KakeiboData> list = repository.findAll();
        int goukei = list.stream()
            .mapToInt(KakeiboData::getChokin)
            .sum();
        model.addAttribute("list", list);
        model.addAttribute("goukei", goukei);
        return "index";
    }
}
