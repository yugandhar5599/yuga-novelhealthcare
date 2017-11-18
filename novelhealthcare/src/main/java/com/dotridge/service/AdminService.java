package com.dotridge.service;

import java.util.List;

import com.dotridge.bean.AdminBeanTest;
import com.dotridge.domain.Admin;

public interface AdminService 
{
	public Admin mapBeanToDomain(AdminBeanTest adminBean);
	
	public AdminBeanTest mapDomainToBean(Admin adminDomain);
	
	public AdminBeanTest createAdmin(AdminBeanTest adminBean);
	
	public AdminBeanTest updateAdmin(AdminBeanTest adminBean);
	
	public AdminBeanTest getAdminById(int id);
	
	public List<AdminBeanTest> getAdminByName(String adminName);
	
	public List<AdminBeanTest> getAdminByEmail(String email);
	
	public List<AdminBeanTest> getAdminByPhone(long phoneNumber);
	
	public List<AdminBeanTest> getAdminByStatus(Boolean status);
	
	public List<AdminBeanTest> getAllAdmins();
	
	public boolean deleteAdmin(int id);
	
	public List<AdminBeanTest> getAllAdminsByPagining(int currentPage, int numberOfRecords);
}
