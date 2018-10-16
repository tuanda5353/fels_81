package com.example.boylc.demomvp.data.model;

import com.example.boylc.demomvp.untils.Constants;

import org.json.JSONException;
import org.json.JSONObject;

public class Category {
    private int mId;
    private String mCategoryName;
    private String mCategoryImage;
    private String mCategoryImageThump;
    private int mTotalWallpaper;

    public Category(int mId, String mCategoryName, String mCategoryImage, String mCategoryImageThump, int mTotalWallpaper) {
        this.mId = mId;
        this.mCategoryName = mCategoryName;
        this.mCategoryImage = mCategoryImage;
        this.mCategoryImageThump = mCategoryImageThump;
        this.mTotalWallpaper = mTotalWallpaper;
    }

    public Category(JSONObject jsonObject)  {
        try {
            this.mId = jsonObject.getInt(Constants.JsonKey.CAT_ID);
            this.mCategoryName = jsonObject.getString(Constants.JsonKey.CATEGORY_NAME);
            this.mCategoryImage = jsonObject.getString(Constants.JsonKey.CATEGORY_IMAGE);
            this.mCategoryImageThump = jsonObject.getString(Constants.JsonKey.CATEGORY_IMAGE_THUMB);
            this.mTotalWallpaper = jsonObject.getInt(Constants.JsonKey.TOTAL_WALLPAPER);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getCategoryName() {
        return mCategoryName;
    }

    public void setCategoryName(String mCategoryName) {
        this.mCategoryName = mCategoryName;
    }

    public String getCategoryImage() {
        return mCategoryImage;
    }

    public void setCategoryImage(String mCategoryImage) {
        this.mCategoryImage = mCategoryImage;
    }

    public String getCategoryImageThump() {
        return mCategoryImageThump;
    }

    public void setCategoryImageThump(String mCategoryImageThump) {
        this.mCategoryImageThump = mCategoryImageThump;
    }

    public int getTotalWallpaper() {
        return mTotalWallpaper;
    }

    public void setTotalWallpaper(int mTotalWallpaper) {
        this.mTotalWallpaper = mTotalWallpaper;
    }

}
