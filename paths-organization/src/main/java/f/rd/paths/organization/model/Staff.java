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
@Table(name = "org_staff")
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

	public Staff() {
		super();
	}

	public Staff(Integer id, String code, String name, String diff,
			String gender, Integer office, String officeRoom,
			String officeCall, String mobilePhone, int order) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.diff = diff;
		this.gender = gender;
		this.office = office;
		this.officeRoom = officeRoom;
		this.officeCall = officeCall;
		this.mobilePhone = mobilePhone;
		this.order = order;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiff() {
		return diff;
	}

	public void setDiff(String diff) {
		this.diff = diff;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getOffice() {
		return office;
	}

	public void setOffice(Integer office) {
		this.office = office;
	}

	public String getOfficeRoom() {
		return officeRoom;
	}

	public void setOfficeRoom(String officeRoom) {
		this.officeRoom = officeRoom;
	}

	public String getOfficeCall() {
		return officeCall;
	}

	public void setOfficeCall(String officeCall) {
		this.officeCall = officeCall;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

}
