package com.issue1.demo.util;

import com.issue1.demo.entity.GroupLevel;
import com.issue1.demo.entity.GroupLevelDto;
import com.issue1.demo.entity.SagLevel;
import com.issue1.demo.entity.SagLevelDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.issue1.demo.util.ConvertList.convertGroupLevel;

public class DTO {
     public static List<Map<String,Object>> DtoListSagLevel(List<SagLevel> sagLevelList)
     {
          if(sagLevelList.get(0)==null) return null;
          List<Map<String,Object>> mapList=new ArrayList<>();
          for (SagLevel sagLevel : sagLevelList) {
               mapList.add(SagLevelToMap(sagLevel));
          }
          return mapList;
     }

     public static Map<String,Object> SagLevelToMap(SagLevel sagLevel){
          Map<String,Object> map=new HashMap<>();
          map.put("saglevelid", sagLevel.getSaglevelid().toString());
          map.put("serviceid",sagLevel.getServiceid().toString());
          map.put("S类",new SagLevelDto("S类","访问控制,密码支持 ,数据保密性, 数据完整性 ,数据和应用可用性, 数据销毁 ,数据备份恢复 ,电子合同", sagLevel.getSresult()));
          map.put("A类",new SagLevelDto("A类","边界防护, 身份鉴别, 入侵防范, 监控与检测, 恶意代码防范, 个人数据恢复, 事件预警和处置", sagLevel.getAresult()));
          map.put("G类",new SagLevelDto("G类","安全审计与验证,机构配置管理,剩余信息保护,安全策略,管理制度,安全日志,流程管理,服务协议", sagLevel.getGresult()));
          map.put("综合等级",sagLevel.getLevel());
          return map;
     }

     public static List<Map<String,Object>> DtoListGroupLevel(List<GroupLevel> groupLevelList)
     {
          if(groupLevelList.get(0)==null) return null;
          List<Map<String,Object>> mapList=new ArrayList<>();
          for (GroupLevel groupLevel : groupLevelList) {
               mapList.add(GroupLevelToMap(groupLevel));
          }
          return mapList;
     }

     public static Map<String,Object> GroupLevelToMap(GroupLevel groupLevel){
          Map<String,Object> map=new HashMap<>();
          List<String> stringList=convertGroupLevel(groupLevel);
          List<GroupLevelDto> groupLevelDtoList=new ArrayList<>();
          String[] categoryArray={"边界防护","访问控制","身份鉴别","密码支持","入侵防范","监控与检测","恶意代码防范","数据保密性","数据完整性","数据和应用可用性","数据销毁","数据备份恢复","个人数据恢复","安全审计与验证","机构配置管理","剩余信息保护","安全策略","事件预警和处置","管理制度","安全日志","流程管理","服务协议","电子合同"};
          for (int i = 0; i < 23; i++) {
               groupLevelDtoList.add(new GroupLevelDto(categoryArray[i],""+i,stringList.get(i)));
          }
          map.put("grouplevelid", groupLevel.getGrouplevelid().toString());
          map.put("serviceid",groupLevel.getServiceid().toString());
          map.put("23个分类得分的list",groupLevelDtoList);
          return map;
     }
}
