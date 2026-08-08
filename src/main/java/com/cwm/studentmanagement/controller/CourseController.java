package com.cwm.studentmanagement.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cwm.studentmanagement.dto.CourseDTO;
import com.cwm.studentmanagement.exception.GlobalExecptionHandler;
import com.cwm.studentmanagement.service.CourseService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/course")
public class CourseController {
 
	
	private static final Logger Log = LoggerFactory.getLogger(CourseController.class);
	
	
	private final CourseService courseService;
	
	CourseController(CourseService courseService){
	this.courseService = courseService;
	}
	
	
	@GetMapping("/new")
	public String showCreateCourse(Model model) {
		Log.info("Get /course/new - showing create course page.");
		model.addAttribute("courseDto", new CourseDTO());
		return "add-course";
	}
	
	@GetMapping("/list")
	public String listCourses(@RequestParam(defaultValue = "0")int page,
			                  @RequestParam(defaultValue = "3")int size,
			                  Model model,
			                  @RequestParam(value = "message", required = false) String message){
		
		Log.info("Get /course/list - showing course list page.");
		
		Page<CourseDTO> courses = courseService.getCourses(page, size);
		model.addAttribute("courses", courses);
		model.addAttribute("message", message);
		
		
		return "courses";
		
	}
	
	@PostMapping
	public String createCourse(@Valid @ModelAttribute("courseDto") CourseDTO courseDTO,
			BindingResult bindingResult,
			Model model,
			RedirectAttributes redirectAttributes) {
		
		Log.info("Post /course - create course request received.");
		
		
		if(bindingResult.hasErrors()) {
			Log.error("Post /course - page return dut to validation error.");
			return "add-course";
		}
		
		if(courseService.existsByCourseCode(courseDTO.getCourseCode())) {
			Log.error("Post /course - Code must be unique.");
			bindingResult.rejectValue("courseCode", null, "Code must be unique");
			return "add-course";
		}
		
		courseService.createCourse(courseDTO);
		redirectAttributes.addAttribute("message", "Course is created sucessfully!!");
		
		Log.info("Post /course - create course successfully created.");
		
		return "redirect:/course/list";
	}
	     @GetMapping("/{id}")
	     public String getCourseById(@PathVariable Long id, Model model) {
	    	 CourseDTO course = courseService.getCourseById(id);
	    	 model.addAttribute("course", course);
	    	 
	    	 return "view-course";
	    	 
	     }
	      
	     @GetMapping("/{id}/edit")
	     public String editCourse(@PathVariable Long id, Model model) {
	    	 CourseDTO course = courseService.getCourseById(id);
	    	 model.addAttribute("courseDto", course);
	    	 
	    	 return "edit-course";
	    	 
	     }
	     
	     @PostMapping("/{id}/update")
	     public String updateCourse(@PathVariable Long id,
	    		 @Valid @ModelAttribute("courseDto") CourseDTO courseDTO,
	 			 BindingResult bindingResult,
				 Model model,
				RedirectAttributes redirectAttributes) {
	    	 

	 		Log.info("Post /{id}/update - update course request received. {}", id);
	 		
	 		
	 		if(bindingResult.hasErrors()) {
	 			Log.error("Post /{id}/update - page return dut to validation error.");
	 			return "edit-course";
	 		}
	 		
	 		if(courseService.existsByCourseCodeAndIdNot(courseDTO.getCourseCode(), id)) {
	 			Log.error("Post /{id}/update - Code must be unique.");
	 			
	 			bindingResult.rejectValue("courseCode", null, "Code must be unique");
	 			return "edit-course";
	 		}
	 		
	 		courseService.updateCourse(id, courseDTO);
	 		redirectAttributes.addAttribute("message", "Course is updated sucessfully!!");
	 		
	 		Log.info("Post /{id}/update - updated course successfully created.");
	 		
	 		return "redirect:/course/list";
		
	    	 
	     }
}
	
	
	
	

