package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Login.spring")
public class LoginController {
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processCredentials(@RequestParam("userName")String userName,@RequestParam("password")String password) {
		String message = "Invalid credentials";
		if(!userName.equals("") && !password.equals("")) {
			if(userName.equals(password)) {
				message = "Welcome " + userName + "!!";
			}
		}
		return new ModelAndView("results","message",message);
	}
}
