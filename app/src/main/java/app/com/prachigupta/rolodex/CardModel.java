package app.com.prachigupta.rolodex;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CardModel {

    String lastName;
    String firstName;
    String email;
    String company;
    String startDate;
    String bio;
    String avatar;

    public CardModel(JSONObject jsonObject){
        try{
            this.lastName = jsonObject.getString("lastName");
            this.firstName = jsonObject.getString("firstName");
            this.email = jsonObject.getString("email");
            this.company = jsonObject.getString("company");
            this.startDate = jsonObject.getString("startDate");
            this.bio = jsonObject.getString("bio");
            this.avatar = jsonObject.getString("avatar");
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<CardModel>fromJsonArray(JSONArray array){
        ArrayList<CardModel> result = new ArrayList<>();

        for(int i =0;i<array.length();i++){
            try{

                result.add(new CardModel(array.getJSONObject(i)));

            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return result;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getCompany() {
        return company;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getBio() {
        return bio;
    }

    public String getAvatar() {
        return avatar;
    }




}
