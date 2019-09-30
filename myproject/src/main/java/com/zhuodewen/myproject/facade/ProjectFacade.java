package com.zhuodewen.myproject.facade;

import com.zhuodewen.myproject.domain.Project;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectFacade {

    public Project selectById(int id);
}
