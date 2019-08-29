package cn.dave.controller;

import cn.dave.domain.Permission;
import cn.dave.service.IPermissionService;
import cn.dave.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: tour_ssm
 * @description:
 * @author: dave
 * @create: 2019-08-05 19:36
 **/

@RequestMapping("/permission")
@Controller
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){

        ModelAndView mv = new ModelAndView();
        List<Permission> permissionList = permissionService.findAll();
        mv.addObject("permissionList",permissionList);
        mv.setViewName("permission-list");
        return mv;
    }

    @RequestMapping("/save")
    public String save(Permission permission){

        permission.setId(CommonUtils.getUuid());
        permissionService.save(permission);
        return "redirect:findAll";
    }
}
