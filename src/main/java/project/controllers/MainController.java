package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import project.entity.Cat;
import project.repositories.CatRepository;
import project.services.CatsDataService;

import java.io.*;
import java.util.Base64;
import java.util.List;

@Controller

public class MainController {

    @Autowired
    private CatsDataService catsDataService;

    @GetMapping("/main")
    public String mainPage (Model model) throws UnsupportedEncodingException {
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
    public String sumbitAddCat(@RequestParam("name") String name, @RequestParam("age") int age,@RequestParam("description") String description, @RequestParam(value = "image") MultipartFile image, Model model) throws IOException {
        byte[] bytes = image.getBytes();
        Cat cat = new Cat(name, age, description, bytes);
        catsDataService.addCat(cat);
        return "redirect:/main";
    }
}
