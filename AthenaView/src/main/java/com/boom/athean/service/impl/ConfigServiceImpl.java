package com.boom.athean.service.impl;/**
 * Created by Administrator on 2016/8/26.
 */

import com.boom.athean.dao.IndicatorDao;
import com.boom.athean.dao.ProjectDao;
import com.boom.athean.dao.ViewDao;
import com.boom.athean.dto.request.ProjectAddRequest;
import com.boom.athean.model.Project;
import com.boom.athean.service.ConfigService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chen.xinghu
 * @comment 炸弹人数据平台
 * @date 2016/8/26
 */
@Service
public class ConfigServiceImpl implements ConfigService {


    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private ViewDao viewDao;

    @Autowired
    private IndicatorDao indicatorDao;

    //添加项目
    @Override
    public Project addProject(ProjectAddRequest projectAddRequest) {
        Project project = new Project();
        BeanUtils.copyProperties(projectAddRequest, project);
        return projectDao.save(project);
    }

    //添加项目视图
    @Override
    public Project addView(ProjectAddRequest projectAddRequest) {
        return addProject(projectAddRequest);
    }

    //添加视图参数
    @Override
    public Project addIndicator(ProjectAddRequest projectAddRequest) {
        return addProject(projectAddRequest);
    }

    @Override
    public void delProject(Long id) {
        projectDao.delete(id);
    }

    @Override
    public List<Project> getProjects() {
        return projectDao.findAll();
    }

    @Override
    public Project getProject(Long id) {
        return projectDao.findById(id);
    }


}
