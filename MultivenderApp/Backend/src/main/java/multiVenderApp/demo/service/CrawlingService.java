package multiVenderApp.demo.service;

import org.springframework.stereotype.Service;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

@Service
public class CrawlingService {

    public String crawlWebsite(String url) throws IOException {
        Document document = Jsoup.connect(url).get();
        return document.title();
    }
}