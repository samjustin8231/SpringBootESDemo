package com.example.esdemo.service.impl;

import com.example.esdemo.model.AccountInfo;
import com.example.esdemo.repository.AccountInfoRepository;
import com.example.esdemo.service.ESAccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 类的实现描述：TODO 类实现描述
 *
 * @author sunyajun 2018/6/20 18:02
 */
@Service("esAccountInfoServiceImpl")
public class ESAccountInfoServiceImpl implements ESAccountInfoService {

    @Autowired
    private AccountInfoRepository elasticAccountInfoRepository;

    public AccountInfo queryAccountInfoById(String id) {
        Optional<AccountInfo> optional = elasticAccountInfoRepository.findById(id);
        return optional.get();
    }

    @Override
    public AccountInfo queryAccountInfoByName(String accountName) {
        return elasticAccountInfoRepository.findByAccountName(accountName);
    }

    @Override
    public AccountInfo add(AccountInfo accountInfo) {
        return elasticAccountInfoRepository.save(accountInfo);
    }

}
