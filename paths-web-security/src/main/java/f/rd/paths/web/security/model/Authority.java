/**
 * @author hyd 2012-11-28 下午2:07:06 
 * @version 1.0
 */
package f.rd.paths.web.security.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 权限
 * <p>
 * 
 */
@Entity
@Table(name = "ss3_authority")
public class Authority implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private String code;
	private String name;
	private int order;

	public Authority() {
		super();
	}

	public Authority(Integer id, String code, String name, int order) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.order = order;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
