package com.zhuodewen.myproject.service;

import com.zhuodewen.myproject.domain.Project;
import com.zhuodewen.myproject.facade.ProjectFacade;
import com.zhuodewen.myproject.mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProjectService implements ProjectFacade {

    @Autowired
    private ProjectMapper projectMapper;

    /**
     * 根据id查询学生对象
     * @param id
     * @return
     */
    public Project selectById(int id) {
        return projectMapper.selectByPrimaryKey(id);
    }
}
