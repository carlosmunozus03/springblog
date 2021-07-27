package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Ad;
import com.codeup.springblog.models.AdRepository;

import com.codeup.springblog.models.UserRepository;
import com.codeup.springblog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdController {
    private final AdRepository adDao;
    private final UserRepository userDao;
    private final EmailService emailService;

    public AdController(AdRepository adDao, UserRepository userDao, EmailService emailService) {
        this.adDao = adDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

    @GetMapping("/ads")
    public String index(Model model) {
        model.addAttribute("ads", adDao.findAll());
        return "ads/index";
    }

    @GetMapping("/ads/{n}")
    public String viewOne(@PathVariable long n, Model model) {
        Ad ad = adDao.findById(n);
        model.addAttribute("ad", ad);
        return "ads/show";
    }

    @GetMapping("/ads/first/{title}")
    public String viewOneByTitle(@PathVariable String title, Model model) {
        Ad ad = adDao.findByTitle(title);
        model.addAttribute("ad", ad);
        return "ads/show";
    }

    // adding a GetMapping to show the form to create a new Ad.
    @GetMapping("/ads/create")
    public String createAdForm(Model model) {
        // by adding our model as an argument, we can add a newly instantiated Ad object to pass to our form.
        // This will allow the user to directly correlate the fields with our Ad model.
        model.addAttribute("ad", new Ad());
        return "ads/create";
    }

    @PostMapping("/ads/create")
    public String createAd(@ModelAttribute Ad ad) {

        // Once the user submits the form to create an Ad, we want to assign a user to the Ad.
        ad.setUser(userDao.getById(1L));
        // Since we have our form binding our model data, we can just just save the Ad directly, without having to use RequestParam.
        adDao.save(ad);
        emailService.prepareAndSend("carlos.munoz.us03@gmail.com", "Post has been created",
                "You can find it with the id of " + ad.getId());
        return "redirect:/ads";
    }

    @GetMapping("ads/{id}/edit")
    public String editAdForm(@PathVariable long id, Model model) {
        Ad adToEdit = adDao.getById(id);
        model.addAttribute("ad", adToEdit);
        return "ads/create";
    }

    @PostMapping("/ads/{id}/edit")
    public String editAd(@PathVariable long id, @ModelAttribute Ad ad) {
        return createAd(ad);
    }

}