package jd2_Section1_Project;

public abstract class Data {
	private final long id;

	private String name;

	public Data(long id, String name) {
		this.id = id;
		this.name = name;
	}
	public long getId() {
	    return id;
	  }

	  public String getName() {
	    return name;
	  }
}
