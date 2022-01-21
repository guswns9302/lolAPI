package com.web.lolapi;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.lolapi.model.ChampionInfoDTO;
import com.web.lolapi.model.LeagueEntryDTO;
import com.web.lolapi.model.LiotService;
import com.web.lolapi.model.SummonerDTO;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	String lolAPI_key = "RGAPI-3844467d-ea86-47df-a815-3b9fea18083f";
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		LiotService service = new LiotService();
		ChampionInfoDTO lotation = service.lotation(lolAPI_key);
		
		// lotation.getFreeChampionIds(); 			   // 로테이션
		// lotation.getFreeChampionIdsForNewPlayers(); // 무료
		service.champInfo();
		model.addAttribute("lotation",lotation);
		
		model.addAttribute("lotation_img","http://ddragon.leagueoflegends.com/cdn/12.1.1/img/champion/Aatrox.png");
		return "home";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String serch(String summonerName, Model model) {
		//String lolAPI_key = "RGAPI-49abd081-efb8-49b3-a711-635eaf778187";
		
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
