package bggMongoDB.SpringBoot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bggMongoDB.SpringBoot.models.CommentModel;
import bggMongoDB.SpringBoot.models.GameModel;
import bggMongoDB.SpringBoot.repositories.CommentRepository;
import bggMongoDB.SpringBoot.repositories.GameRepository;

@Service
public class BggService {
    
    
    @Autowired
    private CommentRepository commentRepository;

    public List<CommentModel> getComments(int gid){
        return commentRepository.getCommentByGameId(gid);
    }


    @Autowired
    private GameRepository gameRepository;

    public List<GameModel> getGames(int limit, int skip){
        return gameRepository.getGames(limit, skip);
    }

    public List<GameModel> getGames(){
        return this.getGames(20, 0);
    }


}
