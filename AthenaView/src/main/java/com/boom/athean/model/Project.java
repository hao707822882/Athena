package com.boom.athean.model;/**
 * Created by Administrator on 2016/8/26.
 */

import com.boom.base.entity.GenerateIdEntity;
import com.boom.base.entity.GenerateIdWithOutVersionEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author chen.xinghu
 * @comment 炸弹人数据平台
 * @date 2016/8/26
 */
@Entity
public class Project extends GenerateIdWithOutVersionEntity {

    private String name;

    private String domain;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<View> views;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public List<View> getViews() {
        return views;
    }

    public void setViews(List<View> views) {
        this.views = views;
    }
}
