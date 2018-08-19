package com.app.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.app.models.IplResponce;
import com.app.models.Player;
import com.app.models.Team;
import com.google.gson.Gson;

@Controller
public class RegisterTeam {
	
	@RequestMapping(value="/regTem",method=RequestMethod.POST)
	public String register(Team team,Model model) {
		System.out.println("Entering to Register");
		
		Gson gson=new Gson();
		
		RestTemplate restTemplate=new RestTemplate();
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		String json = gson.toJson(team);
		
	
		HttpEntity entity = new HttpEntity(json, headers);
	
		String url="http://localhost:8080/DemoRest/iplscore/reg";
		
		ResponseEntity<String> responseEntity=restTemplate.exchange(url, HttpMethod.POST, entity,String.class);
		
		String body = responseEntity.getBody();
		System.out.println(body);
		
		
		Team fromJson = gson.fromJson(body,Team.class);
		System.out.println("status="+fromJson.getStatus());
		model.addAttribute("status","Congratulation Your Eligible ");
		
		return "addplayer";
	}
	
	}

