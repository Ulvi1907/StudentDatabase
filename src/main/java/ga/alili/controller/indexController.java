package ga.alili.controller;

import ga.alili.register.RequestForm;
import ga.alili.validator.RegisterFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class indexController {
    @Autowired
    private RegisterFormValidator registerFormValidator;

//    @InitBinder
//    public void initFormValidator(WebDataBinder binder){
//        binder.setValidator(registerFormValidator);
//    }

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("index");
        RequestForm form1 = new RequestForm();
        mav.addObject("form1", form1);
        return mav;
    }

    @GetMapping("/forgot")
    public  ModelAndView forgot(){
        ModelAndView modelAndView = new ModelAndView("forgot");
        RequestForm form2 = new RequestForm();
        modelAndView.addObject("form2", form2);
        return modelAndView;
    }
    @GetMapping("/register")
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView("register");
        RequestForm form = new RequestForm();
        modelAndView.addObject("form", form);
        return modelAndView;
    }
    @PostMapping("/register")
    public ModelAndView saveRegister(@ModelAttribute("form") @Valid RequestForm form, BindingResult result){
        ModelAndView mav = new ModelAndView("register");
        System.out.println("request form = "+form);

        if (result.hasErrors()){
            System.out.println("Xeta bas verdi. Xetalar = "+ result.getAllErrors());
            mav.setViewName("register");
        } else {
            System.out.println("Register Completed");
            mav.setViewName("register-success");
        }
        return mav;
    }
}
