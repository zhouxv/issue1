package com.issue1.demo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 *  Entity
 *
 * @author zhouxv
 */
@Data
@TableName("test_result")
public class TestResult {


    @TableId(value = "testResultId", type = IdType.AUTO)
    private Integer testresultid;

    /**
     * 
     */
    @Valid
    @TableField("serviceId")
    @NotNull(message = "serviceid不能为空")
    private Integer serviceid;

    /**
     * 删除状态
     */
    @TableField("deleteState")
    private Integer deletestate;

    /**
     * 1,1,2,2,2,2,3,3,4 含义为在四个等级上的测评点结果为1/1,2/2,2/2,3/3,该指标等级为4
     */
    @TableField("result1")
    private String result1;

    /**
     * 
     */
    @TableField("result2")
    private String result2;

    /**
     * 
     */
    @TableField("result3")
    private String result3;

    /**
     * 
     */
    @TableField("result4")
    private String result4;

    /**
     * 
     */
    @TableField("result5")
    private String result5;

    /**
     * 
     */
    @TableField("result6")
    private String result6;

    /**
     * 
     */
    @TableField("result7")
    private String result7;

    /**
     * 
     */
    @TableField("result8")
    private String result8;

    /**
     * 
     */
    @TableField("result9")
    private String result9;

    /**
     * 
     */
    @TableField("result10")
    private String result10;

    /**
     * 
     */
    @TableField("result11")
    private String result11;

    /**
     * 
     */
    @TableField("result12")
    private String result12;

    /**
     * 
     */
    @TableField("result13")
    private String result13;

    /**
     * 
     */
    @TableField("result14")
    private String result14;

    /**
     * 
     */
    @TableField("result15")
    private String result15;

    /**
     * 
     */
    @TableField("result16")
    private String result16;

    /**
     * 
     */
    @TableField("result17")
    private String result17;

    /**
     * 
     */
    @TableField("result18")
    private String result18;

    /**
     * 
     */
    @TableField("result19")
    private String result19;

    /**
     * 
     */
    @TableField("result20")
    private String result20;

    /**
     * 
     */
    @TableField("result21")
    private String result21;

    /**
     * 
     */
    @TableField("result22")
    private String result22;

    /**
     * 
     */
    @TableField("result23")
    private String result23;

    /**
     * 
     */
    @TableField("result24")
    private String result24;

    /**
     * 
     */
    @TableField("result25")
    private String result25;

    /**
     * 
     */
    @TableField("result26")
    private String result26;

    /**
     * 
     */
    @TableField("result27")
    private String result27;

    /**
     * 
     */
    @TableField("result28")
    private String result28;

    /**
     * 
     */
    @TableField("result29")
    private String result29;

    /**
     * 
     */
    @TableField("result30")
    private String result30;

    /**
     * 
     */
    @TableField("result31")
    private String result31;

    /**
     * 
     */
    @TableField("result32")
    private String result32;

    /**
     * 
     */
    @TableField("result33")
    private String result33;

    /**
     * 
     */
    @TableField("result34")
    private String result34;

    /**
     * 
     */
    @TableField("result35")
    private String result35;

    /**
     * 
     */
    @TableField("result36")
    private String result36;

    /**
     * 
     */
    @TableField("result37")
    private String result37;

    /**
     * 
     */
    @TableField("result38")
    private String result38;

    /**
     * 
     */
    @TableField("result39")
    private String result39;

    /**
     * 
     */
    @TableField("result40")
    private String result40;

    /**
     * 
     */
    @TableField("result41")
    private String result41;

    /**
     * 
     */
    @TableField("result42")
    private String result42;

    /**
     * 
     */
    @TableField("result43")
    private String result43;

    /**
     * 
     */
    @TableField("result44")
    private String result44;

    /**
     * 
     */
    @TableField("result45")
    private String result45;

    /**
     * 
     */
    @TableField("result46")
    private String result46;

    /**
     * 
     */
    @TableField("result47")
    private String result47;

    /**
     * 
     */
    @TableField("result48")
    private String result48;

    /**
     * 
     */
    @TableField("result49")
    private String result49;

    /**
     * 
     */
    @TableField("result50")
    private String result50;

    /**
     * 
     */
    @TableField("result51")
    private String result51;

    /**
     * 
     */
    @TableField("result52")
    private String result52;

    /**
     * 
     */
    @TableField("result53")
    private String result53;

    /**
     * 
     */
    @TableField("result54")
    private String result54;

    /**
     * 
     */
    @TableField("result55")
    private String result55;

    /**
     * 
     */
    @TableField("result56")
    private String result56;

    /**
     * 
     */
    @TableField("result57")
    private String result57;

    /**
     * 
     */
    @TableField("result58")
    private String result58;

    /**
     * 
     */
    @TableField("result59")
    private String result59;

    /**
     * 
     */
    @TableField("result60")
    private String result60;

    /**
     * 
     */
    @TableField("result61")
    private String result61;

    /**
     * 
     */
    @TableField("result62")
    private String result62;

    /**
     * 
     */
    @TableField("result63")
    private String result63;

    /**
     * 
     */
    @TableField("result64")
    private String result64;

    /**
     * 
     */
    @TableField("result65")
    private String result65;

    /**
     * 
     */
    @TableField("result66")
    private String result66;

    /**
     * 
     */
    @TableField("result67")
    private String result67;

    /**
     * 
     */
    @TableField("result68")
    private String result68;

    /**
     * 
     */
    @TableField("result69")
    private String result69;

    /**
     * 
     */
    @TableField("result70")
    private String result70;

    /**
     * 
     */
    @TableField("result71")
    private String result71;

    /**
     * 
     */
    @TableField("result72")
    private String result72;

    /**
     * 
     */
    @TableField("result73")
    private String result73;

    /**
     * 
     */
    @TableField("result74")
    private String result74;

    /**
     * 
     */
    @TableField("result75")
    private String result75;

    /**
     * 
     */
    @TableField("result76")
    private String result76;

    /**
     * 
     */
    @TableField("result77")
    private String result77;

    /**
     * 
     */
    @TableField("result78")
    private String result78;

    /**
     * 
     */
    @TableField("result79")
    private String result79;

    /**
     * 
     */
    @TableField("result80")
    private String result80;

    /**
     * 
     */
    @TableField("result81")
    private String result81;

    /**
     * 
     */
    @TableField("result82")
    private String result82;

    /**
     * 
     */
    @TableField("result83")
    private String result83;

    /**
     * 
     */
    @TableField("result84")
    private String result84;

    /**
     * 
     */
    @TableField("result85")
    private String result85;

    /**
     * 
     */
    @TableField("result86")
    private String result86;

    /**
     * 
     */
    @TableField("result87")
    private String result87;

    /**
     * 
     */
    @TableField("result88")
    private String result88;

    /**
     * 
     */
    @TableField("result89")
    private String result89;

    /**
     * 
     */
    @TableField("result90")
    private String result90;

    /**
     * 
     */
    @TableField("result91")
    private String result91;

    /**
     * 
     */
    @TableField("result92")
    private String result92;

    /**
     * 
     */
    @TableField("result93")
    private String result93;

    /**
     * 
     */
    @TableField("result94")
    private String result94;

    /**
     * 
     */
    @TableField("result95")
    private String result95;

    /**
     * 
     */
    @TableField("result96")
    private String result96;

    /**
     * 
     */
    @TableField("result97")
    private String result97;

    /**
     * 
     */
    @TableField("result98")
    private String result98;

    /**
     * 
     */
    @TableField("result99")
    private String result99;

    /**
     * 
     */
    @TableField("result100")
    private String result100;

    /**
     * 
     */
    @TableField("result101")
    private String result101;

    /**
     * 
     */
    @TableField("result102")
    private String result102;

    /**
     * 
     */
    @TableField("result103")
    private String result103;

    /**
     * 
     */
    @TableField("result104")
    private String result104;

    /**
     * 
     */
    @TableField("result105")
    private String result105;

    /**
     * 
     */
    @TableField("result106")
    private String result106;

    /**
     * 
     */
    @TableField("result107")
    private String result107;

    /**
     * 
     */
    @TableField("result108")
    private String result108;

    /**
     * 
     */
    @TableField("result109")
    private String result109;

    /**
     * 
     */
    @TableField("result110")
    private String result110;

    /**
     * 
     */
    @TableField("result111")
    private String result111;

    /**
     * 
     */
    @TableField("result112")
    private String result112;

    /**
     * 
     */
    @TableField("result113")
    private String result113;

    /**
     * 
     */
    @TableField("result114")
    private String result114;

    /**
     * 
     */
    @TableField("result115")
    private String result115;

    /**
     * 
     */
    @TableField("result116")
    private String result116;

    /**
     * 
     */
    @TableField("result117")
    private String result117;

    /**
     * 
     */
    @TableField("result118")
    private String result118;

    /**
     * 
     */
    @TableField("result119")
    private String result119;

    /**
     * 
     */
    @TableField("result120")
    private String result120;

    /**
     * 
     */
    @TableField("result121")
    private String result121;

    /**
     * 
     */
    @TableField("result122")
    private String result122;

    /**
     * 
     */
    @TableField("result123")
    private String result123;

    /**
     * 
     */
    @TableField("result124")
    private String result124;

    /**
     * 
     */
    @TableField("result125")
    private String result125;

    /**
     * 
     */
    @TableField("result126")
    private String result126;

    /**
     * 
     */
    @TableField("result127")
    private String result127;

    /**
     * 
     */
    @TableField("result128")
    private String result128;

    /**
     * 
     */
    @TableField("result129")
    private String result129;

    /**
     * 
     */
    @TableField("result130")
    private String result130;

}
