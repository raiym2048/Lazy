package com.example.lazy.controller;

import com.example.lazy.models.Parser;
import com.example.lazy.models.Source;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

@Controller
public class MainController {
/*    @Autowired
    private UserRepository messageRepository;*/

    String forLoad = "101-100";
    int forLoadi = 0;
    boolean b = false;
    String url = "https://enter.kg/computers/noutbuki_bishkek";
    @RequestMapping(value="/do-stuff")
    public String doStuffMethod(Model model) throws IOException {

        if(forLoadi < 2200)
            forLoadi+=100;
        forLoad = String.valueOf((forLoadi+1))+"-"+String.valueOf((forLoadi));
        url = "https://enter.kg/computers/noutbuki_bishkek/"+ "results,"+forLoad;
        return home(model);

    }
    @RequestMapping(value="/do-stuff2")
    public String doStuffMethod2(Model model) throws IOException {

        if(forLoadi > 1)
            forLoadi-=100;
        forLoad = String.valueOf((forLoadi+1))+"-"+String.valueOf((forLoadi));
        url = "https://enter.kg/computers/noutbuki_bishkek/"+ "results,"+forLoad;
        return home(model);

    }
    @GetMapping("/")
    public String home(Model model) throws IOException {
        ArrayList<Source> books = new ArrayList<Source>();
        //ArrayList<String> srcs = new ArrayList<>();
        //model.addAttribute("title", "this is title");
        Parser parser = new Parser();


        org.jsoup.nodes.Document page = Jsoup.parse(new URL(url), 9000);
        System.out.println(url);
        Element main = page.select("div[id=main]").first();
        Elements rows = main.select("div[class=row]");
        Elements ur = rows.select("img[rel=product-image]");


        int ind1 = 0, ind2 = 0;



        for(int i = 0;i < ur.size();i++){



            Element row = rows.get(i);
            String date = row.select("span[class=prouct_name]").text();
            Source source = new Source();
            source.setName(date);

            String price = row.select("span[class=price]").text();
            source.setPrice(price);

            String artik = row.select("span[class=sku]").text();

            source.setArt(artik);

            Element ur2 = ur.get(i);

            String str = ur2.toString();
            int ind = str.indexOf("src"), space = ind-1;
            space = str.indexOf(" data-zoom=");

            String str2 = "https://enter.kg"+str.substring(ind+5, space-1);


            source.setSource(str2);
            books.add(source);

        }

        model.addAttribute("books",books);

        return "home";
    }
    @GetMapping("/buy")
    public String buying(Model model){
        return "buying";
    }
    @GetMapping("/company")
    public String Company(Model model){
        return "company";
    }
    @GetMapping("/delivery")
    public String Delivery(Model model){
        return "delivery";
    }
    @GetMapping("/credit")
    public String Credit(Model model){
        return  "credit";
    }
    @GetMapping("/garantyya")
    public String Garanty(Model model){
        return "garanty";
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
