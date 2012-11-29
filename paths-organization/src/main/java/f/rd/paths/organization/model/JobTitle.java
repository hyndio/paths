/**
 * @author hyd 2012-11-29 上午10:02:42 
 * @version 1.0
 */
package f.rd.paths.organization.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 岗位敬称：一个岗位有对应的一个敬称
 * <p>
 * 
 */
@Entity
@Table(name = "org_jobtitle")
public class JobTitle implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private Integer job;
	private Integer title;

	public JobTitle() {
		super();
	}

	public JobTitle(Integer job, Integer title) {
		super();
		this.job = job;
		this.title = title;
	}

	public Integer getJob() {
		return job;
	}

	public void setJob(Integer job) {
		this.job = job;
	}

	public Integer getTitle() {
		return title;
	}

	public void setTitle(Integer title) {
		this.title = title;
	}

}
