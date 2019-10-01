package com.zhuodewen.myproject.facade;

import com.github.pagehelper.PageInfo;
import com.zhuodewen.myproject.domain.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentFacade {

    public Student selectById(int id);

    PageInfo query(Student qo);


}

