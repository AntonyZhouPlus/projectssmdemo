package com.zhouhang.domain;

import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * @author zhouhang
 * @project_name projectssmdemo
 * @package com.zhouhang.domain
 * @date 2018/9/2
 */
@NameStyle(Style.uppercase)
public class Traveller implements Serializable {
    @Id
    private String id;
    private String name;
    private String sex;
    private String phoneNum;
    private Integer credentialsType;
    @Transient
    private String credentialsTypeStr;
    private String credentialsNum;
    private Integer travellerType;
    @Transient
    private String travellerTypeStr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getCredentialsType() {
        return credentialsType;
    }

    public void setCredentialsType(Integer credentialsType) {
        this.credentialsType = credentialsType;
    }

    public String getCredentialsTypeStr() {
//        证件类型 0身份证 1护照 2军官证
        if (credentialsType == 0) {
            return "身份证";
        } else if (credentialsType == 1) {
            return "护照";
        } else {
            return "军官证";
        }

    }

    public void setCredentialsTypeStr(String credentialsTypeStr) {
        this.credentialsTypeStr = credentialsTypeStr;
    }

    public String getCredentialsNum() {
        return credentialsNum;
    }

    public void setCredentialsNum(String credentialsNum) {
        this.credentialsNum = credentialsNum;
    }

    public Integer getTravellerType() {
        return travellerType;
    }

    public void setTravellerType(Integer travellerType) {
        this.travellerType = travellerType;
    }

    public String getTravellerTypeStr() {
//        旅客类型(人群) 0 成人 1 儿童
        if (travellerType == 0) {
            return "成人";
        } else {
            return "儿童";
        }
    }

    public void setTravellerTypeStr(String travellerTypeStr) {
        this.travellerTypeStr = travellerTypeStr;
    }
}
