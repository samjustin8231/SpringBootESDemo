package com.example.esdemo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

/**
 * 类的实现描述：TODO 类实现描述
 *
 * @author sunyajun 2018/6/20 17:58
 */
@Document(indexName = "cwenao", type = "accountinfo", shards = 1, replicas = 0, refreshInterval = "-1")
public class AccountInfo {

    @Id
    private String id;
    @Field
    private String accountName;
    @Field
    private String nickName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
                "id='" + id + '\'' +
                ", accountName='" + accountName + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
