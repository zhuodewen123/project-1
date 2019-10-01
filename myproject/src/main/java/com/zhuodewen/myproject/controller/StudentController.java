package com.zhuodewen.myproject.controller;

import com.github.pagehelper.PageInfo;
import com.zhuodewen.myproject.base.JSONResult;
import com.zhuodewen.myproject.domain.Student;
import com.zhuodewen.myproject.facade.StudentFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 学生相关控制器
 */
@Controller
@RequestMapping("/student")
@Api(value="学生查看接口",tags={"学生接口APi"})
public class StudentController {

    @Autowired
    private StudentFacade studentFacade;

    /**
     * 根据id查询学生对象
     * @param id
     * @return
     */
    @RequestMapping(value="selectById",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("根据id查询学生对象")
    public JSONResult selectById(@ApiParam(name="id",value="学生id",required=true)@RequestParam(value = "id")int  id){
        JSONResult jsonResult=new JSONResult();
        Student student=studentFacade.selectById(id);
        jsonResult.setResult(student);
        jsonResult.setMsg("返回成功!");
        return jsonResult;
    }

    /**
     * 分页查询学生列表1(PageInfo返回)
     * @return
     */
    @RequestMapping(value="list",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("分页查询学生列表")
    public PageInfo list(Student student){
        PageInfo query=studentFacade.query(student);
        return query;
    }

    /**
     * 分页查询学生列表2(返回页面+共享数据)
     * @return
     */
    @RequestMapping(value="list2",method = RequestMethod.POST)
    @ApiOperation("分页查询学生列表")
    public String list2(Student student,Model model){
        PageInfo query=studentFacade.query(student);
        model.addAttribute("query",query);
        return "student/list.do";
    }

}
