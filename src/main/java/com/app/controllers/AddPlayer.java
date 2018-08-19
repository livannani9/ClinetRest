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
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.app.models.IplResponce;
import com.app.models.Player;
import com.google.gson.Gson;

@Controller
public class AddPlayer {

	@RequestMapping(value = "/addplayer", method = RequestMethod.POST)
	private String addPlayer(Player player, Model model) {

		String url = "http://localhost:8080/DemoRest/iplscore/saveplayer";
		Gson gson = new Gson();
		RestTemplate template = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String jsonPlayer = gson.toJson(player);
		HttpEntity entity = new HttpEntity(jsonPlayer, headers);
		
		String body="";
		try {
			ResponseEntity<String> AddPlayerResponse = template.exchange(url, HttpMethod.POST, entity, String.class);
			System.out.println("Success code is: " + AddPlayerResponse.getStatusCodeValue());
			body = AddPlayerResponse.getBody();
			System.out.println("Body=" + body);
			
		} catch (HttpStatusCodeException e) {

			System.out.println("status code is : " + e.getRawStatusCode());
			body = e.getResponseBodyAsString();
			System.out.println("failed!! The response is : " + body);
		}

		IplResponce iplResponceJson = gson.fromJson(body, IplResponce.class);

		
		
		if (iplResponceJson.getErrorCode().equals("000")) {
			System.out.println("Player Register SuccessFully");
	
			model.addAttribute("msg", "Congratulation Player Register...");
			return "addplayer";
		} else if (iplResponceJson.getErrorCode().equals("121")) {
			System.out.println("Name is Empty");

			model.addAttribute("msg", "Name Should Not Be Empty");
			return "addplayer";
		} else if (iplResponceJson.getErrorCode().equals("122")) {
			System.out.println("Mobile Number in valid");

			model.addAttribute("msg", "Mobile Number Is NoT Empty..");
			return "addplayer";
		} else if (iplResponceJson.getErrorCode().equals("123")) {
			System.out.println("Email is Not valid");

			model.addAttribute("msg", "Email  is Should Not Be Empty");
			return "addplayer";

		} else if (iplResponceJson.getErrorCode().equals("124")) {
			System.out.println("Team is Not Valid");

			model.addAttribute("msg", "Team Field Should Not Be Empty");
			return "addplayer";
		}

		return "addplayer";
	}

	public static void main(String[] args) {
		Player player = new Player();
		player.setEmail("Logan@gmail.com");
		player.setName("logan");
		player.setTeam("India");
		player.setMobile("8008961423");

		Gson gson = new Gson();
		String url = "http://localhost:8080/DemoRest/iplscore/saveplayer";

		RestTemplate template = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String playerJson = gson.toJson(player);

		HttpEntity entity = new HttpEntity(playerJson, headers);

		String body="";
		try {
			ResponseEntity<String> AddPlayerResponse = template.exchange(url, HttpMethod.POST, entity, String.class);
			System.out.println("Success code is: " + AddPlayerResponse.getStatusCodeValue());
			body = AddPlayerResponse.getBody();
			System.out.println("Body=" + body);
			
		} catch (HttpStatusCodeException e) {

			System.out.println("status code is : " + e.getRawStatusCode());
			body = e.getResponseBodyAsString();
			System.out.println("failed!! The response is : " + body);
		}

		IplResponce iplResponce = gson.fromJson(body, IplResponce.class);

		if (iplResponce.getErrorCode().equals("120")) {
			System.out.println("Player Register SuccessFully");
		} else if (iplResponce.getErrorCode().equals("121")) {
			System.out.println("Name is Empty");
		} else if (iplResponce.getErrorCode().equals("122")) {
			System.out.println("Mobile Number in valid");

		} else if (iplResponce.getErrorCode().equals("123")) {
			System.out.println("Email is Not valid");

		} else if (iplResponce.getErrorCode().equals("124")) {
			System.out.println("Team is Not Valid");

		}

	}

}
