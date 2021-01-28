package com.issue1.demo.service;

/*
@Note：

@User：NineSun
@Time:2021/1/29   0:51
*/
public interface IRemoteAccess {
    public Object postJson(String url, Object params);

    public Object getJson(String url, Object... params);
}
