package com.example.esdemo.service;

import com.example.esdemo.model.AccountInfo;

/**
 * 类的实现描述：TODO 类实现描述
 *
 * @author sunyajun 2018/6/20 18:01
 */
public interface ESAccountInfoService {
    AccountInfo queryAccountInfoById(String id);

    AccountInfo queryAccountInfoByName(String accountName);

    AccountInfo add(AccountInfo accountInfo);
}
