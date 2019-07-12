package Team10.RiotCrawler.api;

import Team10.RiotCrawler.domain.LeaguePosition;
import Team10.RiotCrawler.domain.SummonerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Set;

@Service
public class RiotApiClient {
    private final String api_key = "RGAPI-45e2e1b7-023e-4c4d-a416-099ec58640b6";
    private final String OpenRiotUrl_getEncryptedId = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{summonerName}?api_key={api_key}";
    private final String OpenRiotUrl_getSummonerInfo = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/{encryptedSummonerId}?api_key={api_key}";


    @Autowired
    RestTemplate restTemplate;
    ParameterizedTypeReference<Set<LeaguePosition>> leagueposition = new ParameterizedTypeReference<Set<LeaguePosition>>() {};

    public SummonerInfo requestEncryptedId(String summonerName) {
        return restTemplate.exchange(OpenRiotUrl_getEncryptedId, HttpMethod.GET, null, SummonerInfo.class, summonerName, api_key).getBody();
    }

    public Set<LeaguePosition> requestSummonerInfo(String encryptedId) {
        return restTemplate.exchange(OpenRiotUrl_getSummonerInfo, HttpMethod.GET, null, leagueposition, encryptedId, api_key).getBody();
    }
}
