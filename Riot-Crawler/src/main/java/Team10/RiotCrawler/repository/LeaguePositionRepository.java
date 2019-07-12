package Team10.RiotCrawler.repository;

import Team10.RiotCrawler.domain.LeaguePosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public class LeaguePositionRepository
{
    @Autowired
    MongoTemplate mongoTemplate;

    public LeaguePosition findLeaguePosition(String summonerId)
    {
        Query query = Query.query(Criteria.where("summonerId").is(summonerId));
        return mongoTemplate.findOne(query, LeaguePosition.class);
    }

    public void insertLeaguePosition(Set<LeaguePosition> leaguePositionSet)
    {
        /*
        if(findLeaguePosition(leaguePosition.getSummonerId()) != null)
        {
            /*Query query = Query.query(Criteria.where("summonerId").is(leaguePosition.getSummonerId()));

            mongoTemplate.update();
            LeaguePosition temp = new LeaguePosition();
            temp = mongoTemplate.findOne(Query.query(Criteria.where("summonerId").is(leaguePosition.getSummonerId())), LeaguePosition.class);
            temp = leaguePosition;
            mongoTemplate.save(temp);

        }
        else
        {
            mongoTemplate.insert(leaguePosition);
        }*/
        mongoTemplate.insert(leaguePositionSet, LeaguePosition.class);
    }

}
