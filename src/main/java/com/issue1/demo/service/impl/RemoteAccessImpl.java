package com.issue1.demo.service.impl;

import com.issue1.demo.service.IRemoteAccess;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/*
@Note：

@User：NineSun
@Time:2021/1/29   0:53
*/
@Service
public class RemoteAccessImpl implements IRemoteAccess {
    @Override
    public Object getJson(String url, Object... params) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> responseEntity = restTemplate.getForEntity(url, Object.class, params);
        return responseEntity.getBody();
    }

    @Override
    public Object postJson(String url, Object params) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> responseEntity = restTemplate.postForEntity(url, params, Object.class);
        Object body = responseEntity.getBody();
        return body;
    }
}
