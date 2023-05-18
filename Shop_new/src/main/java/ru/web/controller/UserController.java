package ru.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.web.model.User;
import ru.web.repository.UserRepository;


@Controller
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @RequestMapping(value ="/registration", method = RequestMethod.GET)
  public String showRegistrationPage(Model model) {
    model.addAttribute("user", new User());
    return "registration";
  }

  @RequestMapping(value ="/register", method = RequestMethod.POST)
  public String registerUser(@ModelAttribute("user") User user) {
    userRepository.saveUser(user);
    return "redirect:/login";
  }

  @RequestMapping(value ="/login", method = RequestMethod.GET)
  public String showLoginPage() {
    return "login";
  }
}