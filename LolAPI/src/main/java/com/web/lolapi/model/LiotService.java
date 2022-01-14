package com.web.lolapi.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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
	
	
}
