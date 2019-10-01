package com.zhuodewen.myproject.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhuodewen.myproject.domain.Student;
import com.zhuodewen.myproject.facade.StudentFacade;
import com.zhuodewen.myproject.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    /**
     * 分页查询学生列表
     * @param qo
     * @return
     */
    public PageInfo query(Student qo) {
        PageHelper.startPage(qo.getCurrentPage(),qo.getPageSize());
        List<Student> list=studentMapper.selectAll();
        return new PageInfo(list);
    }


}
