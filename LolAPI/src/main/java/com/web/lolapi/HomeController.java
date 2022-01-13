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

import com.web.lolapi.model.LeagueEntryDTO;
import com.web.lolapi.model.LiotService;
import com.web.lolapi.model.SummonerDTO;

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
		
		String lolAPI_key = "RGAPI-952fa711-55ec-43a8-93d9-975f22978016";
		
		LiotService service = new LiotService();
		SummonerDTO summoner = service.searchSummoner(lolAPI_key, summonerName);
		LeagueEntryDTO league = service.searchLeague(lolAPI_key, summoner.getId());

		model.addAttribute("summoner",summoner);
		model.addAttribute("profile_icon","http://ddragon.leagueoflegends.com/cdn/12.1.1/img/profileicon/" + summoner.getProfileIconid() + ".png");
		model.addAttribute("league",league);
		model.addAttribute("rank_icon","resources/base-icons/" + league.getTier() + ".png");
		return "search";
	}
	
}
