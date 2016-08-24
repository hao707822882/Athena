package com.boom.athena.stream.export;/**
 * Created by Administrator on 2016/8/24.
 */

import com.boom.athena.stream.service.KeyService;
import com.boom.athena.stream.service.UVService;
import com.boom.athena.uvreport.dto.ReportItem;
import com.boom.athena.uvreport.export.UVReport;
import com.boom.base.util.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author chen.xinghu
 * @comment 炸弹人数据平台
 * @date 2016/8/24
 */
@Service
public class UVReportImpl implements UVReport {

    @Autowired
    private UVService uvService;

    @Autowired
    private KeyService keyService;

    @Override
    public List<ReportItem> getRemainDate(String domain, Date start, Date end) {
        List<Date> datesBetween = DateUtil.getDatesBetween(start, end);
        //从最早的一天开始计算留存率
        //反转date数据
        List<Date> copy = new ArrayList();
        BeanUtils.copyProperties(datesBetween, copy);
        for (Date date : datesBetween) {
            for (int index = 0; index < copy.size(); index++) {
                String uvOuterKey = keyService.getUVOuterKey(domain, copy.get(index));
                
            }
        }
        return null;
    }

    @Override
    public List<ReportItem> getFreshDate(String domain, Date start, Date end, int interval) {

        return null;
    }
}
