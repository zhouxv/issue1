package com.issue1.demo.util;

import com.issue1.demo.entity.Issue2Result;
import com.issue1.demo.entity.Service;

public class Issue2Util {
    public static Service issue2ResultToService(Issue2Result issue2Result) {
        Service service = new Service();
        service.setServicecompany(issue2Result.getCompany_name());
        service.setServicetype(issue2Result.getServiceType());
        service.setServicename(issue2Result.getBusiness_name());
        service.setTestorganization(issue2Result.getEvaluator());
        service.setIssue2resultid(issue2Result.getIssue2resultid());
        return service;
    }
}
