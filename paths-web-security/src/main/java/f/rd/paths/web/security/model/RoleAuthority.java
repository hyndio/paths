/**
 * @author hyd 2012-11-29 上午10:19:03 
 * @version 1.0
 */
package f.rd.paths.web.security.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 角色与权限关联：一个角色可以与多个权限关联
 * <p>
 * 
 */
@Entity
@Table(name = "ss3_role_auth")
public class RoleAuthority implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private Integer role;
	private Integer authority;

	public RoleAuthority() {
		super();
	}

	public RoleAuthority(Integer id, Integer role, Integer authority) {
		super();
		this.id = id;
		this.role = role;
		this.authority = authority;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public Integer getAuthority() {
		return authority;
	}

	public void setAuthority(Integer authority) {
		this.authority = authority;
	}

}
