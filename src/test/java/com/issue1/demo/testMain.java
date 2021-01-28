package com.issue1.demo;

import com.issue1.demo.entity.Service;

import static com.issue1.demo.util.Issue2Util.generateIssue2TestResult;

public class testMain {
    public static void main(String[] args) {
        Service service = new Service();
        service.setServiceid(1);
        System.out.println(generateIssue2TestResult(service));
    }
}
