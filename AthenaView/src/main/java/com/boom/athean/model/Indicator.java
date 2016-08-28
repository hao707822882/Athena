package com.boom.athean.model;/**
 * Created by Administrator on 2016/8/26.
 */

import com.boom.base.entity.GenerateIdWithOutVersionEntity;

import javax.persistence.Entity;

/**
 * @author chen.xinghu
 * @comment 炸弹人数据平台
 * @date 2016/8/26
 */
@Entity
public class Indicator extends GenerateIdWithOutVersionEntity {

    private String name;

    private String codeName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }
}
