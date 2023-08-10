package cn.space.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class mybatisTest {
    @Test
    public void testDo1() throws IOException {
        //1.加载mybatis的核心配置文件
        InputStream input=Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建一个会话工厂
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(input);
        //3.创建一个会话
        SqlSession session=factory.openSession();
        //4.执行sql语句
        int count=session.selectOne("cn.space.dao.findBookCount");
        System.out.println(count);
        //5.关闭会话
        session.close();
    }
}
