package bggMongoDB.SpringBoot.models;

import org.bson.Document;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class GameModel {
    
    private int gid;
    private String name;
    private int year;
    private String image;

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    // "??" the name you want to display out ex. {"gameid": 123)
    public JsonObject toJsonObject(){
        return Json.createObjectBuilder()
        .add("gid", gid)
        .add("name", name)
        .add("year", year)
        .add("image", image)
        .build();
    }

    public static GameModel createGame(Document document){
        GameModel gameModel = new GameModel();
        gameModel.setGid(document.getInteger("gid"));
        gameModel.setName(document.getString("name"));
        gameModel.setYear(document.getInteger("year"));
        gameModel.setImage(document.getString("image"));
        return gameModel;
    }

}
