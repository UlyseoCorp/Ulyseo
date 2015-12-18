package com.ulyseo.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ulyseo.controller.front.FrontController;
import com.ulyseo.model.User;
import com.ulyseo.repository.UserRepository;
import com.ulyseo.util.Notification;

@RequestMapping("/")
@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private FrontController frontController;

	@RequestMapping(method = RequestMethod.GET, value = "")
	public ModelAndView index(Model model) {
		UserForm userForm = new UserForm();

		return new ModelAndView("index", "userForm", userForm);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public ModelAndView login(@Valid @ModelAttribute("userForm") UserForm userForm, HttpServletRequest request,
			Model model, BindingResult bindingResult) {

		ModelAndView result = null;

		User user = userRepository.findByEmailAndPassword(userForm.getEmail(), userForm.getPassword());

		if (user != null) {
			request.getSession().setAttribute("user", user);
			model.addAttribute("notif", new Notification("valid", "Bienvenue sur le site"));

			result = frontController.home(model);
		} else {

			bindingResult.addError(new FieldError("userForm", "email", ""));
			bindingResult.addError(new FieldError("userForm", "password", ""));

			model.addAttribute("userForm", userForm);
			model.addAttribute("notif", new Notification("error", "Email ou mot de passe incorecte"));
			result = new ModelAndView("index", "userForm", userForm);
		}

		return result;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/logout")
	public ModelAndView logout(Model model, HttpServletRequest request) {

		model.addAttribute("notif", new Notification("valid", "Merci de votre visite."));
		request.getSession().invalidate();

		return index(model);
	}

}
