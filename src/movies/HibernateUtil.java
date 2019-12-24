package movies;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	private static SessionFactory s_sessionFactory;
	
	static 
	{
		StandardServiceRegistry registry = null;
		try {
			registry = new StandardServiceRegistryBuilder().configure().build();
			s_sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} 
		catch (Exception ex) {
			//TODO: log
			System.err.println(ex.getMessage());
			ex.printStackTrace();
			if (registry != null) {
				StandardServiceRegistryBuilder.destroy(registry);
			}
		}
	}
	
	
	public static SessionFactory getSessionFactory() 
	{
		return s_sessionFactory;
	}
	
	
	public static <T> List<T> loadAllData(Class<T> type, Session session) 
	{
	    CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<T> criteria = builder.createQuery(type);
	    criteria.from(type);
	    List<T> data = session.createQuery(criteria).getResultList();
	    return data;
	}
	
}//class
