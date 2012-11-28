/**
 * @author hyd 2012-11-28 下午1:41:53 
 * @version 1.0
 */
package f.rd.paths.organization.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 人员表
 * <p>
 * 
 */
@Entity
@Table(name="org_staff")
public class Staff implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private String code;
	private String name;
	private String diff;
	private String gender;
	private Integer office;
	private String officeRoom;
	private String officeCall;
	private String mobilePhone;
	private int order;
	

}
