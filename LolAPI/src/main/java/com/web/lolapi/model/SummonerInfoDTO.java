package com.web.lolapi.model;

public class SummonerInfoDTO {
	private String accountId;
	private int profileIconid;
	private long revisionDate;
	private String name;
	private String id;
	private String puuid;
	private long summonerLevel;
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public int getProfileIconid() {
		return profileIconid;
	}
	public void setProfileIconid(int profileIconid) {
		this.profileIconid = profileIconid;
	}
	public long getRevisionDate() {
		return revisionDate;
	}
	public void setRevisionDate(long revisionDate) {
		this.revisionDate = revisionDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPuuid() {
		return puuid;
	}
	public void setPuuid(String puuid) {
		this.puuid = puuid;
	}
	public long getSummonerLevel() {
		return summonerLevel;
	}
	public void setSummonerLevel(long summonerLevel) {
		this.summonerLevel = summonerLevel;
	}
	
	
}
