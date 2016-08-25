package com.boom.athena.service;


import com.boom.athena.BaseTest;
import com.boom.athena.stream.handler.RabbitUVHandler;
import com.boom.athena.stream.service.KeyService;
import com.boom.athena.stream.service.UVService;
import com.boom.athena.uvreport.dto.ReportItem;
import com.boom.athena.uvreport.export.UVReport;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑, 永无BUG!
 * 　　　　┃　　　┃Code is far away from bug with the animal protecting
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━感觉萌萌哒━━━━━━
 * Module Desc:clover
 * User: z.mm | 2428922347@qq.com
 * Date: 2016/3/7
 * Time: 17:25
 * state:
 */
public class UVHandlerTest extends BaseTest {

    @Autowired
    private RabbitUVHandler rabbitUVHandler;

    @Autowired
    private KeyService keyService;

    @Autowired
    private UVService uvService;

    @Autowired
    private UVReport uvReport;


    private static SimpleDateFormat withHour = new SimpleDateFormat("yyyy-MM-dd");

    //@Before
    public void addDate() {
        uvService.setVisit("school-2015-08-20", "1");
        uvService.setVisit("school-2015-08-20", "2");
        uvService.setVisit("school-2015-08-20", "3");
        uvService.setVisit("school-2015-08-20", "4");
        uvService.setVisit("school-2015-08-20", "5");
        uvService.setVisit("school-2015-08-20", "6");
        uvService.setVisit("school-2015-08-20", "7");
        uvService.setVisit("school-2015-08-20", "8");


        uvService.setVisit("school-2015-08-21", "1");
        uvService.setVisit("school-2015-08-21", "2");
        uvService.setVisit("school-2015-08-21", "3");
        uvService.setVisit("school-2015-08-21", "4");
        uvService.setVisit("school-2015-08-21", "5");
        uvService.setVisit("school-2015-08-21", "6");
        uvService.setVisit("school-2015-08-21", "7");
        uvService.setVisit("school-2015-08-21", "9");
        uvService.setVisit("school-2015-08-21", "11");
        uvService.setVisit("school-2015-08-21", "12");


        uvService.setVisit("school-2015-08-22", "11");
        uvService.setVisit("school-2015-08-22", "12");
        uvService.setVisit("school-2015-08-22", "13");
        uvService.setVisit("school-2015-08-22", "14");
        uvService.setVisit("school-2015-08-22", "5");
        uvService.setVisit("school-2015-08-22", "6");
        uvService.setVisit("school-2015-08-22", "1");
        uvService.setVisit("school-2015-08-22", "2");
        uvService.setVisit("school-2015-08-22", "3");
        uvService.setVisit("school-2015-08-22", "4");
        uvService.setVisit("school-2015-08-22", "7");
        uvService.setVisit("school-2015-08-22", "9");
        uvService.setVisit("school-2015-08-22", "11");
        uvService.setVisit("school-2015-08-22", "12");

        System.out.println("+++");
    }


    @Test
    public void jiaoTest() throws ParseException {
        Date start = withHour.parse("2015-08-20");
        Date end = withHour.parse("2015-08-22");
        List<ReportItem> school = uvReport.getRemainDate("school", start, end);
        System.out.println(school);
    }

}
