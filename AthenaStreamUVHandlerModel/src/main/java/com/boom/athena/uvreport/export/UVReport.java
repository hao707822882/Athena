package com.boom.athena.uvreport.export;/**
 * Created by Administrator on 2016/8/24.
 */

import com.boom.athena.uvreport.dto.ReportItem;

import java.util.Date;
import java.util.List;

/**
 * @author chen.xinghu
 * @comment 炸弹人数据平台
 * @date 2016/8/24
 */
public interface UVReport {

    //获取用户留存堆积数据
    List<ReportItem> getRemainDate(String domain, Date start, Date end);

    //获取用户新鲜度数据
    List<ReportItem> getFreshDate(String domain, Date start, Date end, int interval);

}
