package com.boom.athean.controller;/**
 * Created by Administrator on 2016/8/26.
 */

import com.boom.athean.dto.request.ProjectAddRequest;
import com.boom.athean.model.Project;
import com.boom.athean.service.ConfigService;
import com.boom.base.rt.DateRTBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chen.xinghu
 * @comment 炸弹人数据平台
 * @date 2016/8/26
 */
@RestController
@RequestMapping("/admin")
public class ConfigController {

    @Autowired
    private ConfigService configService;

    /**
     * 添加或者更新 project
     *
     * @param projectAddRequest
     * @return
     */
    @RequestMapping("/addOrUpdateProject")
    public DateRTBean addProject(@RequestBody ProjectAddRequest projectAddRequest) {
        Project project = configService.addProject(projectAddRequest);
        return DateRTBean.newInstance(false, "", project);
    }

    @RequestMapping("/getProject")
    public DateRTBean getProject() {
        List<Project> projectList = configService.getProjects();
        return DateRTBean.newInstance(false, "", projectList);
    }


    @RequestMapping("/getProject/{id}")
    public DateRTBean getProject(@PathVariable("id") Long id) {
        Project project = configService.getProject(id);
        return DateRTBean.newInstance(false, "", project);
    }


    @RequestMapping("/delProject/{id}")
    public DateRTBean delProject(@PathVariable("id") Long id) {
        configService.delProject(id);
        return DateRTBean.newInstance(false, "", null);
    }

}
