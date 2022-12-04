package com.example.lazy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
/*    @Autowired
    private UserRepository messageRepository;*/



    @GetMapping("/")
    public String home(Model model){
        //model.addAttribute("title", "this is title");
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
