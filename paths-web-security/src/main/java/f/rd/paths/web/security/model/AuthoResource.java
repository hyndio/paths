/**
 * @author hyd 2012-11-29 上午10:22:10 
 * @version 1.0
 */
package f.rd.paths.web.security.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 权限与资源关联：一个权限可以与多个资源关联
 * <p>
 * 
 */
@Entity
@Table(name = "ss3_auth_reso")
public class AuthoResource implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private Integer id;
	private Integer authority;
	private Integer resource;

	public AuthoResource() {
		super();
	}

	public AuthoResource(Integer id, Integer authority, Integer resource) {
		super();
		this.id = id;
		this.authority = authority;
		this.resource = resource;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAuthority() {
		return authority;
	}

	public void setAuthority(Integer authority) {
		this.authority = authority;
	}

	public Integer getResource() {
		return resource;
	}

	public void setResource(Integer resource) {
		this.resource = resource;
	}

}
