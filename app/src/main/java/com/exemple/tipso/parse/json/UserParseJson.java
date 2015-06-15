package com.exemple.tipso.parse.json;


import com.exemple.tipso.model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adib on 23/04/15.
 */
public class UserParseJson {
    public static List<User> parseFeed(String content){
        try {
            JSONArray ar = new JSONArray(content);
            List<User> userList = new ArrayList<>();
            for (int i = 0; i < ar.length(); i++) {
                JSONObject obj = ar.getJSONObject(i);
                User user = new User();
                user.setIdUser(obj.getInt("idUser"));
                user.setFirstName(obj.getString("firstName"));
                user.setSecondName(obj.getString("secondName"));
                user.setEmail(obj.getString("email"));
                user.setPassWord(obj.getString("passWord"));
                user.setBirthday(obj.getString("birthday"));
                user.setCountry(obj.getString("country"));
                user.setGender(obj.getString("gender"));
                userList.add(user);
            }
            return userList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
