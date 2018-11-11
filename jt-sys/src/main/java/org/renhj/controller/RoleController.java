package org.renhj.controller;

import org.renhj.common.Result;
import org.renhj.entity.SysRole;
import org.renhj.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @RequestMapping("/list")
    @ResponseBody
    public List<SysRole> list(){
        return sysRoleService.findAllRoles();
    }

    @RequestMapping("/")
    public String role(){
        System.out.println("RoleController.role");
        return "sys/index";
    }

    @RequestMapping("/role_table")
    public String role_table(){
        return "sys/_table";
    }

    @RequestMapping("/deleteRole")
    @ResponseBody
    public Result<Integer> role_delete(@RequestParam("checkedId") Integer id){
        System.out.println(id);
        int ids = sysRoleService.deleteRoleById(id);
        return new Result<Integer>(ids);
    }
    @RequestMapping(value = "/deleteRoleAll", method = RequestMethod.POST)
    @ResponseBody
    public Result<Object> roleAll_delete(@RequestParam(value = "checkedIds", required = false) Integer[] checkedIds){
        int ids = sysRoleService.deleteAllByIds(checkedIds);
        Result<Object> result = new Result<>();
        if (ids>0){

            result.setData(ids);
        }else {
            result.setCode(500);
            result.setMessage("未知错误!");
        }
        return result;
    }

    @RequestMapping(value = "/addRole", method = RequestMethod.POST)
    @ResponseBody
    public Result<Object>  addRole(String name, String note){
        try {
            System.out.println(name);
            System.out.println(note);
            SysRole role = new SysRole();
            role.setName(name);
            role.setNote(note);
            role.setCreateTime(new Date());
            role.setCreateUser("admin");
            role.setUpdateTime(new Date());
            role.setUpdateUser("admin");
            int row = sysRoleService.insertRole(role);
            return new Result<>(row);
        } catch (Exception e){
            Result<Object> result = new Result<>();
            result.setCode(500);
            result.setMessage(e.getMessage());
            return result;
        }
    }
    @RequestMapping(value = "/addRoleUI")
    public String addRoleUI(){
        return "sys/_addRole";
    }
}
