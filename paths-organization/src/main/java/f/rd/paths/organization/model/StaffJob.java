/**
 * @author hyd 2012-11-29 上午9:46:04 
 * @version 1.0
 */
package f.rd.paths.organization.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 人员与岗位关联：主要岗位<br>
 * <strong>注意：一个人员只能有一个主要岗位</strong>
 * <p>
 * 
 */
@Entity
@Table(name = "org_staffjob")
public class StaffJob implements JobType, Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private Integer staff;
	private Integer job;

	public StaffJob() {
		super();
	}

	public StaffJob(Integer staff, Integer job) {
		super();
		this.staff = staff;
		this.job = job;
	}

	public Integer getStaff() {
		return staff;
	}

	public void setStaff(Integer staff) {
		this.staff = staff;
	}

	public Integer getJob() {
		return job;
	}

	public void setJob(Integer job) {
		this.job = job;
	}

}
