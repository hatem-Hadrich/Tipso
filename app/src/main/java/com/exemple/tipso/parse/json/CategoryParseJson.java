package com.exemple.tipso.parse.json;


import com.exemple.tipso.model.Category;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adib on 23/04/15.
 */
public class CategoryParseJson {
    public static List<Category> parseFeed(String content){

        try {
            JSONArray ar = new JSONArray(content);
            List<Category> categoryList = new ArrayList<>();
            for (int i = 0; i < ar.length(); i++) {
                JSONObject obj = ar.getJSONObject(i);
                Category category = new Category();
                category.setIdCategory(obj.getInt("idCategory"));
                category.setCategoryName(obj.getString("categoryName"));
                category.setPicture(obj.getString("picture"));
                category.setDescription(obj.getString("description"));

                categoryList.add(category);
            }
            return categoryList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }
}
