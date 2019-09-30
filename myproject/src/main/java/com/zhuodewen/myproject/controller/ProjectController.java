package com.zhuodewen.myproject.controller;

import com.zhuodewen.myproject.base.JSONResult;
import com.zhuodewen.myproject.domain.Project;
import com.zhuodewen.myproject.facade.ProjectFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 课程相关控制器
 */
@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectFacade projectFacade;

    /**
     * 根据id查询课程对象
     * @param id
     * @return
     */
    @RequestMapping("selectById")
    @ResponseBody
    public JSONResult selectById(int  id){
        JSONResult jsonResult=new JSONResult();
        Project project=projectFacade.selectById(id);
        jsonResult.setResult(project);
        jsonResult.setMsg("返回成功!");
        return jsonResult;
    }
}
