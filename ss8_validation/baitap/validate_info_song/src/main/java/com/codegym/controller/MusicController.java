package com.codegym.controller;

import com.codegym.model.Music;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private IMusicService musicService;

    @GetMapping()
    public ModelAndView showAll(){
        List<Music> musics = musicService.findAll();
        return new ModelAndView("/music/list", "musics", musics);
    }

    @GetMapping("/create")
    public ModelAndView createPage(){
        return new ModelAndView("/music/create", "music", new Music());
    }

//    @PostMapping("/create")
//    public String createMusic(@ModelAttribute Music music, RedirectAttributes redirectAttributes){
//        musicService.save(music);
//        redirectAttributes.addFlashAttribute("message", "Create Music: " + music.getName() + " done!");
//        return "redirect:/music";
//    }

    @PostMapping("/create")
    public String checkValidation (@Valid @ModelAttribute("music")Music music, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()){
            return "/music/create";
        }

        musicService.save(music);
        return "redirect:/music";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updatePage(@PathVariable int id){
        return new ModelAndView("/music/update", "music", musicService.findById(id));
    }

//    @PostMapping("/update/{id}")
//    public String updateMusic(@ModelAttribute Music music, RedirectAttributes redirectAttributes){
//        musicService.save(music);
//        redirectAttributes.addFlashAttribute("message", "Update Music: " + music.getName() + " done!");
//        return "redirect:/music";
//    }

    @PostMapping("/update")
    public String update (@Valid @ModelAttribute("music")Music music, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()){
            return "/music/update";
        }

        musicService.save(music);
        return "redirect:/music";
    }

    @GetMapping("/delete/{id}")
    public String deleteMusic(@PathVariable int id){
        musicService.delete(id);
        return ("redirect:/music");
    }
}
