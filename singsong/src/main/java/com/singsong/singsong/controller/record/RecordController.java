package com.singsong.singsong.controller.record;

import java.io.UnsupportedEncodingException;


import com.singsong.singsong.service.record.RecordService;
import com.singsong.singsong.util.URLparser;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class RecordController {
    
    @Autowired
    RecordService recordservice;

    URLparser parser = new URLparser();

    @PostMapping("/record/getList")
    public ResponseEntity<Object> getRecordlist() throws UnsupportedEncodingException,ParseException{
        System.out.println("url : http://115.85.180.70:3001/record/getList");
        System.out.println("result : success");
        System.out.println("==============================");
        return new ResponseEntity<>(recordservice.getRecordList(), HttpStatus.OK);
    }

    @PostMapping("/record/uplikes")
    public ResponseEntity<Object> uplikes(@RequestBody String json) throws UnsupportedEncodingException,ParseException{
        System.out.println("url : http://115.85.180.70:3001/record/uplikes");


        
        org.json.simple.JSONObject ob = parser.parseurl(json);
        String url = ob.get("r_url").toString();
        int result = recordservice.upLikes(url);
        System.out.println("param : " +ob.toString());

        if(result > 0){
            System.out.println("result : success");
            System.out.println("==============================");
            return new ResponseEntity<>("success", HttpStatus.OK);    
        }
        else{
            System.out.println("result : fail");
            System.out.println("==============================");
            return new ResponseEntity<>("fail", HttpStatus.OK);    
        }

        
    }

    @PostMapping("/record/uphites")
    public ResponseEntity<Object> uphites(@RequestBody String json) throws UnsupportedEncodingException,ParseException{
        System.out.println("url : http://115.85.180.70:3001/record/uphites");



        org.json.simple.JSONObject ob = parser.parseurl(json);
        String url = ob.get("r_url").toString();
        int result = recordservice.upHites(url);
        System.out.println("param : " +ob.toString());

        if(result > 0){
            System.out.println("result : success");
            System.out.println("==============================");
            return new ResponseEntity<>("success", HttpStatus.OK);    
        }
        else{
            System.out.println("result : success");
            System.out.println("==============================");
            return new ResponseEntity<>("success", HttpStatus.OK);    
        }
    }



}
