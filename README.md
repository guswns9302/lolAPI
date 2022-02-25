# LOL.GG
> Liot에서 제공하는 API를 활용한 League of Legends 전적 검색 사이트

## 개발 목표
Spring에서 API를 활용할 수 있다.  
json data를 파싱하여 원하는 정보를 얻을 수 있다.


## 상세 기능
### 1. 검색창
![1](https://user-images.githubusercontent.com/87797716/155636155-ebbc5ee6-c942-48dc-861a-2d3acfb09624.png)
> LOL 소환사 아이디로 검색  
금주의 로테이션 챔피언과, 신규 유저 무료 챔피언 정보 표시

Liot API CHAMPION-V3 - 로테이션 정보를 가져오기 위해 사용  
REQUEST URL - https://kr.api.riotgames.com/lol/platform/v3/champion-rotations
![1-1](https://user-images.githubusercontent.com/87797716/155636208-33284aaa-884d-4b38-b43e-91f7aeea532f.png)

챔피언 이미지를 가져오기 위해 Riot DataDragon에서 json 데이터를 가져옴  
![1-2](https://user-images.githubusercontent.com/87797716/155636221-8aed3785-bae9-4a23-961d-067570f6238e.png)


### 2. 검색결과
![2](https://user-images.githubusercontent.com/87797716/155636182-87e40198-6de7-4cc4-9222-d4187699bbdc.png)
> 검색된 소환사 정보 표시

Liot API SUMMONER-V4 - 소환사 정보를 가져오기 위해 사용  
REQUEST URL - https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/
![2-1](https://user-images.githubusercontent.com/87797716/155636259-d8ce7b4d-cf2f-4c7a-bb39-706962456c16.png)

Liot API SUMMONER-V4 - 소환사 정보를 바탕으로 리그 정보를 가져오기 위해 사용  
REQUEST URL - https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/
![2-2](https://user-images.githubusercontent.com/87797716/155636269-1d9456c8-d5bf-43d3-9731-02c84117ca68.png)

## Environment
Windows10, Tomcat, GitHub
Spring MVC, Java, Liot API
