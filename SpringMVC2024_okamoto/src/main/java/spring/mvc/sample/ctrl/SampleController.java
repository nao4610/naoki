package spring.mvc.sample.ctrl;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.mvc.sample.dao.InsertEmergencyDao;
import spring.mvc.sample.dao.InsertEmployeeDao;
import spring.mvc.sample.dao.InsertPartEmployeeDao;
import spring.mvc.sample.dao.InsertVisaDao;
import spring.mvc.sample.dao.SelectPartDao;
import spring.mvc.sample.dao.SelectPositionDao;
import spring.mvc.sample.dao.SelectRecruitDao;
import spring.mvc.sample.form.UserForm;

@Controller
public class SampleController {

	@Autowired
	private SelectPartDao selectPartDao;

	@Autowired
	private SelectPositionDao selectPositionDao;

	@Autowired
	private SelectRecruitDao selectRecruitDao;

	@RequestMapping(value = "/", method = GET)
	public String confirm(UserForm userForm, Model model) {
		try {
			List<String> positions = selectPositionDao.getPositionOptions();
			List<String> recruitments = selectRecruitDao.getRecruitmentOptions();
			List<String> departments = selectPartDao.getDepartmentOptions();
			List<String> regions = selectPartDao.getRegionOptions();
			List<String> stores = selectPartDao.getStoreOptions();

			model.addAttribute("positionOptions", positions);
			model.addAttribute("recruitmentOptions", recruitments);
			model.addAttribute("departmentOptions", departments);
			model.addAttribute("regionOptions", regions);
			model.addAttribute("storeOptions", stores);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "confirm";
	}

	@RequestMapping(value = "/completion", method = RequestMethod.POST)
	public String handleFormSubmission(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		InsertEmergencyDao.insertEmergency(request, response);
		InsertEmployeeDao.insertEmployee(request, response);
		InsertPartEmployeeDao.insertPartEmployee(request, response);
		InsertVisaDao.insertVisa(request, response);

		return "completion";
	}

}