package wzd.pkg.first;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


/**
 * 根据用户名来删除用户信息。
 * 
 * @author wzd
 *
 */
public class MybatisDelete {

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
		 * delete a row in the database 
		 * 
		 * 该方法中的参数parameter和mapper.xml中的parameterType="String"相对应。
		 * 
		 */
		int num = sqlSession.delete("test.deleteUserByUsername", "Wzd");

		System.out.println("=====delete Num: "+num+"=====");
		
		//commit
		sqlSession.commit();
		
		//release the resource
		sqlSession.close();
		
		

	}

}
