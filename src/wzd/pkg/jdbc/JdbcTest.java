package wzd.pkg.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



/**
 * 一个简单的jdbc程序。
 * @author wzd
 *
 * 一、jdbc中存在的问题
 * 1.将sql语句硬编码到java代码。不利于系统的维护。比如更改sql系统、更改select语句中检索的条目。
 *		s:将sql单独抽取出来，在配置文件（xml方式、properties文件中）。
 * 2.数据库连接获取使用后立即关闭，数据库连接不能重复利用，对数据库资源是一种给浪费。
 * 		s:连接池的概念，使用数据库连接池管理数据库连接，重复利用数据库连接。
 * 3.项statement中设置参数时，存在硬编码不利于系统维护。
 * 		s:是否能够将java对象的值设置到Statement
 * 4.遍历ResultSet查询结果。硬编码。
 * 		s:能否自动将sql查询结果集转成java对象。
 *
 *
 */
public class JdbcTest {

	private static String sql = "select * from user where userid=?";
	
	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement preparedStatement = null; 
		ResultSet resultSet = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema", "root", "123456");
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, "wzd_id");
			
			resultSet = preparedStatement.executeQuery();


		
			while(resultSet.next()){
				String userid = resultSet.getString("userid");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				
				System.out.println("id: "+userid);
				System.out.println("name: "+username);
				System.out.println("password: "+password);
			}

			resultSet.close();
			preparedStatement.close();
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
