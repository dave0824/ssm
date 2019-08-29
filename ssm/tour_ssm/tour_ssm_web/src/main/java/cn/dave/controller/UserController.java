package cn.dave.controller;

import cn.dave.domain.Role;
import cn.dave.domain.UserInfo;
import cn.dave.service.UserService;
import cn.dave.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * @program: tour_ssm
 * @description:
 * @author: dave
 * @create: 2019-08-05 17:23
 **/

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    //@RolesAllowed("ADMIN")//只有admin权限的用户才可以访问这个方法，可以不写ROLE_
    public ModelAndView findAll(){

        ModelAndView mv = new ModelAndView();
        List<UserInfo> userInfoList = userService.findAll();
        mv.addObject("userList",userInfoList);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/save")
    public String save(UserInfo userInfo){
        userInfo.setId(CommonUtils.getUuid());
        userService.save(userInfo);
        return "redirect:findAll";
    }

    @RequestMapping("/findById")
    //@Secured("ROLE_ADMIN")//只有admin权限的用户才能访问，必须写ROLE_
    public ModelAndView findById(String id){

        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;
    }

    /**
     * 添加角色
     * @param id
     * @return
     */
    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(String id){

        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        mv.addObject("user",userInfo);
        List<Role> roles = userService.showNotHasRoles(id);
        mv.addObject("roleList",roles);
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(@RequestParam(name = "userId",required = true) String userId,@RequestParam(name = "ids",required = true) List<String> ids){

        userService.addRoleToUser(userId,ids);

        return "redirect:findAll";
    }
}
