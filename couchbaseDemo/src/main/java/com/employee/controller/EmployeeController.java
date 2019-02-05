package com.employee.controller;

import java.util.UUID;

import javax.ws.rs.HeaderParam;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/g")
	public String get() {
		return "couchbase";
	}
	
	@RequestMapping(value="/gt/{id}",method=RequestMethod.GET,produces="application/json")
	public String test(@PathVariable String id) throws JSONException {
		JsonObject d = employeeService.getDoc(id);
		String str = d.toString();
		return str;
	}
	
	@RequestMapping(value="/post",method=RequestMethod.POST,consumes="application/json")
	public void add(@RequestBody String body) {
		String uuid = UUID.randomUUID().toString();
		JsonObject request = JsonObject.fromJson(body);
		JsonDocument doc = JsonDocument.create("employee_"+uuid,request);
		employeeService.insertDoc(doc);
	}
	
	@RequestMapping(value="/update/{uuid}",method=RequestMethod.PUT,consumes="application/json")
	public void update(@PathVariable String uuid,@RequestBody String body) throws JSONException {
		//JsonObject request = JsonObject.fromJson(body);
		JsonObject exist = employeeService.getDoc(uuid);
		exist = JsonObject.fromJson(body);
		JsonDocument document = JsonDocument.create("employee_"+uuid,exist);
		employeeService.updatedDoc(document);
	}
	
	@RequestMapping(value="/del/{uuid}",method=RequestMethod.DELETE)
	public void delete(@PathVariable String uuid) {
		employeeService.deleteDoc("employee_"+uuid);
	}
}
