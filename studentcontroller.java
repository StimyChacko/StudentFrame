package com.controller;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.io.IOException;
import java.io.InputStream;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.daoimpl.markdaoimpl;
import com.model.login;
import com.model.marks;
import com.model.stdaddress;
import com.model.studentinfo;
import com.model.subject;
import com.service.markservice;
import com.service.studentservice;
/**
 * controller class
 * function invoke matching url 
 * 
 * @author stimy
 *
 */
@Controller
public class studentcontroller {

 
	@Autowired
	private studentservice studentservice;
	
	@Autowired
	private JavaMailSender mailSender;
	
	/**
	 * for every url
	 * which invoke when program run
	 * @param model login 
	 * @return login details
	 */
	 
	@RequestMapping ( value = "/", method = RequestMethod.GET )
	public String loginsc ( Model model ) {
		login log=new login();
		model.addAttribute("logindetails", log);
		return "login";
	}
	
	/**
	 * administrator login checking
	 * get matching username and password from login table
	 * @param login
	 * @return home page or error login page
	 */
	
	
	@RequestMapping ( value = "/login/adminlog", method = RequestMethod.POST )
	public String loginchk ( @ModelAttribute("logindetails") login login ) {
		List logindetails= studentservice.logchk(login.getUsername(),login.getPassword());
		boolean liststudent=false;
		if((logindetails!=null) && (logindetails.size()>0))
		{
			liststudent=true;
		}
		if (liststudent)
			return "home";
		else
			return "errorlogin";
	}
	
	/**
	 * function invoke before adding values
	 * retrieve subjects from subject table
	 * @param model student, subject
	 * @return new student adding page
	 */
	
	
	  @RequestMapping(value = "/stud/addstudent", method = RequestMethod.GET)
	  public String newstudent ( Model model ) {
			
			studentinfo stdinf = new studentinfo();
			
			List <subject> subjects = studentservice.getsubj();
			int id=0;
			String name= null;
			Map<Integer, String> SubjectMap = new HashMap<Integer,String>();
			for (subject subject:subjects)
			{
				id=subject.getSubId();
				name=subject.getSubjname();
				SubjectMap.put(id, name);
			}
			model.addAttribute("subjectlist", SubjectMap);
			model.addAttribute("studentdetails", stdinf);
			
			return "addstudent";
		}
		
	  /**
	   * function invoke after trying to add a new student
	   * @param studinf student details
	   * @return home page
	   */
	  
	@RequestMapping(value = "/stud/addedstudent", method = RequestMethod.POST)
	public String studentadded ( @ModelAttribute("studentdetails") studentinfo studinf ) {
		studentservice.addstudent(studinf);
		return "home";
	}
	
	/**
	 * function invoke before new admin registration
	 * @param model admin details
	 * @return admin registration page
	 */
	 @RequestMapping(value = "/login/adminreg", method = RequestMethod.GET)
	  public String newadmin ( Model model ) {
			
			login log = new login();
			model.addAttribute("admindetails", log);
			return "adminreg";
			
	 }
	
	/**
	 * function invoke when adding new admin
	 * @param log admin details
	 * @return home page
	 */
	@RequestMapping(value = "/log/addadmin", method = RequestMethod.POST)
	public String adminadded ( @ModelAttribute("admindetails") login log, Model model) {
		String email = studentservice.adminadded(log);
		model.addAttribute("Email", email);
		return "Mail";
	}
	
	/**
	 * function invoke before listing student details
	 * @param model student details
	 * @return liststudent page
	 */
	@RequestMapping ( value = "/stud/liststudent", method = RequestMethod.GET )
	public String liststudent ( Model model ) {
		model.addAttribute("studentdetails", studentservice.liststudent());
		return "ViewStudent";
	}
	
	/**
	 * functon invoke before trying to view more details of student
	 * retrieve matching studentid details from studentinfo table, stdaddress table and mark table
	 * @param studId student details along with address details
	 * @param model mark details
	 * @return viewmore page
	 */
	@RequestMapping ( value = "/stud/viewmore/{studid}", method = RequestMethod.GET )
	public String studmore (  @PathVariable("studid") int studId, Model model ) {
		studentinfo stdinf = studentservice.findstudentById(studId);
		@SuppressWarnings("unused")
		String res;
		res="Failed";
		marks mark=studentservice.markrow(studId);
		model.addAttribute("markdet", mark);
		model.addAttribute("studdetail", stdinf);
		Result result = JUnitCore.runClasses(markdaoimpl.class);
		for ( Failure failure : result.getFailures() ) {
			System.out.println(failure.toString());
		}
		System.out.println(result.wasSuccessful());
		float percentage=studentservice.markper(studId);
		if(percentage>50)
			res="Passed";
		model.addAttribute("result", res);
		
		return "viewmore";
	}
	
	/**
	 * function invoke before update student details
	 * retrieve matching student using id
	 * @param studId student details
	 * @param model
	 * @return updatestudent page
	 */
	@RequestMapping ( value = "/stud/updatestudent/{studid}", method = RequestMethod.GET )
	public String updatestudent ( @PathVariable("studid") int studId, Model model ) {
		studentinfo stdinf = studentservice.findstudentById(studId);
		model.addAttribute("studentdetail", stdinf);
		return "updatestudent";
	}
	/**
	 * function invoke before update mark
	 * @param studId for finding mark details of particular student
	 * @param model markd etails
	 * @return upadatemarks page
	 */
	@RequestMapping ( value = "/stud/updatemark/{studid}", method = RequestMethod.GET )
	public String updatemark ( @PathVariable("studid") int studId, Model model ) {
		marks mark=studentservice.markrow(studId);
		model.addAttribute("markdet", mark);
		return "updatemarks";
	}
	
	/**
	 * function invoke before adding marks
	 * check if there marks present or not
	 * @param studId for storing as foreign key
	 * @param model mark details
	 * @return addmark page or erraddm page
	 */
	@RequestMapping ( value = "/stud/addmark/{studid}", method = RequestMethod.GET )
	public String addmark ( @PathVariable("studid") int studId, Model model ) {
		marks markdet = new marks();
		marks mark=studentservice.markrow(studId);
		boolean markr=false;
		if(mark!=null) 
		{
			markr=true;
		}
		if (markr)
		return "erraddm";
		else
		{
			model.addAttribute("msid", studId);
			model.addAttribute("markdetail", markdet);
			return "addmarks";
			}
	
	}
	
	/**
	 * function invoke when adding marks 
	 * @param mark details
	 * @return liststudent page
	 */
	@RequestMapping(value = "/stud/addedmark", method = RequestMethod.POST)
	public String markadded ( @ModelAttribute("markdetail") marks mark ) {
		studentservice.addmark(mark);
		return "redirect:/stud/liststudent";
	}
	
	/**
	 * function invoke after update student information
	 * @param studentinfo
	 * @param result student details for checking errors
	 * @return update student or liststudent page
	 */
	@RequestMapping ( value = "/stud/studentupdated", method = RequestMethod.POST )
	public String studentUpdated ( @Valid @ModelAttribute("studentdetail") studentinfo studentinfo, BindingResult result ) {
		
		if ( result.hasErrors() ) {
			return "updatestudent";
		}
		
		studentservice.updatestudent(studentinfo);
		return "redirect:/stud/liststudent";
	}
	/**
	 * 
	 * @param studentinfo
	 * @param result
	 * @return
	 */
	@RequestMapping ( value = "/stud/updatedmark", method = RequestMethod.POST )
	public String markUpdated ( @Valid @ModelAttribute("markdetail") marks mark, BindingResult result ) {
		
		if ( result.hasErrors() ) {
			return "updatemarks";
		}
		
		studentservice.updatemark(mark);
		return "redirect:/stud/liststudent";
	}
	/**
	 * Function invoke when trying to delete a student detail
	 * @param studId id of student to be deleted
	 * @return liststudent page
	 */
	@RequestMapping ( value = "/stud/deletestudent/{studid}", method = RequestMethod.GET )
	public String deletestudent ( @PathVariable("studid") int studId) {
		studentservice.deletestudent(studId);
		studentservice.deletemark(studId);
		return "redirect:/stud/liststudent";
	}
	/**
	 * 
	 * @param request
	 * @param attachFile
	 * @return
	 */
	
	@RequestMapping( value = "/sendmail", method = RequestMethod.POST)
    public String sendEmail(HttpServletRequest request,
            final @RequestParam CommonsMultipartFile attachFile) {
 
        final String emailTo = request.getParameter("mailTo");
        final String subject = request.getParameter("subject");
        final String message = request.getParameter("message");
 
        System.out.println("emailTo: " + emailTo);
        System.out.println("subject: " + subject);
        System.out.println("message: " + message);
        System.out.println("attachFile: " + attachFile.getOriginalFilename());
 
        mailSender.send(new MimeMessagePreparator() {
 
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                messageHelper.setTo(emailTo);
                messageHelper.setSubject(subject);
                messageHelper.setText(message);
                 
                String attachName = attachFile.getOriginalFilename();
                if (!attachFile.equals("")) {
 
                    messageHelper.addAttachment(attachName, new InputStreamSource() {
                         
                        @Override
                        public InputStream getInputStream() throws IOException {
                            return attachFile.getInputStream();
                        }
                    });
                }
                 
            }
 
        });
 
        return "emailsuccess";
    }
}
