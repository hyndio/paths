/**
 * @author hyd 2012-11-28 下午2:08:45 
 * @version 1.0
 */
package f.rd.paths.web.security.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/** 
 * 资源
 * <p>
 *  
 */
@Entity
@Table(name="ss3_resource")
public class Resource implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private String name;
	private String uri;
	private Integer parent;
	private int order;

}
