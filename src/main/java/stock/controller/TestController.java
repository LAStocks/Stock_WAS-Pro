package stock.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import stock.service.DividendExDateService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {


    private final DividendExDateService dividendExDateService;

    public TestController(DividendExDateService dividendExDateService) {
        this.dividendExDateService = dividendExDateService;
    }

    @GetMapping("/get")
    public String get(@RequestParam Map map) {
        System.out.println(map);
        return "test";
    }

    @GetMapping("/dividend-exdate")
    public List<String> getDividendExDate() {

        return dividendExDateService.scrapeDividendCalendar();
    }
}
