package com.issue1.demo.service;

/*
@Note：

@User：NineSun
@Time:2021/1/29   0:51
*/
public interface IRemoteAccess {
    Object postJson(String url, Object params);

    Object getJson(String url, Object... params);
}
