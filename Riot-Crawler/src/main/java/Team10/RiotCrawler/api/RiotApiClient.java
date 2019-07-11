package Team10.RiotCrawler.api;

import org.springframework.stereotype.Service;

@Service
public class RiotApiClient {
    private final String api_key = "RGAPI-ec5a5a65-88c8-4b60-90b7-6f41aedc7280";
    private final String OpenRiotUrl_getEncryptedId = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{summonerName}?api_key={api_key}";
    private final String OpenRiotUrl_getSummonerInfo = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/{encryptedId}?api_key={api_key}";
    
}
