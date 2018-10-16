package com.example.boylc.demomvp.data.source;

public interface CallBack<T> {
    void getDataSuccess(T data);
    void getDataFailure(Exception e);
}
