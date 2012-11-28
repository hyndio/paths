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
@Table(name="org_office")
public class Office implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private String code;
	private String name;
	private Integer parent;
	private String duty;
	private int order;

}
