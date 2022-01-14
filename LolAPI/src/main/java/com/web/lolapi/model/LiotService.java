package com.web.lolapi.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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
		
		try {
			url = new URL(lotationChampURL);
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			
			buffer = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			String data = buffer.readLine();
			JSONParser jsonParser = new JSONParser();
			JSONObject lotationChampList = (JSONObject) jsonParser.parse(data);
			
			freeChamp.setFreeChampionIds((List<Integer>) lotationChampList.get("freeChampionIds"));
			freeChamp.setFreeChampionIdsForNewPlayers((List<Integer>) lotationChampList.get("freeChampionIdsForNewPlayers"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return freeChamp;
	}
	
//	public ChampionInfoDTO champInfo() {
//		String champURL = "http://ddragon.leagueoflegends.com/cdn/12.1.1/data/en_US/champion.json";
//		BufferedReader buffer = null;
//		URL url = null;
//		ChampionInfoDTO champInfo = new ChampionInfoDTO();
//		
//		try {
//			url = new URL(champURL);
//			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//			urlConnection.setRequestMethod("GET");
//			
//			buffer = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
//			String data = buffer.readLine();
//			System.out.println(data);
//			JSONParser jsonParser = new JSONParser();
//			JSONObject jsonbObject = (JSONObject) jsonParser.parse(data);
//			
//			JSONObject champdata = (JSONObject) jsonbObject.get("data");
//			JSONArray jsonArray = (JSONArray) champdata;
//			//System.out.println(jsonArray);
//			//JSONObject champData = (JSONObject) jsonArray.get(0);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return champInfo;
//	}
}
