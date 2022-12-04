package com.example.lazy.controller;

import com.example.lazy.models.Parser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

@Controller
public class MainController {
/*    @Autowired
    private UserRepository messageRepository;*/


    public void getPage() throws IOException {

    }
    @GetMapping("/")
    public String home(Model model) throws IOException {
        ArrayList<String> books = new ArrayList<>();
        //model.addAttribute("title", "this is title");
        Parser parser = new Parser();
        String url = "https://enter.kg/computers/noutbuki_bishkek";
        org.jsoup.nodes.Document page = Jsoup.parse(new URL(url), 3000);
        Element main = page.select("div[id=main]").first();
        Elements rows = main.select("div[class=row]");
        for(Element row : rows){
            String date = row.select("span[class=prouct_name]").text();
            books.add(date);
            System.out.println(date);
        }
        model.addAttribute("books",books);
        return "home";
    }

/*    @GetMapping("/about")
    public String blog(Model model){
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts",posts);
        return "blog-main";
    }*/

   /* @GetMapping String main(Map<String, Object> model){
        Iterable<Message> messages = messageRepository.findAll();
        model.put("messages", messages);
        return "main";
    }*/

}
