package com.web.lolapi.model;

import java.util.List;

public class ChampionInfoDTO {
	private List<Integer> freeChampionIdsForNewPlayers;
	private List<Integer> freeChampionIds;
	private int champNum;
	private String champName;
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
	public int getChampNum() {
		return champNum;
	}
	public void setChampNum(int champNum) {
		this.champNum = champNum;
	}
	public String getChampName() {
		return champName;
	}
	public void setChampName(String champName) {
		this.champName = champName;
	}
	
}
