package com.boom.athean.service;/**
 * Created by Administrator on 2016/8/26.
 */

import com.boom.athean.dto.request.ProjectAddRequest;
import com.boom.athean.model.Project;

import java.util.List;

/**
 * @author chen.xinghu
 * @comment 炸弹人数据平台
 * @date 2016/8/26
 */
public interface ConfigService {

    Project addProject(ProjectAddRequest projectAddRequest);

    Project addView(ProjectAddRequest projectAddRequest);

    Project addIndicator(ProjectAddRequest projectAddRequest);

    void delProject(Long id);

    List<Project> getProjects();

    Project getProject(Long id);
}
