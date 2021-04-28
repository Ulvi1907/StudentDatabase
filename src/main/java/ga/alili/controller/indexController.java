package ga.alili.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class indexController {
    @GetMapping("/")
    public ModelAndView index(
            @RequestParam(name = "id", required = false) String ad
    ){
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }
    @GetMapping("/register")
    public ModelAndView register(
            @RequestParam(name = "name",required = false) String name
    ) {
        ModelAndView modelAndView = new ModelAndView("register");
        modelAndView.addObject("Name", name);
        return modelAndView;
    }
}
