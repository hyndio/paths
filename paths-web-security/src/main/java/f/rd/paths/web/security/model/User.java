/**
 * @author hyd 2012-11-28 下午2:12:50 
 * @version 1.0
 */
package f.rd.paths.web.security.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import f.rd.paths.web.security.extend.impl.UserDetailsImpl;

/**
 * 用户登录信息
 * <p>
 * 用来构建{@link UserDetailsImpl}
 * <p>
 * 
 */
@Entity
@Table(name = "ss3_user")
public class User implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer staff;
	private String username;
	private String password;
	private boolean enabled;
	private String online;

	public User() {
		super();
	}

	public User(Integer staff, String username, String password, boolean enabled, String online) {
		super();
		this.staff = staff;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.online = online;
	}

	public Integer getStaff() {
		return staff;
	}

	public void setStaff(Integer staff) {
		this.staff = staff;
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getOnline() {
		return online;
	}

	public void setOnline(String online) {
		this.online = online;
	}

}
