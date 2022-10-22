package com.example.luu_giu_hom_thu_dientu.controller;

import com.example.luu_giu_hom_thu_dientu.model.DeclarationMedical;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DeclarationMedicalController {
    public static List<Integer> listNamSinh;
    public static List<String> listGender;
    public static List<String> listQuocTich;
    public static List<String> listPhuongTien;

    static {
        listNamSinh=new ArrayList<>();
        listGender=new ArrayList<>();
        listQuocTich=new ArrayList<>();
        listPhuongTien=new ArrayList<>();

        for (int i=1900; i<=2022; i++)
            listNamSinh.add(i);

        listGender.add("Nam");
        listGender.add("Nu");
        listGender.add("Khac");

        listQuocTich.add("Viet Nam");
        listQuocTich.add("Trung Quoc");
        listQuocTich.add("Thai Lan");
        listQuocTich.add("Campuchia");

        listPhuongTien.add("Tau bay");
        listPhuongTien.add("Tau thuyen");
        listPhuongTien.add("O to");
        listPhuongTien.add("khac");
    }

    @GetMapping("/form")
    public String form(Model model)
    {
        model.addAttribute("declarationMedical",new DeclarationMedical());
        model.addAttribute("listNamSinh",listNamSinh);
        model.addAttribute("listGender",listGender);
        model.addAttribute("listQuocTich",listQuocTich);
        model.addAttribute("listPhuongTien",listPhuongTien);
        return "index";
    }

    @PostMapping("/show")
    public ModelAndView save(@ModelAttribute DeclarationMedical declarationMedical)
    {
        ModelAndView modelAndView=new ModelAndView("show","declarationMedical",declarationMedical);
        return modelAndView;
    }
}
