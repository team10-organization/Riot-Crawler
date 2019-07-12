package Team10.RiotCrawler.api;

import Team10.RiotCrawler.domain.LeaguePosition;
import Team10.RiotCrawler.domain.SummonerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RiotApiClient {
    private final String api_key = "RGAPI-20c898f3-f039-473f-a8a0-ad9d4e5505ed";
    private final String OpenRiotUrl_getEncryptedId = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{summonerName}?api_key={api_key}";
    private final String OpenRiotUrl_getSummonerInfo = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/{encryptedId}?api_key={api_key}";

    @Autowired
    RestTemplate restTemplate;

    public SummonerInfo requestEncryptedId(String summonerName){
        return restTemplate.exchange(OpenRiotUrl_getEncryptedId, HttpMethod.GET, null, SummonerInfo.class, summonerName, api_key).getBody();
    }

    public LeaguePosition requestSummonerInfo(String encryptedId){
        return restTemplate.exchange(OpenRiotUrl_getSummonerInfo, HttpMethod.GET, null, LeaguePosition.class, encryptedId, api_key).getBody();
    }

}
