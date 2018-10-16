package com.example.boylc.demomvp.data.source.remote;

import android.util.Log;

import com.example.boylc.demomvp.data.model.Category;
import com.example.boylc.demomvp.untils.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class FetchDataFromApi {
    private static final String TAG = "fetchdatafromapi";

    public static String getJsonStringFromApi(String url, int timeout) {
        HttpURLConnection mHttpURLConnection = null;
        try {
            URL u = new URL(url);
            mHttpURLConnection = (HttpURLConnection) u.openConnection();
            mHttpURLConnection.setRequestMethod(Constants.JsonKey.METHOD_GET);
            mHttpURLConnection.setRequestProperty("Content-length", "0");
            mHttpURLConnection.setUseCaches(false);
            mHttpURLConnection.setAllowUserInteraction(false);
            mHttpURLConnection.setConnectTimeout(timeout);
            mHttpURLConnection.setReadTimeout(timeout);
            mHttpURLConnection.connect();
            int status = mHttpURLConnection.getResponseCode();
            Log.d(TAG, "getJsonStringFromApi: " + status);
            if (status == 200) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(mHttpURLConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line + "\n");
                }
                bufferedReader.close();
                mHttpURLConnection.disconnect();
                return stringBuilder.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Category> convertJsonToArrayCategory(String mJson) {
        ArrayList<Category> mCategories = new ArrayList<>();
        JSONObject mJsonObject = null;
        try {
            mJsonObject = new JSONObject(mJson);
            JSONArray mJsonArray = mJsonObject.getJSONArray(Constants.JsonKey.ARRAY);
            for (int i = 0; i < mJsonArray.length(); i++) {
                JSONObject mJsonObjectCategory = mJsonArray.getJSONObject(i);
                Category mCategory = new Category(mJsonObjectCategory);

                mCategories.add(mCategory);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mCategories;
    }
}
