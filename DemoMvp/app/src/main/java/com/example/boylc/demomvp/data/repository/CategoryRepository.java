package com.example.boylc.demomvp.data.repository;

import com.example.boylc.demomvp.data.model.Category;
import com.example.boylc.demomvp.data.source.CallBack;
import com.example.boylc.demomvp.data.source.CategoryDataSource;
import com.example.boylc.demomvp.data.source.remote.CategoryRemoteDataSource;

import java.util.ArrayList;

public class CategoryRepository implements CategoryDataSource.RemoteDataSource,CategoryDataSource.LocalDataSource {
    private CategoryRemoteDataSource mCategoryRemoteDataSource;

    public CategoryRepository(CategoryRemoteDataSource mCategoryRemoteDataSource) {
        this.mCategoryRemoteDataSource = mCategoryRemoteDataSource;
    }

    @Override
    public void getListCategory(CallBack<ArrayList<Category>> callBack) {
        mCategoryRemoteDataSource.getListCategory(callBack);
    }
}
