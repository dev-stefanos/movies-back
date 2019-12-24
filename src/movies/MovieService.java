package movies;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/MovieService")
public class MovieService {

	@GET
	@Path("/movies")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Movie> getMovies() 
	{
		return MovieServiceImpl.getMovies();
	}
	
	@GET
	@Path("/movie/{movieId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Movie getMovie(@PathParam("movieId") long movieId)
	{
		return MovieServiceImpl.getMovie(movieId);
	}
	
	@POST
	@Path("/save")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Movie saveMovie(Movie movie)
	{
		return MovieServiceImpl.saveMovie(movie);
	}
	
}
