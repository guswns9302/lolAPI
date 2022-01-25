package com.web.lolapi.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChampionInfoDTO {
	private List<Integer> freeChampionIdsForNewPlayers;
	private List<Integer> freeChampionIds;
	
	private HashMap<Integer, String> champ_name_id;
	
	public List<Integer> getFreeChampionIdsForNewPlayers() {
		return freeChampionIdsForNewPlayers;
	}
	public void setFreeChampionIdsForNewPlayers(List<Integer> freeChampionIdsForNewPlayers) {
		this.freeChampionIdsForNewPlayers = freeChampionIdsForNewPlayers;
	}
	public List<Integer> getFreeChampionIds() {
		return freeChampionIds;
	}
	public void setFreeChampionIds(List<Integer> freeChampionIds) {
		this.freeChampionIds = freeChampionIds;
	}
	public HashMap<Integer, String> getChamp_name_id() {
		return champ_name_id;
	}
	public void setChamp_name_id(HashMap<Integer, String> champ_name_id) {
		this.champ_name_id = champ_name_id;
	}
}
