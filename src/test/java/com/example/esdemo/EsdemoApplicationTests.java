package com.example.esdemo;

import com.example.esdemo.model.AccountInfo;
import com.example.esdemo.model.Article;
import com.example.esdemo.model.Author;
import com.example.esdemo.model.Tutorial;
import com.example.esdemo.repository.AccountInfoRepository;
import com.example.esdemo.repository.ArticleSearchRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Iterator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsdemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private ArticleSearchRepository articleSearchRepository;

    @Autowired
    private AccountInfoRepository accountInfoRepository;

    @Test
    public void testSaveArticleIndex(){
        Author author=new Author();
        author.setId(1L);
        author.setName("tianshouzhi");
        author.setRemark("java developer");

        Tutorial tutorial=new Tutorial();
        tutorial.setId(1L);
        tutorial.setName("elastic search");

        Article article =new Article();
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
    public void testAddAccountInfo(){
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setId("1");
        accountInfo.setAccountName("sunyajun");
        accountInfo.setNickName("sam");
        accountInfoRepository.save(accountInfo);
    }

    @Test
    public void testFindAllAccountInfos(){
        Iterable<AccountInfo> iterable = accountInfoRepository.findAll();
        Iterator<AccountInfo> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            AccountInfo accountInfo = iterator.next();
            System.out.println(accountInfo);
        }
    }
}
