package com.crud.sheet.security;
import com.crud.sheet.data.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/register")
public class RegistrationController {
  
  private UserRepository userRepo;
  private PasswordEncoder passwordEncoder;

  public RegistrationController(
      UserRepository userRepo, PasswordEncoder passwordEncoder) {
    this.userRepo = userRepo;
    this.passwordEncoder = passwordEncoder;
  }
  
  @GetMapping
  public String registerForm(Model model) {
    model.addAttribute("form", new RegistrationForm());
    return "registration";
  }
  
  @PostMapping
  public String processRegistration(@ModelAttribute RegistrationForm form) {
    log.info(form.toString());
    userRepo.save(form.toUser(passwordEncoder));
    return "redirect:/login";
  }

}
