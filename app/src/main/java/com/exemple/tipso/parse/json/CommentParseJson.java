package com.exemple.tipso.parse.json;


import com.exemple.tipso.model.Comment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adib on 23/04/15.
 */
public class CommentParseJson {
    public static List<Comment> parseFeed(String content){

        try {
            JSONArray ar = new JSONArray(content);
            List<Comment> commentList = new ArrayList<>();
            for (int i = 0; i < ar.length(); i++) {
                JSONObject obj = ar.getJSONObject(i);
                Comment comment = new Comment();
                comment.setIdComment(obj.getInt("idComment"));
                comment.setDescription(obj.getString("description"));
                comment.setIdUser(obj.getInt("idUser"));
                comment.setIdTip(obj.getInt("idTip"));

                commentList.add(comment);
            }
            return commentList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }
}
