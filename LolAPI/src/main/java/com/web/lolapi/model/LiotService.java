package com.web.lolapi.model;

import java.awt.RenderingHints.Key;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class LiotService {
	
	public SummonerDTO searchSummoner(String lolAPI_key, String summonerName) {
		
		String summonerURL = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + summonerName + "?api_key=" +lolAPI_key;
		
		BufferedReader buffer = null;
		URL url = null;
		SummonerDTO summoner = new SummonerDTO();
		
		try {
			url = new URL(summonerURL);
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			
			buffer = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			String data = buffer.readLine();
			
			JSONParser jsonParser = new JSONParser();
			JSONObject summonerData = (JSONObject) jsonParser.parse(data);
			
			summoner.setId(summonerData.get("id").toString());
			summoner.setAccountId(summonerData.get("accountId").toString());
			summoner.setPuuid(summonerData.get("puuid").toString());
			summoner.setName(summonerData.get("name").toString());
			summoner.setProfileIconid(Integer.parseInt(summonerData.get("profileIconId").toString()));
			summoner.setRevisionDate(Long.parseLong(summonerData.get("revisionDate").toString()));
			summoner.setSummonerLevel(Integer.parseInt(summonerData.get("summonerLevel").toString()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return summoner;
	}
	
	public LeagueEntryDTO searchLeague(String lolAPI_key, String summonerId) {
		
		String leagueEntryURL = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/" + summonerId + "?api_key=" +lolAPI_key;
		BufferedReader buffer = null;
		URL url = null;
		LeagueEntryDTO league = new LeagueEntryDTO();
		
		try {
			url = new URL(leagueEntryURL);
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			
			buffer = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			String data = buffer.readLine();
			JSONParser jsonParser = new JSONParser();
			JSONArray jsonArray = (JSONArray) jsonParser.parse(data);
			JSONObject leagueData = (JSONObject) jsonArray.get(0);
			
			league.setLeagueId(leagueData.get("leagueId").toString());
			league.setQueueType(leagueData.get("queueType").toString());
			league.setTier(leagueData.get("tier").toString());
			league.setRank(leagueData.get("rank").toString());
			league.setLeaguePoints(Integer.parseInt(leagueData.get("leaguePoints").toString()));
			league.setWins(Integer.parseInt(leagueData.get("wins").toString()));
			league.setLosses(Integer.parseInt(leagueData.get("losses").toString()));
			
			double total = league.getWins() + league.getLosses();
			league.setWinRate((int)Math.round(league.getWins() / total * 100));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return league;
	}
	
	public ChampionInfoDTO lotation(String lolAPI_key) {
		
		String lotationChampURL = "https://kr.api.riotgames.com/lol/platform/v3/champion-rotations/" + "?api_key=" + lolAPI_key;
		BufferedReader buffer = null;
		URL url = null;
		ChampionInfoDTO freeChamp = new ChampionInfoDTO();
		List<Integer> lotationChampList_id = new ArrayList<Integer>();
		List<Integer> lotationChampList_id_for_New = new ArrayList<Integer>();
		try {
			url = new URL(lotationChampURL);
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			
			buffer = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			String data = buffer.readLine();
			JSONParser jsonParser = new JSONParser();
			JSONObject lotationChampList = (JSONObject) jsonParser.parse(data);
			JSONArray freeChampionIds = (JSONArray) lotationChampList.get("freeChampionIds");
			JSONArray freeChampionIdsForNewPlayers = (JSONArray) lotationChampList.get("freeChampionIdsForNewPlayers");
			
			for(int i = 0; i < freeChampionIds.size() -1; i++) {
				lotationChampList_id.add(Integer.parseInt(freeChampionIds.get(i).toString()));
			}
			for(int i = 0; i < freeChampionIdsForNewPlayers.size() -1; i++) {
				lotationChampList_id_for_New.add(Integer.parseInt(freeChampionIdsForNewPlayers.get(i).toString()));
			}
			
			freeChamp.setFreeChampionIds(lotationChampList_id);
			freeChamp.setFreeChampionIdsForNewPlayers(lotationChampList_id_for_New);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return freeChamp;
	}
	
	public ChampionInfoDTO champInfo() {
		String champURL = "http://ddragon.leagueoflegends.com/cdn/12.1.1/data/en_US/champion.json";
		BufferedReader buffer = null;
		URL url = null;
		ChampionInfoDTO champInfo = new ChampionInfoDTO();
		HashMap<Integer , String> champ_name_id = new HashMap<Integer, String>();
		
		try {
			url = new URL(champURL);
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			
			buffer = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			String data = buffer.readLine();
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonbObject = (JSONObject) jsonParser.parse(data);
			JSONObject parse_data = (JSONObject) jsonbObject.get("data");
			
			Iterator<String> iterator = parse_data.keySet().iterator();
			while(iterator.hasNext()) {
				String key = (String) iterator.next();
				if(parse_data.get(key) instanceof JSONObject) {
					JSONObject parse_data_champ_id = (JSONObject) parse_data.get(key);
					champ_name_id.put(Integer.parseInt(parse_data_champ_id.get("key").toString()), key);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		champInfo.setChamp_name_id(champ_name_id);
		
		return champInfo;
	}
}
