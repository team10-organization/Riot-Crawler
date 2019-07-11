package Team10.RiotCrawler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RiotService {
    @Autowired
    RiotApiClient riotApiClient;

    @Autowired
    LeaguePositionRepository leaguePositionRepository;

    public LeaguePosition getLeaguePositionBySummonerName(String encryptedSummonerId) {
        return leaguePositionRepository.findLeaguePosition(encryptedSummonerId);
    }
}
