package project.gym_management.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import project.gym_management.dto.Credentials;
import project.gym_management.dto.ImageDto;
import project.gym_management.dto.Response;
import project.gym_management.entities.TableUser;
import project.gym_management.services.TableUserService;

@CrossOrigin
@RestController
public class LoginController {
	@Autowired
	TableUserService user;
	
	@RequestMapping("/signin")
	public ResponseEntity<?> login(@RequestBody Credentials cred){
		Credentials usercred=new Credentials();
		TableUser tu=user.authenticateUser(cred);
		BeanUtils.copyProperties(tu, usercred);
		if(tu != null)
		return Response.success(usercred);
		else 
		return Response.error("error");
	}
	
	@RequestMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody Credentials cred){
		String message = user.saveUser(cred);
		return Response.success(message);	
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/update")
	public ResponseEntity<Map> update(@RequestBody Credentials cred){
		Map<String, Object> map = new HashMap<>();
		String message=user.updateUser(cred);
		map.put("status", message);
		map.put("data", user.getById(cred.getUser_id()));
		return ResponseEntity.ok(map);	
	}
	
	@PostMapping("/addUserImage")
	public ResponseEntity<?> addUserImage(@RequestParam MultipartFile thumbnail,@RequestParam String id) throws IllegalStateException, IOException {
		ImageDto imageDto=new ImageDto(Integer.parseInt(id),thumbnail);
		user.addUserImage(imageDto);
		return Response.success("success");
	}
}
