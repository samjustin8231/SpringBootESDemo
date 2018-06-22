package com.example.esdemo;

import com.example.esdemo.model.*;
import com.example.esdemo.repository.AccountInfoRepository;
import com.example.esdemo.repository.ArticleSearchRepository;
import com.example.esdemo.repository.UserRepository;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsdemoApplicationTests {

    @Autowired
    private ArticleSearchRepository articleSearchRepository;

    @Autowired
    private AccountInfoRepository accountInfoRepository;

    @Autowired
    private UserRepository userRepository;


    @Test
    public void contextLoads() {
    }

    @Test
    public void testSaveArticleIndex() {
        Author author = new Author();
        author.setId(1L);
        author.setName("tianshouzhi");
        author.setRemark("java developer");

        Tutorial tutorial = new Tutorial();
        tutorial.setId(1L);
        tutorial.setName("elastic search");

        Article article = new Article();
        article.setId(1L);
        article.setTitle("springboot integreate elasticsearch");
        article.setAbstracts("springboot integreate elasticsearch is very easy");
        article.setTutorial(tutorial);
        article.setAuthor(author);
        article.setContent("elasticsearch based on lucene,"
                + "spring-data-elastichsearch based on elaticsearch"
                + ",this tutorial tell you how to integrete springboot with spring-data-elasticsearch");
        article.setPostTime(new Date());
        article.setClickCount(1L);

        articleSearchRepository.save(article);
    }

    @Test
    public void testAddAccountInfo() {
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setId("1");
        accountInfo.setAccountName("sunyajun");
        accountInfo.setNickName("sam");
        accountInfoRepository.save(accountInfo);
    }

    @Test
    public void testFindAllAccountInfos() {
        Iterable<AccountInfo> iterable = accountInfoRepository.findAll();
        Iterator<AccountInfo> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            AccountInfo accountInfo = iterator.next();
            System.out.println(accountInfo);
        }
    }

    @Test
    public void testAddUser() {
        for (int i = 0; i < 10; i++) {
            UserInfo user = new UserInfo();
            user.setId((long) i);
            user.setAge(i);
            user.setUsername("sam" + i);
            user.setRealname("sunyajun" + i);
            userRepository.save(user);
        }
    }

    @Test
    public void testFindAllUsers() {
        Iterable<UserInfo> iterable = userRepository.findAll();
        Iterator<UserInfo> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            UserInfo accountInfo = iterator.next();
            System.out.println(accountInfo);
        }
    }

    @Test
    public void testQueryBuilder() {
        //创建builder
        BoolQueryBuilder builder = QueryBuilders.boolQuery();
        //builder下有must、should以及mustNot 相当于sql中的and、or以及not
        //设置模糊搜索,真实姓名中包含金的用户
        builder.must(QueryBuilders.fuzzyQuery("realname", "sunyajun1"));
        //设置用户名为king
        builder.must(new QueryStringQueryBuilder("sam1").field("username"));

        //排序
        FieldSortBuilder sort = SortBuilders.fieldSort("age").order(SortOrder.DESC);

        //设置分页
        //====注意!es的分页和Hibernate一样api是从第0页开始的=========
        PageRequest page = new PageRequest(0, 2);

        //构建查询
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        //将搜索条件设置到构建中
        nativeSearchQueryBuilder.withQuery(builder);
        //将分页设置到构建中
        nativeSearchQueryBuilder.withPageable(page);
        //将排序设置到构建中
        nativeSearchQueryBuilder.withSort(sort);
        //生产NativeSearchQuery
        NativeSearchQuery query = nativeSearchQueryBuilder.build();

        //执行,返回包装结果的分页
        Page<UserInfo> resutlList = userRepository.search(query);
        System.out.println(resutlList);
    }

    @Test
    public void testFindByAgeBetween() {
        List<UserInfo> list = userRepository.findByAgeBetween(3, 5);
        for (UserInfo user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void testQuartz() throws Exception {

    }

}
