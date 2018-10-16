package com.example.boylc.demomvp.data.source.remote;

import android.os.AsyncTask;
import android.util.Log;

import com.example.boylc.demomvp.data.model.Category;
import com.example.boylc.demomvp.data.source.CallBack;

import org.json.JSONException;

import java.util.ArrayList;

public class CategoryRemoteAsyncTask extends AsyncTask<String, String, ArrayList<Category>> {
    private CallBack<ArrayList<Category>> mCallBack;

    public CategoryRemoteAsyncTask(CallBack<ArrayList<Category>> mCallBack) {
        this.mCallBack = mCallBack;
    }

    @Override
    protected ArrayList<Category> doInBackground(String... strings) {
        ArrayList<Category> mCategories = new ArrayList<>();
        String mJson = FetchDataFromApi.getJsonStringFromApi(strings[0], 15000);
        if (mJson!=null) mCategories = FetchDataFromApi.convertJsonToArrayCategory(mJson);
        return mCategories;
    }

    @Override
    protected void onPostExecute(ArrayList<Category> categories) {
        super.onPostExecute(categories);
        mCallBack.getDataSuccess(categories);
    }
}
