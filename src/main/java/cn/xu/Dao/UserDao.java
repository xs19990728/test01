package cn.xu.Dao;

import cn.xu.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    @Select("select * from User where username=#{username}")
    User queryUserByName(String username);
    @Insert("insert into User(username,upwd) values(#{username},#{upwd})")
    void addUser(User user);
}
