package com.boom.athean.controller;/**
 * Created by Administrator on 2016/8/27.
 */

import com.boom.athena.uvreport.dto.ReportItem;
import com.boom.athena.uvreport.export.UVReport;
import com.boom.base.rt.DateRTBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author chen.xinghu
 * @comment 炸弹人数据平台
 * @date 2016/8/27
 */
@RestController
public class UVController {

    @Autowired
    private UVReport uvReport;


    /**
     * 获取留存数据
     *
     * @param name
     * @param start
     * @param end
     * @return
     */
    @RequestMapping("/admin/remain")
    public DateRTBean getLC(@RequestParam("name") String name, @RequestParam("start") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start, @RequestParam("end") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end) {
        List<ReportItem> remainDate = uvReport.getRemainDate(name, start, end);
        return DateRTBean.newInstance(false, "", remainDate);
    }


    /**
     * 获取用户新鲜度
     *
     * @param name
     * @param start
     * @param end
     * @return
     */
    @RequestMapping("/admin/new")
    public DateRTBean getNEW(@RequestParam("name") String name, @RequestParam("start") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start, @RequestParam("end") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end) {
        List<ReportItem> remainDate = uvReport.getFreshDate(name, start, end);
        return DateRTBean.newInstance(false, "", remainDate);
    }

    /**
     * 获取用户新鲜度
     *
     * @param name
     * @param start
     * @param end
     * @return
     */
    @RequestMapping("/admin/all")
    public DateRTBean getAll(@RequestParam("name") String name, @RequestParam("start") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start, @RequestParam("end") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end) {
        List<ReportItem> remainDate = uvReport.getAllDate(name, start, end);
        return DateRTBean.newInstance(false, "", remainDate);
    }


}
