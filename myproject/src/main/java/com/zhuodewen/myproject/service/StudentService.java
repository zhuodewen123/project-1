package com.zhuodewen.myproject.service;

import com.zhuodewen.myproject.domain.Student;
import com.zhuodewen.myproject.facade.StudentFacade;
import com.zhuodewen.myproject.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentService implements StudentFacade {

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 根据id查询学生对象
     * @param id
     * @return
     */
    public Student selectById(int id) {
        return studentMapper.selectByPrimaryKey(id);
    }
}
