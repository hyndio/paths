/**
 * @author hyd 2012-11-28 下午1:51:46 
 * @version 1.0
 */
package f.rd.paths.organization.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 岗位
 * <p>
 * 
 */
@Entity
@Table(name = "org_job")
public class Job implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private String code;
	private String name;
	private Integer office;
	private Integer parent;
	private int level;
	private String duty;
	private int order;

	public Job() {
		super();
	}

	public Job(Integer id, String code, String name, Integer office,
			Integer parent, int level, String duty, int order) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.office = office;
		this.parent = parent;
		this.level = level;
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

	public Integer getOffice() {
		return office;
	}

	public void setOffice(Integer office) {
		this.office = office;
	}

	public Integer getParent() {
		return parent;
	}

	public void setParent(Integer parent) {
		this.parent = parent;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
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
