package bean;

import java.util.Set;

public class Actor {

	
	private int aid;
	private String aname;
	private Set <Movies> movies;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public Set<Movies> getMovies() {
		return movies;
	}
	public void setMovies(Set<Movies> movies) {
		this.movies = movies;
	}
	
	
}
