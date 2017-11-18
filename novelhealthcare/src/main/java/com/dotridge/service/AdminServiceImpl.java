package com.dotridge.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotridge.bean.AdminBeanTest;
import com.dotridge.dao.AdminDao;
import com.dotridge.dao.HospitalDao;
import com.dotridge.domain.Admin;

@Service
public class AdminServiceImpl implements AdminService 
{
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private HospitalDao hospitalDao;

	public Admin mapBeanToDomain(AdminBeanTest adminBean) 
	{
		Date date = new Date();
		
		Admin admin = new Admin();
		admin.setHospital(hospitalDao.getHospitalByUniqueName(adminBean.getHospitalName()));
		admin.setAdminId(adminBean.getAdminId());
		admin.setFirstName(adminBean.getFirstName());
		admin.setMiddleName(adminBean.getMiddleName());
		admin.setLastName(adminBean.getLastName());
		admin.setEmail(adminBean.getEmail());
		admin.setPassword(adminBean.getPassword());
		admin.setPhone(adminBean.getPhone());
		admin.setProfileDocuments(adminBean.getProfileDocuments());
		admin.setStatus(adminBean.isStatus());
		admin.setCreatedBy("Yugandhar");
		admin.setCreatedDate(date);
		admin.setModifiedBy("Yugandhar");
		admin.setModifiedDate(date);
		return admin;
	}

	public AdminBeanTest mapDomainToBean(Admin admin) 
	{
		AdminBeanTest adminBean = new AdminBeanTest();
		adminBean.setHospitalName(admin.getHospital().getHospitalName());
		adminBean.setAdminId(admin.getAdminId());
		adminBean.setFirstName(admin.getFirstName());
		adminBean.setMiddleName(admin.getMiddleName());
		adminBean.setLastName(admin.getLastName());
		adminBean.setEmail(admin.getEmail());
		adminBean.setPassword(admin.getPassword());
		adminBean.setPhone(admin.getPhone());
		adminBean.setProfileDocuments(admin.getProfileDocuments());
		adminBean.setStatus(admin.isStatus());
		return adminBean;
	}

	public AdminBeanTest createAdmin(AdminBeanTest adminBean) 
	{
		Admin adminDomain = mapBeanToDomain(adminBean);
		System.out.println(adminDomain.toString());
		AdminBeanTest adminBean2 = mapDomainToBean(adminDao.createAdmin(adminDomain));
		return adminBean2;
	}

	public AdminBeanTest updateAdmin(AdminBeanTest adminBean) 
	{
		Admin admin = adminDao.updateAdmin(mapBeanToDomain(adminBean));
		AdminBeanTest adminBean2 = mapDomainToBean(admin);
		return adminBean2;
	}

	public AdminBeanTest getAdminById(int id) 
	{
		Admin admin = adminDao.getAdminById(id);
		AdminBeanTest adminBean = mapDomainToBean(admin);
		return adminBean;
	}

	public List<AdminBeanTest> getAdminByName(String adminName) 
	{
		List<Admin> admins = adminDao.getAdminByName(adminName);
		List<AdminBeanTest> adminBeans = null;
		if(admins != null && !admins.isEmpty())
		{
			adminBeans = new ArrayList<AdminBeanTest>();
			for(Admin admin : admins)
			{
				adminBeans.add(mapDomainToBean(admin));
			}
			return adminBeans;
		}
		return null;
	}

	public List<AdminBeanTest> getAdminByEmail(String email) 
	{
		List<Admin> admins = adminDao.getAdminByEmail(email);
		List<AdminBeanTest> adminBeans = null;
		if(admins != null && !admins.isEmpty())
		{
			adminBeans = new ArrayList<AdminBeanTest>();
			for(Admin admin : admins)
			{
				adminBeans.add(mapDomainToBean(admin));
			}
			return adminBeans;
		}
		return null;
	}

	public List<AdminBeanTest> getAdminByPhone(long phoneNumber) 
	{
		List<Admin> admins = adminDao.getAdminByPhone(phoneNumber);
		List<AdminBeanTest> adminBeans = null;
		if(admins != null && !admins.isEmpty())
		{
			adminBeans = new ArrayList<AdminBeanTest>();
			for(Admin admin : admins)
			{
				adminBeans.add(mapDomainToBean(admin));
			}
			return adminBeans;
		}
		return null;
	}

	public List<AdminBeanTest> getAdminByStatus(Boolean status) 
	{
		List<Admin> admins = adminDao.getAdminByStatus(status);
		List<AdminBeanTest> adminBeans = null;
		if(admins != null && !admins.isEmpty())
		{
			adminBeans = new ArrayList<AdminBeanTest>();
			for(Admin admin : admins)
			{
				adminBeans.add(mapDomainToBean(admin));
			}
			return adminBeans;
		}
		return null;
	}

	public List<AdminBeanTest> getAllAdmins() 
	{
		List<Admin> adminsList = adminDao.getAllAdmins();
		List<AdminBeanTest> adminBeansList = null;
		if(adminsList != null && !adminsList.isEmpty())
		{
			adminBeansList = new ArrayList<AdminBeanTest>();
			for(Admin adminDomain : adminsList)
			{
				AdminBeanTest adminBean = mapDomainToBean(adminDomain);
				adminBeansList.add(adminBean);
			}
			return adminBeansList;
		}
		else
			throw new RuntimeException("No Hospital Available");
	}

	public boolean deleteAdmin(int id) 
	{
		boolean flag = adminDao.deleteAdmin(id);
		return flag;
	}

	public List<AdminBeanTest> getAllAdminsByPagining(int currentPage, int numberOfRecords) 
	{
		List<Admin> adminsList = adminDao.getAllAdminsByPagining(currentPage, numberOfRecords);
		List<AdminBeanTest> uiAdminList = null;
		if(adminsList != null && !adminsList.isEmpty())
		{
			uiAdminList = new ArrayList<AdminBeanTest>();
			for(Admin adminDomain : adminsList)
			{
				AdminBeanTest adminBean = mapDomainToBean(adminDomain);
				uiAdminList.add(adminBean);
			}
			return uiAdminList;
		}
		else
			throw new RuntimeException("No Hospital Available");
	}
}
