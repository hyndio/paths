/**
 * @author hyd 2012-11-29 上午9:56:59 
 * @version 1.0
 */
package f.rd.paths.organization.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 人员与岗位关联：兼职岗位<br>
 * <strong>注意：一个人员可以有多个兼职岗位</strong>
 * <p>
 * 
 */
@Entity
@Table(name = "org_staffparttime")
public class StaffParttime implements JobType, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private Integer staff;
	private Integer job;

	public StaffParttime() {
		super();
	}

	public StaffParttime(Integer id, Integer staff, Integer job) {
		super();
		this.id = id;
		this.staff = staff;
		this.job = job;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
