/**
 * @author hyd 2012-11-28 下午1:55:51 
 * @version 1.0
 */
package f.rd.paths.organization.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 岗位敬称
 * <p>
 * 
 */
@Entity
@Table(name = "org_title")
public class Title implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private String name;

	public Title() {
		super();
	}

	public Title(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
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

}
