package com.singsong.singsong.controller.owner;

import java.io.UnsupportedEncodingException;


import com.singsong.singsong.dto.Owner.Owner;
import com.singsong.singsong.service.owner.ownerService;
import com.singsong.singsong.util.URLparser;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OwnerController {
    
    @Autowired
    ownerService ownerservice;

    URLparser parser = new URLparser();
    
    @PostMapping("/owner/allowner")
    public ResponseEntity<Object> allowner() throws UnsupportedEncodingException,ParseException{
		System.out.println("url : http://115.85.180.70:3001/owner/allowner");
		System.out.println("result : success");
		System.out.println("==============================");
        return new ResponseEntity<>(ownerservice.allOwner(), HttpStatus.OK);
    }

    @PostMapping("/owner/getOwner")
	public ResponseEntity<Object> getOwner(@RequestBody String json) throws UnsupportedEncodingException,ParseException {
		System.out.println("url : http://115.85.180.70:3001/owner/getOwner");


		
		org.json.simple.JSONObject ob = parser.parseurl(json);
		String id = ob.get("o_id").toString();
		System.out.println("param : " +ob.toString());
		
		Owner owner = ownerservice.getOwner(id);
		if(owner != null){
			System.out.println("result : success");
			System.out.println("==============================");
			return new ResponseEntity<>(owner, HttpStatus.OK);
		}
		else{
			System.out.println("result : fail");
			System.out.println("==============================");
			return new ResponseEntity<>("fail", HttpStatus.OK);
		}
	}

}
