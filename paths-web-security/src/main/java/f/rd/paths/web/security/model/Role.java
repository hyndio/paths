/**
 * @author hyd 2012-11-28 下午2:11:07 
 * @version 1.0
 */
package f.rd.paths.web.security.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 角色
 * <p>
 * 
 */
@Entity
@Table(name = "ss3_role")
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private String name;
	private int order;

	public Role() {
		super();
	}

	public Role(Integer id, String name, int order) {
		super();
		this.id = id;
		this.name = name;
		this.order = order;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

}
