package com.boom.athean.dao;/**
 * Created by Administrator on 2016/8/26.
 */

import com.boom.athean.model.View;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author chen.xinghu
 * @comment 炸弹人数据平台
 * @date 2016/8/26
 */
public interface ViewDao extends JpaRepository<View, Long> {
}
