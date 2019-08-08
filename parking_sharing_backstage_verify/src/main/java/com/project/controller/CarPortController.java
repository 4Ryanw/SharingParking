package com.project.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.project.bean.CarPortBean;
import com.project.service.ICarPortService;

/**
 * 车位审核Controller
 * 
 * @author YuChen
 *
 */
@Controller
@RequestMapping("/carport")
public class CarPortController {
    @Autowired
    private ICarPortService carPortService;

    /**
     * 通过id查询车位信息
     * 
     * @param id
     * @return CarPortBean
     */
    @RequestMapping("/{id}")
    @ResponseBody
    public CarPortBean getCarPortById(@PathVariable("id") Integer id) {
        return carPortService.findCarPortById(id);
    }

    /**
     * 更新车位状态
     * 
     * @param id
     * @param status
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public int updateCarPortStatus(Integer id, Integer status) {
        return carPortService.updateCarPortStatus(id, status);
    }

    /**
     * 通过车位审核状态获取车位集合
     * 
     * @param statues
     * @return
     */
    @RequestMapping(value = "/status/{status}", method = RequestMethod.GET)
    @ResponseBody
    public List<CarPortBean> getCarPortByStatus(@PathVariable("status") Integer statues) {
        return carPortService.findCarPortByStatus(statues);
    }

    @RequestMapping(value = "/status/{status}/page/{page}/size/{size}", method = RequestMethod.GET)
    @ResponseBody
    public List<CarPortBean> getCarPortByStatusAndPage(@PathVariable("status") Integer status,
            @PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        return carPortService.findCarPortByStatusAndPage(status, page, size);
    }

    /**
     * 通过车位审批状态查询车位
     * 
     * @param status
     * @return 车位数量
     */
    @RequestMapping(value = "/count/{status}", method = RequestMethod.GET)
    @ResponseBody
    public int getCarPortNumberByStatus(@PathVariable("status") Integer status) {
        return carPortService.findCarPortNumberByStatus(status);
    }

}
