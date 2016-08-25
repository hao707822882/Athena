package com.boom.athena.uvreport.dto;/**
 * Created by Administrator on 2016/8/24.
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chen.xinghu
 * @comment 炸弹人数据平台
 * @date 2016/8/24
 */
public class ReportItem implements Serializable {
    private String name;

    private List<Integer> data = new ArrayList<Integer>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }


    public void addDate(Integer integer) {
        data.add(integer);
    }

    @Override
    public String toString() {
        return "ReportItem{" +
                "name='" + name + '\'' +
                ", data=" + data +
                '}';
    }
}
