package com.example.esdemo.repository;

import com.example.esdemo.model.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 类的实现描述：TODO 类实现描述
 *
 * @author sunyajun 2018/6/19 10:52
 */
//泛型的参数分别是实体类型和主键类型
public interface ArticleSearchRepository extends ElasticsearchRepository<Article, Long> {

    Article queryById(Long id);
}
