package com.boom.chat.dao;/**
 * Created by Administrator on 2016/8/28.
 */

import com.boom.chat.model.TearmDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author chen.xinghu
 * @comment 炸弹人数据平台
 * @date 2016/8/28
 */
public interface TearmDetailDao extends JpaRepository<TearmDetail, Long> {

    @Query(value = "select tearm,count(id) from tearm_detail where add_date BETWEEN :start AND :end  group by tearm", nativeQuery = true)
    List teramCountByGroup(@Param("start") Date start, @Param("end") Date end);

}
