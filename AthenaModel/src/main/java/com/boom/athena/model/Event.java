package com.boom.athena.model;/**
 * Created by Administrator on 2016/8/23.
 */

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 * @author chen.xinghu
 * @comment 炸弹人数据平台
 * @date 2016/8/23
 */
@Document(indexName = "athena", type = "event", shards = 10, replicas = 0, refreshInterval = "1", createIndex = true)
public class Event extends MessageBase {

    @Id
    private Long id;

    @Version
    private Long version;

    private String domain;

    private String name;

    private Long actionId;

    private Integer dataType;

    private String value;

    private Integer order;

    private String client;

    private Date startTime;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getActionId() {
        return actionId;
    }

    public void setActionId(Long actionId) {
        this.actionId = actionId;
    }

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
}
