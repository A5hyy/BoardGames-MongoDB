package bggMongoDB.SpringBoot.repositories;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import bggMongoDB.SpringBoot.models.GameModel;

@Repository
public class GameRepository {
    
    @Autowired
    private MongoTemplate mongoTemplate;

    // limit the amount 10 per page, skip page to next 10 for example
    public List<GameModel> getGames(int limit, int skip){
        Query query = (new Query()).limit(limit).skip(skip);
        // convert documant into comment object
        return mongoTemplate.find(query, Document.class, "games")
        .stream()
        .map(v -> {return GameModel.createGame(v);})
        .toList();
    }
}
