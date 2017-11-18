package com.dotridge.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:novelhealth-servlet.xml","classpath:applicationContext.xml"})
public class HospitalControllerTest
{
	@Autowired
	private HospitalController hospitalController;
	
	@Autowired
	WebApplicationContext context;
	
	Model model;
	
	@Before
	public void setup(){
		//model = context.getBean(ModelAndView.class);
		
		/*String[] strings = context.getBeanDefinitionNames();
		for(String str : strings){
			System.out.println("definition name:\t"+str);
		}
		*/
		model =new BindingAwareModelMap();
		/*RequestMappingHandlerMapping mapping = new RequestMappingHandlerMapping();
		mapping.*/
	}
	
	/*@Autowired
	private Model model;*/
	
	@Test
	public void getAllHospitalsTest()
	{
		System.out.println(model.getClass());
		String viewName = hospitalController.viewAllHospitals(model);
		Assert.assertNotNull(viewName);
		Assert.assertEquals("getHospitalBoard", viewName);
	}
}
