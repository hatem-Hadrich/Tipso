package com.exemple.tipso.parse.json;


import com.exemple.tipso.model.Favorite;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by adib on 23/04/15.
 */
public class FavoriteParseJson {
    public static List<Favorite> parseFeed(String content){

        try {
            JSONArray ar = new JSONArray(content);
            List<Favorite> favoriteList = new ArrayList<>();
            for (int i = 0; i < ar.length(); i++) {
                JSONObject obj = ar.getJSONObject(i);
                Favorite favorite = new Favorite();
                favorite.setIdFavorite(obj.getInt("idFavorite"));
                favorite.setDate(Date.valueOf(obj.getString("date")));
                favorite.setIdTip(obj.getInt("idTip"));
                favorite.setIdUser(obj.getInt("idUser"));
                favoriteList.add(favorite);
            }
            return favoriteList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }
}
