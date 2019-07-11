package Team10.RiotCrawler.service;

import Team10.RiotCrawler.api.RiotApiClient;
import Team10.RiotCrawler.domain.LeaguePosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RiotService {
    @Autowired
    RiotApiClient riotApiClient;

    @Autowired
    LeaguePositionRepository leaguePositionRepository;

    public String getEncryptedSummonerId(String summonerName) {
        return riotApiClient.requestEncryptedId(summonerName).getId();
    }

    public LeaguePosition getLeaguePositionBySummonerName(String encryptedSummonerId) {
        return leaguePositionRepository.findLeaguePosition(encryptedSummonerId);
    }
}
