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
public class View extends GenerateIdWithOutVersionEntity {

    private String name;

    private String codeName;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Indicator> indicators;

    public List<Indicator> getIndicators() {
        return indicators;
    }

    public void setIndicators(List<Indicator> indicators) {
        this.indicators = indicators;
    }

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
