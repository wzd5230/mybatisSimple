package wzd.pkg.first;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import wzd.pkg.po.User;



/**
 * 插入一条用户信息到数据库。
 * 
 * @author wzd
 *
 */
public class MybatisInsert {

	public static void main(String[] args) {
		
		String resource = "SqlMapConfig.xml";
		
		InputStream inputStream = null;
		
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();

		
		/*
		 * insert a row into the database 
		 * 
		 * 该命令中的参数parameter和mapper.xml中配置的parameterType="wzd.pkg.po.User"相同
		 */
		User user = new User();
		user.setUserid("0908360");
		user.setUsername("wzd5230");
		user.setPassword("password0908360");
		
		int num = sqlSession.insert("test.insertUser", user);
		
		System.out.println("Affect rows: "+num);
		
		//commit
		sqlSession.commit();
		
		//release source.
		sqlSession.close();

	}

}
