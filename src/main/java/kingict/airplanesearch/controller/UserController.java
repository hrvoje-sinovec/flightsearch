package kingict.airplanesearch.controller;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import kingict.airplanesearch.entity.User;
import kingict.airplanesearch.facade.UserFacade;
import kingict.airplanesearch.form.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/user")
public class UserController {

    private final UserFacade userFacade;

    public UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }


    @GetMapping("/register")
    public String getNew(Model model) {
        model.addAttribute("user", new User());
        return "registeruser";
    }

    @PostMapping("/register")
    public String register(@Valid @NotNull @ModelAttribute UserForm userForm){
        userFacade.register(userForm);
        return "index";
    }

    @GetMapping("/{userId}")
    public String getUserById(Model model, @PathVariable Long userId){
        User user = userFacade.getUserById(userId);
        model.addAttribute("user", user);
        return "userpage";
    }
}
