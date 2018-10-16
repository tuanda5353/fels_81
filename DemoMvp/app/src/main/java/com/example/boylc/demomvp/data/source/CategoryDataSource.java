package com.example.boylc.demomvp.data.source;

import com.example.boylc.demomvp.data.model.Category;

import java.util.ArrayList;

public class CategoryDataSource {
    public interface RemoteDataSource {
        void getListCategory(CallBack<ArrayList<Category>> callBack);
    }

    public interface LocalDataSource {

    }
}
