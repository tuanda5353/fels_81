package com.example.boylc.demomvp.screen.category;

import com.example.boylc.demomvp.data.model.Category;
import com.example.boylc.demomvp.data.repository.CategoryRepository;
import com.example.boylc.demomvp.data.source.CallBack;

import java.util.ArrayList;

public class CategoryPresenter implements CategoryContract.Presenter {
    private CategoryContract.View mView;
    private CategoryRepository mCategoryRepository;

    public CategoryPresenter(CategoryRepository mCategoryRepository) {
        this.mCategoryRepository = mCategoryRepository;
    }

    @Override
    public void setView(CategoryContract.View view) {
        this.mView=view;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }
    @Override
    public void getListCategory() {
        mCategoryRepository.getListCategory(new CallBack<ArrayList<Category>>() {
            @Override
            public void getDataSuccess(ArrayList<Category> data) {
                mView.onGetDataSuccess(data);
                mView.hideProgressBar();
            }

            @Override
            public void getDataFailure(Exception e) {
                mView.hideProgressBar();
                if (e!=null) e.printStackTrace();
            }
        });
    }
}
