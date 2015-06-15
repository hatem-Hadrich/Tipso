package com.exemple.tipso.parse.json;


import com.exemple.tipso.model.CategoryChoosed;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adib on 23/04/15.
 */
public class CategoryChoosedParseJson {
    public static List<CategoryChoosed> parseFeed(String content){

        try {
            JSONArray ar = new JSONArray(content);
            List<CategoryChoosed> categoryChoosedList = new ArrayList<>();
            for (int i = 0; i < ar.length(); i++) {
                JSONObject obj = ar.getJSONObject(i);
                CategoryChoosed categoryChoosed = new CategoryChoosed();
                categoryChoosed.setIdUser(obj.getInt("idUser"));
                categoryChoosed.setIdCategory(obj.getInt("idCategory"));
                categoryChoosed.setIdCategoryChoosed(obj.getInt("idCategoryChoosed"));

                categoryChoosedList.add(categoryChoosed);
            }
            return categoryChoosedList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }
}
