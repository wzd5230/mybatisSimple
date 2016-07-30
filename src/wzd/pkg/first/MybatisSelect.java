package wzd.pkg.first;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import wzd.pkg.po.User;


/**
 * 根据用户名来查询用户信息。
 * 
 * @author wzd
 *
 */
public class MybatisSelect {

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
		 *find a row in the database 
		 * 
		 * 该命令中的参数parameter和mapper.xml中配置的parameterType="String"相同
		 * 该命令执行后返回数据的类型和mapper.xml中配置的resultType="wzd.pkg.po.User"类型相同。
		 */
		User user = sqlSession.selectOne("test.findUserByUsername", "Wzd");
		
		System.out.println(user);

		//release the resource.
		sqlSession.close();

	}

}
