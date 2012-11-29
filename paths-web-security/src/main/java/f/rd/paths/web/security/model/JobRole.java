/**
 * @author hyd 2012-11-29 上午10:15:56 
 * @version 1.0
 */
package f.rd.paths.web.security.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 岗位与角色关联：一个岗位可以跟多个角色关联
 * <p>
 * 
 */
@Entity
@Table(name = "ss3_job_role")
public class JobRole implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private Integer id;
	private Integer job;
	private Integer role;

	public JobRole() {
		super();
	}

	public JobRole(Integer id, Integer job, Integer role) {
		super();
		this.id = id;
		this.job = job;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getJob() {
		return job;
	}

	public void setJob(Integer job) {
		this.job = job;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

}
