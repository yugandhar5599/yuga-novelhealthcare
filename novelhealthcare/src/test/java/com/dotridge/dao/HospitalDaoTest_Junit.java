package com.dotridge.dao;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.dotridge.domain.Hospital;

public class HospitalDaoTest_Junit
{
	private HospitalDao hospitalDao;
	
	@Before
	public void setUp()
	{
		hospitalDao = new HospitalDaoImpl();
	}
	
	@Test
	public void testGetAllHospitals()
	{
		List<Hospital> hospitalList = hospitalDao.getAllHospitals();
		Assert.assertNotNull(hospitalList);
		Assert.assertEquals(6, hospitalList.size());
	}
	
	@Test
	public void testCreateHospital()
	{
		Date date = new Date();
		//Hospital hospital = new Hospital(0,"Chandana","chandana@hp.com",9988440108L,4051778233L,"MVP","Near Ground","Vizag","AP",544889,null,null,true,"Yugandhar",date,"Yugandhar",date);
		Hospital hospital = new Hospital();
		hospital.setHospitalName("Padhma");
		hospital.setEmail("padhma@gmail.com");
		hospital.setPhone(9896440107L);
		hospital.setFax(404618992L);
		hospital.setAddress1("Madhapur");
		hospital.setAddress2("Near Hitex");
		hospital.setCity("Hyderabad");
		hospital.setState("TS");
		hospital.setZipCode(500024);
		hospital.setCreatedBy("Yugandhar");
		hospital.setCreatedDate(date);
		hospital.setModifiedBy("Yugandhar");
		hospital.setModifiedDate(date);
		Hospital hospitalTest = hospitalDao.createHospital(hospital);
		Hospital hospital1 = (Hospital) hospital.clone();
		//System.out.println(hospitalTest.getHospitalId());
		//System.out.println(hospital.getHospitalId());
		Assert.assertNotNull(hospitalTest);
		Assert.assertTrue(hospitalTest.getHospitalId() > 0);
		//Assert.assertSame("Yugandhar", hospitalTest.getCreatedBy());
		Assert.assertNotEquals(hospital1, hospitalTest);
		//Assert.assertFalse(hospital == hospitalTest);
	}
	
	@Test
	public void testGetHospitalById()
	{
		Hospital hospital = hospitalDao.getHospitalById(2);
		Assert.assertNotNull(hospital);
		Assert.assertEquals(4, hospital.getHospitalId());
	}
	
	@Test
	public void deleteHospital()
	{
		
	}
	
	@After
	public void tearDown()
	{
		hospitalDao = null;
	}
}
