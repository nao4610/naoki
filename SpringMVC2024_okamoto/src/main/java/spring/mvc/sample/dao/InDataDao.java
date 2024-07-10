package spring.mvc.sample.dao;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spring.mvc.sample.form.UserForm;


public class InDataDao {
	
	
	public UserForm doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserForm userForm = new UserForm();
		userForm.setName(request.getParameter("name"));
		userForm.setNameKana(request.getParameter("nameKana"));
		userForm.setGender(request.getParameter("gender"));
		userForm.setBirthDate(request.getParameter("birthDate"));
		userForm.setJoinDate(request.getParameter("joinDate"));
		userForm.setAddress(request.getParameter("address"));
		userForm.setPhoneNumber(request.getParameter("phoneNumber"));
		userForm.setEmail(request.getParameter("email"));
		userForm.setSpouse(request.getParameter("spouse"));
		userForm.setDependents(request.getParameter("dependents"));
		userForm.setVisa(request.getParameter("visa"));
		userForm.setVisaExpiration(request.getParameter("visaExpiration"));
		userForm.setRecruitment(request.getParameter("recruitment"));
		userForm.setPosition(request.getParameter("position"));
		userForm.setAffiliation(request.getParameter("affiliation"));
		userForm.setDepartment(request.getParameter("department"));
		userForm.setRegion(request.getParameter("region"));
		userForm.setStore(request.getParameter("store"));
		userForm.setEmergencyContactName(request.getParameter("emergencyContactName"));
		userForm.setRelationship(request.getParameter("relationship"));
		userForm.setEmergencyPhoneNumber(request.getParameter("emergencyPhoneNumber"));
		userForm.setEmergencyAddress(request.getParameter("emergencyAddress"));
		return userForm;
	}

	
}