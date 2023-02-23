package bggMongoDB.SpringBoot.repositories;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import bggMongoDB.SpringBoot.models.CommentModel;

@Repository
public class CommentRepository {
    
    @Autowired
    MongoTemplate mongoTemplate;

    public List<CommentModel> getCommentByGameId(int gid){
        Criteria criteria = Criteria.where("gid").is(gid);
        // pass in the criteria and call the query
        Query query = Query.query(criteria);
        // convert documant into comment object
        return mongoTemplate.find(query, Document.class, "comments")
        .stream().map(v -> {return CommentModel.createComment(v);})
        .toList();
    }

}
