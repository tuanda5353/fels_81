package com.example.boylc.demomvp.screen.category;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.example.boylc.demomvp.R;
import com.example.boylc.demomvp.data.model.Category;
import com.example.boylc.demomvp.data.repository.CategoryRepository;
import com.example.boylc.demomvp.data.source.remote.CategoryRemoteDataSource;
import com.example.boylc.demomvp.screen.base.BaseActivity;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements CategoryContract.View {
    private static final String TAG = "mainactivity";
    private RecyclerView mRecyclerCategory;
    private CategoryPresenter mCategoryPresenter;
    private ProgressBar mProgressMain;
    private ArrayList<Category> mCategories;
    private CategoryAdapter mCategoryAdapter;
    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void initComponents() {
        mRecyclerCategory = findViewById(R.id.recycler_category);
        mProgressMain = findViewById(R.id.progress_main);
        mCategories = new ArrayList<>();
        mCategoryAdapter = new CategoryAdapter(this,mCategories);
        mRecyclerCategory.setAdapter(mCategoryAdapter);
        mRecyclerCategory.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        CategoryRemoteDataSource categoryRemoteDataSource = new CategoryRemoteDataSource();
        CategoryRepository categoryRepository = new CategoryRepository(categoryRemoteDataSource);
        mCategoryPresenter = new CategoryPresenter(categoryRepository);
        mCategoryPresenter.setView(this);
        loadData();
    }

    private void loadData() {
        mCategoryPresenter.getListCategory();
    }

    @Override
    public void onGetDataSuccess(ArrayList<Category> data) {
        mCategories.addAll(data);
        mCategoryAdapter.notifyDataSetChanged();
    }

    @Override
    public void hideProgressBar() {
        mProgressMain.setVisibility(View.GONE);
    }
}
