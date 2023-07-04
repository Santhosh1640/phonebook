package co.santhu.phonebook.dao;

import java.awt.geom.CubicCurve2D;
import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public final class DaoFactory {
	
	private DaoFactory() {
		
	}
	
	private static SqlSession createSession() throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession(true);
		
		return session;
	}
	
	public static UserDao getUserDao() throws IOException {		
		return createSession().getMapper(UserDao.class);
	}
	
	public static ContactDao getContactDao() throws IOException {
		return createSession().getMapper(ContactDao.class);
	}
}
