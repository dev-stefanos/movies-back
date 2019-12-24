package movies;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;

public class MovieServiceImpl {

	private final static Logger s_logger;
	private final static String LOGFILE = "z_log.txt";
	
	static {
		s_logger = Logger.getLogger(MovieServiceImpl.class.getName());
		s_logger.setLevel(Level.INFO);
		try {
			FileHandler fileTxt = new FileHandler(LOGFILE);
			s_logger.addHandler(fileTxt);
			System.out.println("logger created successfully: " + LOGFILE);
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static List<Movie> getMovies()
	{
		List<Movie> movies = new ArrayList<>();
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			movies = HibernateUtil.loadAllData(Movie.class, session);
		}
		catch(Exception e) {
			s_logger.info(e.getMessage());
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return movies;
	}
	
	
	public static Movie getMovie(long movieId)
	{
		Movie saved = new Movie();
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			saved = session.get(Movie.class, movieId);
		}
		catch(Exception e) {
			s_logger.info(e.getMessage());
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return saved;
	}
	
	
	public static Movie saveMovie(Movie movie)
	{
		Movie saved = new Movie();
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(movie);
			session.getTransaction().commit();
			saved = session.get(Movie.class, movie.getMovieId());
			
		}
		catch(Exception e) {
			s_logger.info(e.getMessage());
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return saved;
	}
	
}
