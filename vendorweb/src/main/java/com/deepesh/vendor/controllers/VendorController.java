package com.deepesh.vendor.controllers;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.deepesh.vendor.entities.Vendor;
import com.deepesh.vendor.repos.VendorRepository;
import com.deepesh.vendor.service.VendorService;
import com.deepesh.vendor.util.EmailUtil;
//import com.deepesh.vendor.util.ReportUtil;


@Controller
public class VendorController {
	
	
	@Autowired
	VendorService service;
	
	@Autowired
	VendorRepository repos;
	
	@Autowired
	EmailUtil emailUtil;
	
//	@Autowired
//	ReportUtil reportUtil;
	
	@Autowired
	ServletContext sc;
	
	
	@RequestMapping("/showCreate")
	public String showCreate() {
		
		return "createVendor";
	}
	
	@RequestMapping("/saveVen")
	public String saveVendor(@ModelAttribute("vendor") Vendor vendor, ModelMap modelMap) {
		Vendor savedVendor = service.saveVendor(vendor);
		String msg="The vendor has been saved with id:"+savedVendor.getId();
		modelMap.addAttribute("msg", msg);
		emailUtil.sendEmail("dsubedi1130@gmail.com", "Vendor Saved", "Vendor saved successfuly.");
		return "createVendor";
	}
	@RequestMapping("/displayVendors")
	public String displayVendors(ModelMap modelMap) {
		List<Vendor> allVendors = service.getAllVendors();
		modelMap.addAttribute("allVendors", allVendors);
		
		return "displayVendors";
	}
	
	@RequestMapping("/deleteVendor")
	public String deleteVendor(@RequestParam("id")int id, ModelMap modelMap) {
		Vendor vendor=new Vendor();
		vendor.setId(id);
		service.deleteVendor(vendor);
		List<Vendor> allVendors = service.getAllVendors();
		modelMap.addAttribute("allVendors", allVendors);
		return "displayVendors";
	}
	
	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id")int id,ModelMap modelMap) {
		Vendor vendor = service.getVendorById(id);
		modelMap.addAttribute("vendor", vendor);
		return "updateVendor";
	}
	
	@RequestMapping("/updateVen")
	public String updateVendor(@ModelAttribute("vendor") Vendor vendor, ModelMap modelMap) {
		service.updateVendor(vendor);
		List<Vendor> allVendors = service.getAllVendors();
		modelMap.addAttribute("allVendors", allVendors);
		return "displayVendors";
	}
	
	
	
//	@RequestMapping("/generateReport")
//	public String generateReport() {
//		String path = sc.getRealPath("/");	
//		List<Object[]> data = repos.findTypeAndTypeCount();
//		reportUtil.generatePieChart(path, data);
//		return "report";
//		
//	}

}
