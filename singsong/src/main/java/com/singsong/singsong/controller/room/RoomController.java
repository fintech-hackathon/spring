package com.singsong.singsong.controller.room;

import java.io.UnsupportedEncodingException;

import com.singsong.singsong.service.room.RoomService;
import com.singsong.singsong.util.URLparser;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {
    @Autowired
    RoomService roomservice;

    URLparser parser = new URLparser();
    @PostMapping("/room/getList")
    public ResponseEntity<Object> getList(@RequestBody String json) throws UnsupportedEncodingException,ParseException{
        System.out.println("url : http://115.85.180.70:3001/room/getList");
        org.json.simple.JSONObject ob = parser.parseurl(json);
        String sr_o_id = ob.get("sr_o_id").toString();
        System.out.println("param : " +ob.toString());
        
        System.out.println("result : success");
        System.out.println("==============================");
        return new ResponseEntity<>(roomservice.getList(sr_o_id), HttpStatus.OK);
    }

    @PostMapping("/room/getListByUser")
    public ResponseEntity<Object> getListByUser(@RequestBody String json) throws UnsupportedEncodingException,ParseException{
        System.out.println("url : http://115.85.180.70:3001/user/join");
        
        org.json.simple.JSONObject ob = parser.parseurl(json);
        String sr_u_id = ob.get("sr_u_id").toString();
        System.out.println("param : " +ob.toString());
        
        System.out.println("result : success");
        System.out.println("==============================");
        return new ResponseEntity<>(roomservice.getListByUser(sr_u_id), HttpStatus.OK);
    }

    @PostMapping("/room/roomdelete")
    public ResponseEntity<Object> roomdelete(@RequestBody String json) throws UnsupportedEncodingException,ParseException{
        System.out.println("url : http://115.85.180.70:3001/room/roomdelete");


        org.json.simple.JSONObject ob = parser.parseurl(json);
        String sr_u_id = ob.get("sr_u_id").toString();
        System.out.println("param : " +ob.toString());

        int result = roomservice.roomdelete(sr_u_id);

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

    
}
