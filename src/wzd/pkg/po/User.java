package wzd.pkg.po;


/**
 * A pojo according to the data in the database.
 * 
 * @author wzd
 *
 */
public class User {
	
	private String userid = null;
	private String username = null;
	private String password = null;
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username
				+ ", password=" + password + "]";
	}
	
	

}
