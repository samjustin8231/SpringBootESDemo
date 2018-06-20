package com.example.esdemo.repository;

import com.example.esdemo.model.AccountInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 类的实现描述：TODO 类实现描述
 *
 * @author sunyajun 2018/6/20 18:00
 */
public interface AccountInfoRepository extends ElasticsearchRepository<AccountInfo,String> {
    //TODO define the search
    AccountInfo findByAccountName(String accountName);
}

