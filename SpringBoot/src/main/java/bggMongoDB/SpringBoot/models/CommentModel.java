package bggMongoDB.SpringBoot.models;

import org.bson.Document;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class CommentModel {
    
    private String c_id;
    private String user;
    private int rating;
    private String c_text;

    public String getC_id() {
        return c_id;
    }
    public void setC_id(String c_id) {
        this.c_id = c_id;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public String getC_text() {
        return c_text;
    }
    public void setC_text(String c_text) {
        this.c_text = c_text;
    }

    public JsonObject toJsonObject(){
        return Json.createObjectBuilder()
        .add("c_id", c_id)
        .add("user", user)
        .add("rating", rating)
        .add("c_text", c_text)
        .build();
    }

    public static CommentModel createComment(Document document){
        CommentModel commentModel = new CommentModel();
        commentModel.setC_id(document.getString("c_id"));
        commentModel.setUser(document.getString("user"));
        commentModel.setRating(document.getInteger("rating"));
        commentModel.setC_text(document.getString("c_text"));
        return commentModel;
    }

}
