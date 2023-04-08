package jd2_Section1_Project;

public class User extends Data {

	private String password;

	private String email;

	public User(long id, String name, String password, String email) {
		super(id, name);
		this.password = password;
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [password=" + password + ", email=" + email + ", Id=" + getId() + ", Name=" + getName() + "]";
	}

	public String getPassword() {
		return password;
	}
}
