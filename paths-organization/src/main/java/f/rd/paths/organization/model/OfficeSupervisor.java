/**
 * @author hyd 2012-11-29 上午9:59:39 
 * @version 1.0
 */
package f.rd.paths.organization.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 部门主管岗位<br>
 * <strong>注意：一个部门只能有一个主管岗位</strong>
 * <p>
 * 
 */
@Entity
@Table(name = "org_officesupervisor")
public class OfficeSupervisor implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private Integer office;
	private Integer job;

	public OfficeSupervisor() {
		super();
	}

	public OfficeSupervisor(Integer office, Integer job) {
		super();
		this.office = office;
		this.job = job;
	}

	public Integer getOffice() {
		return office;
	}

	public void setOffice(Integer office) {
		this.office = office;
	}

	public Integer getJob() {
		return job;
	}

	public void setJob(Integer job) {
		this.job = job;
	}

}
