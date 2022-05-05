package com.cakemgr.CakeManager.controller;

import java.util.List;

import com.cakemgr.CakeManager.model.CakeEntity;
import com.cakemgr.CakeManager.service.CakeMgrService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;



@RestController
public class CakeManagerController {
	private static final String REQUEST_NO_BODY = "Request does not contain a body";

	@Autowired
	CakeMgrService cakeMgrService;
	// Get all cake details
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<CakeEntity> findCake() {
		return cakeMgrService.findAllCake();
	}
	//Cake detail Download Txt Format
	@RequestMapping(value = "/cake", method = RequestMethod.GET)
	public ResponseEntity<byte[]> download() throws Exception {
		List<CakeEntity> messageRecord = cakeMgrService.findAllCake();
		ObjectMapper objectMapper = new ObjectMapper();
		String xml = objectMapper.writeValueAsString(messageRecord);
		byte[] stringtobytes= xml.getBytes();
		String fileName = "cake-mgr.txt";
		HttpHeaders respHeaders = new HttpHeaders();
		respHeaders.setContentLength(stringtobytes.length);
		respHeaders.setContentType(MediaType.TEXT_PLAIN);
		respHeaders.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		respHeaders.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
		return new ResponseEntity<byte[]>(stringtobytes, respHeaders, HttpStatus.OK);
	}
	//get Cake details by id
	@RequestMapping(value = "/cake/{id}", method = RequestMethod.GET)
	public CakeEntity getCakeEntity(@PathVariable long id) {
		return cakeMgrService.findById(id);
	}
	//Save Cake details
	@RequestMapping(value = "/cake", method = RequestMethod.POST)
	public CakeEntity addCakeEntity(@RequestBody CakeEntity cake) {
		if (cake != null) {
			cakeMgrService.insert(cake);
			return cake;
		} else {
			return cake;
		}
	}

}
