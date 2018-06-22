package com.example.esdemo.repository;

import com.example.esdemo.model.UserInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

/**
 * 类的实现描述：TODO 类实现描述
 *
 * @author sunyajun 2018/6/21 11:44
 */
public interface UserRepository extends ElasticsearchRepository<UserInfo, Long> {
    /**
     * 查询用户名为username的用户
     * @param username
     * @return
     */
    List<UserInfo> findByUsername(String username);

    /**
     * 查询用户名为username并且真实姓名为realname的用户
     * @param username
     * @param realname
     */
    List<UserInfo> findByUsernameAndRealname(String username, String realname);

    /**
     * 查询用户名为username或者姓名为realname的用户
     */
    List<UserInfo> findByUsernameOrRealname(String username, String realname);

    /**
     * 查询用户名不是username的所有用户
     * @param username
     * @return
     */
    List<UserInfo> findByUsernameNot(String username);


    /**
     * 查询年龄段为ageFrom到ageTo的用户
     * @param ageFrom
     * @param ageTo
     * @return
     */
    List<UserInfo> findByAgeBetween(Integer ageFrom, Integer ageTo);

    /**
     * 查询生日小于birthTo的用户
     */
    List<UserInfo> findByBirthLessThan(LocalDateTime birthTo);


    /**
     * 查询生日段大于birthFrom的用户
     * @param birthFrom
     * @return
     */
    List<UserInfo> findByBirthGreaterThan(LocalDateTime birthFrom);

    /**
     * 查询年龄小于或等于ageTo的用户
     */
    List<UserInfo> findByAgeBefore(Integer ageTo);

    /**
     * 查询年龄大于或等于ageFrom的用户
     * @param ageFrom
     * @return
     */
    List<UserInfo> findByAgeAfter(Integer ageFrom);

    /**
     * 用户名模糊查询
     * @param username
     * @return
     */
    List<UserInfo> findByUsernameLike(String username);


    /**
     * 查询以start开头的用户
     * @param start
     * @return
     */
    List<UserInfo> findByUsernameStartingWith(String start);

    /**
     * 查询以end结尾的用户
     * @return
     */
    List<UserInfo> findByUsernameEndingWith(String end);

    /**
     * 查询用户名包含word的用户
     * @param word
     * @return
     */
    List<UserInfo> findByUsernameContaining(String word);

    /**
     * 查询名字属于usernames中的用户
     * @param usernames
     * @return
     */
    List<UserInfo> findByUsernameIn(Collection<String> usernames);

    /**
     * 查询名字不属于usernames中的用户
     * @param usernames
     * @return
     */
    List<UserInfo> findByUsernameNotIn(Collection<String> usernames);

    /**
     *最后来个复杂点的：查询年龄小于ageTo,姓名以start开头，id大于idTo的用户，并且按照年龄倒序
     * @return
     */
    List<UserInfo> findByAgeBeforeAndUsernameStartingWithAndIdGreaterThanOrderByAgeDesc(Integer ageTo, String start, Long idTo);
}
