package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.parking.common.feignInterfaces.AdminHandler;
import com.parking.common.pojo.AuthorityBean;
import com.project.bean.ComplainBean;
import com.project.service.IComplainService;

/**
 * 投诉处理Controller
 * 
 * @author YuChen
 *
 */
@Controller
@RequestMapping("/complain")
public class ComplainController {
    @Autowired
    private IComplainService complainService;
    
    @Autowired
    private AdminHandler auService;
    /**
     * 更新投诉处理状态
     * 
     * @param id
     * @param status
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public int updateComplain(Integer id, Integer status, String result) {
        return complainService.updateComplainStatus(id, status, result);
    }

    /**
     * 通过id查询投诉
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ComplainBean findComplainById(@PathVariable("id") Integer id) {
        return complainService.findComplainById(id);
    }

    /**
     * 根据投诉处理状态分页查询投诉
     * 
     * @param status 投诉处理状态
     * @param page   页数
     * @param size   每页数量
     * @return
     */
    @RequestMapping(value = "/status/{status}/page/{page}/size/{size}", method = RequestMethod.GET)
    @ResponseBody
    public List<ComplainBean> findComplainByStatusAndPage(@PathVariable("status") Integer status,
            @PathVariable("page") Integer page, @PathVariable("size") Integer size) {
    	System.out.println(complainService.findComplainByStatusAndPage(status, page, size));
        return complainService.findComplainByStatusAndPage(status, page, size);
    }

    /**
     * 添加投诉
     * 
     * @param complain
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public int addCompalin(ComplainBean complain) {
        return complainService.addCompalin(complain);
    }

    /**
     * 删除投诉
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.DELETE)
    @ResponseBody
    public int deleteComplain(int id) {
        return complainService.deleteComplain(id);
    }

    /**
     * 根据处理状态查询投诉数量
     * 
     * @param status
     * @return
     */
    @RequestMapping(value = "/count/{status}", method = RequestMethod.GET)
    @ResponseBody
    public int getComplainNumberByStatus(@PathVariable("status") int status) {
        return complainService.findComplainNumberByStatus(status);
    }

    /**
     * 通过投诉用户id查询投诉记录
     * 
     * @param tuid
     * @return
     */
    @RequestMapping(value = "/tuid/{tuid}", method = RequestMethod.GET)
    @ResponseBody
    public List<ComplainBean> findComplainByTuid(@PathVariable("tuid") int tuId) {
        return complainService.findComplainByTuid(tuId);
    }

    /**
     * 通过被投诉用户id查询投诉记录
     * 
     * @param btuid
     * @return
     */
    @RequestMapping(value = "/btuid/{btuid}", method = RequestMethod.GET)
    @ResponseBody
    public List<ComplainBean> findComplainByBtuid(@PathVariable("btuid") int btuId) {
        return complainService.findComplainByBtuid(btuId);
    }
    //获取当前管理员权限
    @ResponseBody
    @RequestMapping(value="/getAuthority",method = RequestMethod.GET)
    public AuthorityBean getAuthority(){
    	
    	return auService.getMyAuthroity();
    }
}
