package com.drq.controller.Customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.drq.dao.impl.BrowseRecordsDaoImpl;
import com.drq.dao.inter.BrowseRecordsDaoInter;
import com.drq.dto.BrowseRecords;

@RequestMapping("/customer/browseRecords")
@Controller
public class BrowseRecordsController {
	BrowseRecordsDaoInter  browseRecordsDao = new BrowseRecordsDaoImpl();

	@RequestMapping("/showBrowseRecords")
	public String showBrowseRecords(ModelMap modelMap){
		List<BrowseRecords> browseRecordsList = browseRecordsDao.getBrowseRecordsList();
		modelMap.put("browseRecordsList", browseRecordsList);
		return "browseRecords";
	}

}
