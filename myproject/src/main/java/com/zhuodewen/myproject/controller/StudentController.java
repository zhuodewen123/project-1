package com.zhuodewen.myproject.controller;

import com.zhuodewen.myproject.base.JSONResult;
import com.zhuodewen.myproject.domain.Student;
import com.zhuodewen.myproject.facade.StudentFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
}
