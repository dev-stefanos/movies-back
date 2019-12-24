package movies;

import javax.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {
	
	private long movieId;
	private String title;
	private String director;
	private String description;
	private int released;
	
	public Movie() {
	}
	
	@Id
	@Column(name = "movieId")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	public long getMovieId() {
		return movieId;
	}
	
	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}
	
	@Column(name = "title")
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name = "director")
	public String getDirector() {
		return director;
	}
	
	public void setDirector(String director) {
		this.director = director;
	}
	
	@Column(name = "description")
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "released")
	public int getReleased() {
		return released;
	}
	
	public void setReleased(int released) {
		this.released = released;
	}
	
}
