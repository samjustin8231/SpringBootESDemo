package com.example.esdemo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDateTime;

/**
 * 类的实现描述：TODO 类实现描述
 *
 * @author sunyajun 2018/6/21 11:42
 */
@Data  //lombok注解，会自动生成setter/getter,需要引入lombok的包才能使用。
@Document(indexName = "shop", type = "user", refreshInterval = "0s")
public class User {

    @Id
    private Long id;

    private String username;

    private String realname;

    private String password;

    private Integer age;

    //这三个注解是为了前台序列化java8 LocalDateTime使用的，需要引入jsr310的包才可以使用
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime birth;

}
