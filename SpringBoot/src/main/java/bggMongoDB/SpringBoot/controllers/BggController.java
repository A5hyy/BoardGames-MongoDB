package bggMongoDB.SpringBoot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bggMongoDB.SpringBoot.models.CommentModel;
import bggMongoDB.SpringBoot.models.GameModel;
import bggMongoDB.SpringBoot.services.BggService;
import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;



@Controller
@RequestMapping(path = "/api")
public class BggController {

    @Autowired
    private BggService bggService;

    @GetMapping(path = "/games")
    public ResponseEntity<String> getGames(@RequestParam(defaultValue = "20") int limit, @RequestParam(defaultValue = "0") int offset){
        List<GameModel> games = bggService.getGames(limit, offset);
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        games.stream().forEach(v -> {jsonArrayBuilder.add(v.toJsonObject());});
        return ResponseEntity.ok(jsonArrayBuilder.build().toString());
    }

    @GetMapping(path = "/game/{gid}/comments")
    public ResponseEntity<String> getComments(@PathVariable int gid){
        List<CommentModel> comments = bggService.getComments(gid);
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        comments.stream().forEach(v -> {jsonArrayBuilder.add(v.toJsonObject());});
        return ResponseEntity.ok(jsonArrayBuilder.build().toString());

    }
    
}


