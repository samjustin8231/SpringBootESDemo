package com.example.esdemo.controller;

import com.example.esdemo.model.AccountInfo;
import com.example.esdemo.service.ESAccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 类的实现描述：TODO 类实现描述
 *
 * @author sunyajun 2018/6/20 18:04
 */
@Controller
public class AccountInfoController {

    @Autowired
    private ESAccountInfoService esAccountInfoServiceImpl;

    @RequestMapping("/esAccountInfo")
    public String queryAccountInfo(String id, ModelMap modelMap){

        AccountInfo accountInfo = esAccountInfoServiceImpl.queryAccountInfoById(id);
        modelMap.addAttribute("esAccountInfo",accountInfo);
        modelMap.addAttribute("test_elastic","Test the elasticsearch");

        return "accountInfo";
    }

    @RequestMapping("/esAccountInfoName")
    public String queryAccountInfoByAccountName(String accountName, ModelMap modelMap){

        AccountInfo accountInfo = esAccountInfoServiceImpl.queryAccountInfoByName(accountName);
        modelMap.addAttribute("esAccountInfo",accountInfo);
        modelMap.addAttribute("test_elastic","Test the elasticsearch");

        return "accountInfo";
    }

}
