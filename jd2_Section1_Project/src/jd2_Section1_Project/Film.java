package jd2_Section1_Project;

import java.util.Arrays;

public class Film extends Data {
	private final String director;
	private final String[] actors;
	private MovieType movieType;
	private String description;
	private final String releaseDate;

	public Film(long id, String name, String director, String[] actors, MovieType movieType, String description,
			String releaseDate) {
		super(id, name);
		this.director = director;
		this.actors = actors;
		this.movieType = movieType;
		this.description = description;
		this.releaseDate = releaseDate;
	}

	@Override
	public String toString() {
		return "Film [director=" + director + ", actors=" + Arrays.toString(actors) + ", movieType=" + movieType
				+ ", description=" + description + ", releaseDate=" + releaseDate + ", Id()=" + getId() + ", Name()="
				+ getName() + "]";
	}
}
