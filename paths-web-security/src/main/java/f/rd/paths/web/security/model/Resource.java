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
@Table(name = "ss3_resource")
public class Resource implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private String name;
	private String uri;
	private Integer parent;
	private int order;

	public Resource() {
		super();
	}

	public Resource(Integer id, String name, String uri, Integer parent,
			int order) {
		super();
		this.id = id;
		this.name = name;
		this.uri = uri;
		this.parent = parent;
		this.order = order;
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

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Integer getParent() {
		return parent;
	}

	public void setParent(Integer parent) {
		this.parent = parent;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

}
