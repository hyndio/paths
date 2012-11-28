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
@Table(name="org_job")
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
	

}
