package by.ushev.RESTful_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/carOffer")
public class CarOfferController {


    @GetMapping({"/", "/index"})
    public ModelAndView index(Model model) {
        return new ModelAndView("index");
    }

    @GetMapping("/all")
    public ModelAndView getAllBooksPage(Model model) {
        return new ModelAndView("carOfferList");
    }
}
