package org.springframework.samples.petclinic.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.service.MyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
private MyService myService;
@Autowired
public void setMyService(MyService myService) {
	this.myService = myService;
}

@RequestMapping(value = "/appointment/new", method = RequestMethod.GET)
public String appointmentCreationForm(Map<String, Object> model) {
	System.out.println("reached controller");
    model.put("owners",myService.getOwnerIdFirstName() );
    return "appointment1/appointment1";
}
@RequestMapping(value="/appointment/owner", method =RequestMethod.GET,produces="application/json")
public @ResponseBody Map<String, String> getPetData(@RequestParam("owner") String owner) {
	System.out.println("reached petdata controller");
	System.out.println(owner);
	int id=Integer.parseInt(owner);
     return myService.getPetIdFirstName(id);	
}
@RequestMapping(value="/appointment/vet", method =RequestMethod.GET,produces="application/json")
public @ResponseBody Map<String, String> getVetData() {
	System.out.println("reached Vetdata controller");
     return myService.getVetIdFirstName();
}
}
