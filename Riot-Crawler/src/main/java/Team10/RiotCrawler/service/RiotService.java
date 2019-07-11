package Team10.RiotCrawler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RiotService {
    @Autowired
    RiotApiClient riotApiClient;

    @Autowired
    LeaguePositionRepository leaguePositionRepository;

    public String getEncryptedSummonerId(String summonerName) {
        return SummonerInfo.getEncryptedId();
    }

    public LeaguePosition getLeaguePositionBySummonerName(String encryptedSummonerId) {
        return leaguePositionRepository.findLeaguePosition(encryptedSummonerId);
    }
}
