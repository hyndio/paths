/**
 * @author hyd 2012-11-28 下午1:49:02 
 * @version 1.0
 */
package f.rd.paths.organization.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 机构（部门）
 * <p>
 * 
 */
@Entity
@Table(name = "org_office")
public class Office implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private String code;
	private String name;
	private Integer parent;
	private String duty;
	private int order;

	public Office() {
		super();
	}

	public Office(Integer id, String code, String name, Integer parent,
			String duty, int order) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.parent = parent;
		this.duty = duty;
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

	public Integer getParent() {
		return parent;
	}

	public void setParent(Integer parent) {
		this.parent = parent;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

}
