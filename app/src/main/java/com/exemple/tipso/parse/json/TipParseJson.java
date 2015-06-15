package com.exemple.tipso.parse.json;


import com.exemple.tipso.model.Tip;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by adib on 23/04/15.
 */
public class TipParseJson {
    public static List<Tip> parseFeed(String content){


        try {
            JSONArray ar = new JSONArray(content);
            List<Tip> tipList = new ArrayList<>();
            for (int i = 0; i < ar.length(); i++) {
                JSONObject obj = ar.getJSONObject(i);
                Tip tip = new Tip();
                tip.setIdTip(obj.getInt("idTip"));
                tip.setPicture(obj.getString("picture"));
                tip.setTitle(obj.getString("title"));
                tip.setDescription(obj.getString("description"));
                tip.setYoutubeLink(obj.getString("youtubeLink"));
                tip.setNumberView(obj.getInt("numberView"));
                tip.setNumberComment(obj.getInt("numberComment"));
                tip.setDatePublication(Date.valueOf(obj.getString("datePublication")));
                tipList.add(tip);
            }
            return tipList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }

}
