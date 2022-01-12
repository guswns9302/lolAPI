package com.web.lolapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.util.*;
import java.util.Locale;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String serch(String summonerName, Model model) {
		String lolAPI_key = "RGAPI-60792256-0524-4f24-bfdf-6d84f92ba01d";
		BufferedReader buffer = null;
		
		String summonerURL = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + summonerName + "?api_key=" +lolAPI_key;
		
		URL url;
		try {
			url = new URL(summonerURL);
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			
			buffer = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			String data = buffer.readLine();
			
			JSONParser jsonParser = new JSONParser();
			JSONObject summonerData = (JSONObject) jsonParser.parse(data);
			System.out.println(summonerData.get("id"));
			System.out.println(summonerData.get("accountId"));
			System.out.println(summonerData.get("puuid"));
			System.out.println(summonerData.get("name"));
			System.out.println(summonerData.get("profileIconId"));
			System.out.println(summonerData.get("revisionDate"));
			System.out.println(summonerData.get("summonerLevel"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "search";
	}
	
}
