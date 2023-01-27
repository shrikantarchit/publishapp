package publishapp.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import publishapp.entity.Event;
import publishapp.util.MyBatisUtil;
@Repository
public class EventMapper {
	public void saveEvent(Event event){
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.insert("insertEvent", event);
		session.commit();
		session.close();
	}
	
}
