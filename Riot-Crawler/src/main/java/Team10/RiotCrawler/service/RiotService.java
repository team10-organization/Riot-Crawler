package Team10.RiotCrawler.service;

import Team10.RiotCrawler.api.RiotApiClient;
import Team10.RiotCrawler.domain.LeaguePosition;
import Team10.RiotCrawler.domain.SummonerInfo;
import Team10.RiotCrawler.repository.LeaguePositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RiotService {
    @Autowired
    RiotApiClient riotApiClient;

    @Autowired
    LeaguePositionRepository leaguePositionRepository;

    public String getEncryptedSummonerId(String summonerName) {
        return riotApiClient.requestEncryptedId(summonerName).getId();
    }

    public Set<LeaguePosition> getLeaguePositionBySummonerName(String summonerName) {
        String encryptedSummonerId = getEncryptedSummonerId(summonerName);




        Set<LeaguePosition> leaguePositions = riotApiClient.requestSummonerInfo(encryptedSummonerId);
        leaguePositionRepository.insertLeaguePosition(leaguePositions);
        return leaguePositions;




        Set<LeaguePosition> leaguePositionSet = riotApiClient.requestSummonerInfo(encryptedSummonerId);
        leaguePositionRepository.insertLeaguePosition(leaguePositionSet);
        return leaguePositionSet;


    }
}
