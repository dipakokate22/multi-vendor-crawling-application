package multiVenderApp.demo.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import multiVenderApp.demo.service.CrawlingService;

@RestController
@RequestMapping("/api/crawl")
public class CrawlingController {

    @Autowired
    private CrawlingService crawlingService;

    @GetMapping
    public String crawl(@RequestParam String url) {
        try {
            return crawlingService.crawlWebsite(url);
        } catch (Exception e) {
            return "Failed to crawl: " + e.getMessage();
        }
    }
}
