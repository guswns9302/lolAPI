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
	
	String lolAPI_key = "RGAPI-f747da13-51ee-464d-a80f-bb0df57a592d";
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		LiotService service = new LiotService();
		ChampionInfoDTO lotation = service.lotation(lolAPI_key);
		ChampionInfoDTO champInfo = service.champInfo();
		
		String[] img_url_freelotation = new String[lotation.getFreeChampionIds().size()];
		String[] img_url_freeForNewUser = new String[lotation.getFreeChampionIdsForNewPlayers().size()];
		
		for(int i = 0; i <= lotation.getFreeChampionIds().size() - 1; i++) {
			img_url_freelotation[i] = "http://ddragon.leagueoflegends.com/cdn/12.1.1/img/champion/" + champInfo.getChamp_name_id().get(lotation.getFreeChampionIds().get(i)) + ".png";
		}
		model.addAttribute("freelotation_img",img_url_freelotation);
		
		for(int i = 0; i <= lotation.getFreeChampionIdsForNewPlayers().size() - 1; i++) {
			img_url_freeForNewUser[i] = "http://ddragon.leagueoflegends.com/cdn/12.1.1/img/champion/" + champInfo.getChamp_name_id().get(lotation.getFreeChampionIdsForNewPlayers().get(i)) + ".png";
		}
		model.addAttribute("freeForNewUser_img",img_url_freeForNewUser);
		
		return "home";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String serch(String summonerName, Model model) {
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
