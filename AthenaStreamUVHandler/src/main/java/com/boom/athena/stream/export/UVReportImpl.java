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

import java.util.*;

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
        List<Date> copy = new ArrayList(datesBetween.size());
        copy.addAll(datesBetween);
        Collections.reverse(copy);
        List<ReportItem> reportItems = new ArrayList<ReportItem>(datesBetween.size());
        for (Date date : copy) {//从最早的一天开始
            String uvOuterKey = keyService.getUVOuterKey(domain, date);
            ReportItem reportItem = new ReportItem();
            for (int index = 0; index < copy.size(); index++) {
                Date date1 = copy.get(index);
                String uvTemp = keyService.getUVOuterKey(domain, date1);
                Set visitJiao = uvService.getVisitJiao(uvOuterKey, uvTemp);
                reportItem.setName(uvOuterKey);
                if (date.getTime() > date1.getTime()) {
                    reportItem.addDate(0);
                } else {
                    reportItem.addDate(visitJiao.size());
                }
            }
            reportItems.add(reportItem);
        }
        return reportItems;
    }

    @Override
    public List<ReportItem> getFreshDate(String domain, Date start, Date end) {
        if (end == null) {
            end = new Date();
        }
        List<Date> datesBetween = DateUtil.getDatesBetween(start, end);
        List<Date> copy = new ArrayList(datesBetween.size());
        copy.addAll(datesBetween);
        Collections.reverse(copy);
        String outer = keyService.getUVOuterKey(domain, start);
        List<ReportItem> reportItems = new ArrayList<>();
        ReportItem reportItem = new ReportItem();
        reportItem.setName(outer);
        List list = new ArrayList<>();
        for (Date date : copy) {
            String in = keyService.getUVOuterKey(domain, date);
            boolean sameDate = DateUtil.isSameDate(date, start);
            if (sameDate) {
                Set visit = uvService.getVisit(outer);
                list.add(visit.size());
            } else {
                Set cha = uvService.getNew(in, outer);
                list.add(cha.size());
            }
        }
        reportItem.setData(list);
        reportItems.add(reportItem);
        return reportItems;
    }

    @Override
    public List<ReportItem> getAllDate(String name, Date start, Date end) {
        List<Date> datesBetween = DateUtil.getDatesBetween(start, end);
        List<Date> copy = new ArrayList(datesBetween.size());
        copy.addAll(datesBetween);
        Collections.reverse(copy);

        String outer = keyService.getUVOuterKey(name, start);
        List<ReportItem> reportItems = new ArrayList<>();
        ReportItem reportItem = new ReportItem();
        reportItem.setName(outer);
        List list = new ArrayList<>();
        for (Date date : copy) {
            String in = keyService.getUVOuterKey(name, date);
            Set visit = uvService.getVisit(in);
            list.add(visit.size());
        }
        reportItem.setData(list);
        reportItems.add(reportItem);
        return reportItems;
    }
}
