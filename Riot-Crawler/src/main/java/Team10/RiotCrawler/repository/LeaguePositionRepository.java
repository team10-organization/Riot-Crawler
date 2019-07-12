package Team10.RiotCrawler.repository;

import Team10.RiotCrawler.domain.LeaguePosition;
import com.mongodb.DB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.Set;

import java.util.Iterator;
import java.util.Set;


@Repository
public class LeaguePositionRepository
{
    @Autowired
    MongoTemplate mongoTemplate;

    public LeaguePosition findLeaguePosition(String encryptedId)
    {
        Query query = Query.query(Criteria.where("summonerId").is(encryptedId));

        return mongoTemplate.findOne(query, LeaguePosition.class);

    }

    public void insertLeaguePosition(Set<LeaguePosition> leaguePositionSet)
    {

        LeaguePosition leaguePosition = new LeaguePosition();
        Iterator<LeaguePosition> iter = leaguePositionSet.iterator();

        while(iter.hasNext()) {
            leaguePosition = iter.next();
        }
        if(findLeaguePosition(leaguePosition.getSummonerId()) != null)
            updateLeaguePosition(leaguePosition);
        else {
            mongoTemplate.insert(leaguePositionSet, LeaguePosition.class);
        }

    }

    public void updateLeaguePosition(LeaguePosition leaguePosition) {

        Query query = Query.query(Criteria.where("summonerId").is(leaguePosition.getSummonerId()));
        Update update = new Update();

        update.set("queueType", leaguePosition.getQueueType());
        update.set("summonerName", leaguePosition.getSummonerName());
        update.set("wins", leaguePosition.getWins());
        update.set("leaguePoints", leaguePosition.getLeaguePoints());
        update.set("losses", leaguePosition.getLosses());
        update.set("rank", leaguePosition.getRank());
        update.set("tier", leaguePosition.getTier());
        update.set("leagueId", leaguePosition.getLeagueId());
        update.set("summonerId", leaguePosition.getSummonerId());
        mongoTemplate.updateFirst(query, update, LeaguePosition.class);

     


    }

}
