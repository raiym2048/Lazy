package com.example.lazy.controller;

import com.example.lazy.models.Adress;
import com.example.lazy.models.Parser;
import com.example.lazy.models.Source;
import com.example.lazy.repository.SourceRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;


@Controller
public class MainController {
/*    @Autowired
    private UserRepository messageRepository;*/
    private final SourceRepository repository;
    String forLoad = "101-100";
    int forLoadi = 0;
    boolean b = false;
    String url = "https://enter.kg/computers/noutbuki_bishkek";

    public MainController(SourceRepository repository) {
        this.repository = repository;
    }

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
    Source source = new Source();
    @GetMapping("/")
    public String home(Model model) throws IOException {
        ArrayList<Source> books = new ArrayList<Source>();
        Parser parser = new Parser();
        org.jsoup.nodes.Document page = Jsoup.parse(new URL(url), 9000);
        System.out.println(url);
        Element main = page.select("div[id=main]").first();
        Elements rows = main.select("div[class=row]");
        Elements ur = rows.select("img[rel=product-image]");
        for(int i = 0;i < ur.size();i++){
            Element row = rows.get(i);
            String date = row.select("span[class=prouct_name]").text();// name or description
            Source source = new Source();
            if(date.length() > 254)
                date = date.substring(0, 253);
            source.setName(date);
            String price = row.select("span[class=price]").text();// prices
            source.setPrice(price);
            String artik = row.select("span[class=sku]").text();// the vendor
            source.setArt(artik);
            Element ur2 = ur.get(i);
            String str = ur2.toString();
            int ind = str.indexOf("src"), space = ind-1;
            space = str.indexOf(" data-zoom=");//image for books
            String str2 = "https://enter.kg"+str.substring(ind+5, space-1);
            source.setSource(str2);
            books.add(source);

            repository.save(source);

        }
        model.addAttribute("book",books);
        return "home";
    }

    ArrayList<Source>buyingProducts = new ArrayList<>();
    Source lastProduct;
    @GetMapping("/add/{id}")
    public String editEmpForm(@PathVariable Long id, Model model) {
        //model.addAttribute("employee", booksService.getBooksById(id));
        Source product =  repository.getById(id);
        System.out.println(product + "akhdadhkahadhadjadhj");
//        }
        buyingProducts.add(product);
        lastProduct = product;

        model.addAttribute("product", product);

        return "buying";
    }
    @GetMapping("send")
            public String send(Model model){
        return "send";
    }
    Adress lastAdress;

    @PostMapping("/")
    public String buyit(@ModelAttribute Adress adress){
        //String name1 = name.toString();
        lastAdress = adress;
        System.out.println(adress.getEmail() + adress.getAdress() + adress.getPhone_number() + "aaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        senderService.sendEmail(adress.getEmail().toString(), adress.getAdress(), adress.getPhone_number());

        return "send";
    }
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private EmailSenderService senderService;

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
