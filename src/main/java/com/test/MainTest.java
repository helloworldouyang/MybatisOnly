package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dao.IUserDao;
import com.entity.User;
import com.util.ConnectionFactory;



/**
 * 简单教程链接：http://eassen.iteye.com/blog/1399002
 * @author Administrator
 *
 */
public class MainTest {
	
	
	
	//获取sql会话工厂
		/*public static SqlSessionFactory getSqlSessionFactory() throws IOException{
			SqlSessionFactory sqlsf = null;
			Reader reader = null;// 配置文件字符输入流
			reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlsf = new SqlSessionFactoryBuilder().build(reader);
			return sqlsf;
		}
		//获取一个sql会话
		public static SqlSession getConnection(boolean flag){
			SqlSessionFactory sqlsf = null;
			try {
				sqlsf = getSqlSessionFactory();
			} catch (IOException e) {
				System.out.println("连接数据库失败");
				e.printStackTrace();
				return null;
			}
			SqlSession sqlsession = null;
			sqlsession = sqlsf.openSession(flag);
			return sqlsession;
		}
*/
	
	public static void main(String[] args) {
		/*SqlSession sqlSession= getConnection(true);
		try {
			User user=sqlSession.selectOne("getInfo",1);
			sqlSession.clearCache();
			System.out.println("user:"+user.getAge());
			
		} finally {
			// TODO: handle finally clause
			sqlSession.close();
		}*/
		
		try {
            IUserDao iUserDao=ConnectionFactory.getMapper(com.dao.IUserDao.class);
			User user=iUserDao.getInfo(1);
			System.out.println("user:"+user.getUser_name());
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}finally{
			ConnectionFactory.close();
		}
			
		
	}
}
