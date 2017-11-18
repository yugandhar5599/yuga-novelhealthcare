package com.dotridge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dotridge.bean.LoginBeanTest;
import com.dotridge.bean.ManageUserProfileBeanTest;

@Controller
public class HomeController 
{
	@RequestMapping(value="/getHomePage")
	public String getHomePage()
	{
		return "home";
	}
	
	@RequestMapping(value="/getLoginPage")
	public String getLoginPage(Model model)
	{
		model.addAttribute("loginBean", new LoginBeanTest());
		return "login";
	}
	
	@RequestMapping(value="/login")
	public String doLogin(@ModelAttribute("loginBean")LoginBeanTest loginBean)
	{
		System.out.println(loginBean.toString());
		String userName = loginBean.getUserId();
		if (userName != null && !userName.isEmpty()) 
		{
		   if (userName.equalsIgnoreCase("superadmin@email.com"))
		   {
			   return "getSuperAdminBoard";
		   }
		   else
		   {
			   return "home";
		   }
		}
		else
		{
			return "home";
		}
	}
	
	@RequestMapping(value="/getSignUpPage")
	public String getSignUpPage(Model model)
	{
		model.addAttribute("manageUserProfileBean",new ManageUserProfileBeanTest());
		return "registration";
	}
	
	@RequestMapping(value="/registration")
	public String doSignUp(@ModelAttribute("manageUserProfileBean") ManageUserProfileBeanTest manageUserProfileBean)
	{
		System.out.println(manageUserProfileBean.toString());
		//model.addAttribute("loginBean", new LoginBean());
		return "registartion";
	}
}
