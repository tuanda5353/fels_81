package com.example.boylc.demomvp.screen.base;

public interface BasePresenter<T> {
    void setView(T view);
    void onStart();
    void onStop();
}
