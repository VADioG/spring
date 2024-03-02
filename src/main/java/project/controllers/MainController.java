package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.entity.Cat;
import project.services.CatsDataService;

import java.io.*;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private  CatsDataService catsDataService;
//    @Autowired
//     public MainController(CatsDataService catsDataService)
//    {
//        this.catsDataService = catsDataService;
//    }



    @GetMapping("/main")
    public String mainPage (Model model) {
        List<Cat> cats = catsDataService.getAllCats();
        model.addAttribute("cats", cats);
        return "start";
    }
    @GetMapping("/main/add")
    public String addCatPage(Model model)
    {

        return "addPage";
    }
    @PostMapping("/main/add")
    public String submitAddCat(@RequestParam("name") String name, @RequestParam("age") int age,@RequestParam("description") String description, @RequestParam(value = "image") MultipartFile image, Model model) throws IOException {
        if (!image.isEmpty())
        {
            byte[] bytes = image.getBytes();
//            Cat cat = Cat.builder()
//                    .name(name)
//                    .age(age)
//                    .description(description)
//                    .image(bytes)
//                    .build();
            Cat cat = new Cat(name, age, description, bytes);
            catsDataService.addCat(cat);
        }

        return "redirect:/main";
    }
}
