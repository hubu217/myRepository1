package sy.pageModel;


import java.util.Date;



public class User implements java.io.Serializable {

	private String id;
	private String name;
	private String pwd;


	private Date createdatetime;
	private Date modifydatetime;

	private Date createdatetimeStart;
	private Date createdatetimeEnd;
	private Date modifydatetimeStart;
	private Date modifydatetimeEnd;

	private String roleIds;
	private String roleNames;

	private String test;


	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public Date getCreatedatetimeStart() {
		return createdatetimeStart;
//		System.out.println();
	}

/*
	public void setCreatedatetimeStart(Date createdatetimeStart) {
		this.createdatetimeStart = createdatetimeStart;
	}
*/

	public Date getCreatedatetimeEnd() {
		return createdatetimeEnd;
	}

	public void setCreatedatetimeEnd(Date createdatetimeEnd) {
		this.createdatetimeEnd = createdatetimeEnd;
	}

	public Date getModifydatetimeStart() {
		return modifydatetimeStart;
	}

	public void setModifydatetimeStart(Date modifydatetimeStart) {
		this.modifydatetimeStart = modifydatetimeStart;
	}

	public Date getModifydatetimeEnd() {
		return modifydatetimeEnd;
	}

	public void setModifydatetimeEnd(Date modifydatetimeEnd) {
		this.modifydatetimeEnd = modifydatetimeEnd;
	}

	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	/*public String getRoleNames() {
		return roleNames;
	}*/

	public void setRoleNames(String roleNames) {
		this.roleNames = roleNames;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Date getCreatedatetime() {
		return createdatetime;
	}

	public void setCreatedatetime(Date createdatetime) {
		this.createdatetime = createdatetime;
	}

	public Date getModifydatetime() {
		return modifydatetime;
	}

	public void setModifydatetime(Date modifydatetime) {
		this.modifydatetime = modifydatetime;
	}



	public static void main(String[] args) {

        	System.out.println("User.java");


	}


	@Override
	public String toString() {
		return "User{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", pwd='" + pwd + '\'' +
				", createdatetime=" + createdatetime +
				", modifydatetime=" + modifydatetime +
				", createdatetimeStart=" + createdatetimeStart +
				", createdatetimeEnd=" + createdatetimeEnd +
				", modifydatetimeStart=" + modifydatetimeStart +
				", modifydatetimeEnd=" + modifydatetimeEnd +
				", roleIds='" + roleIds + '\'' +
				", roleNames='" + roleNames + '\'' +
				", test='" + test + '\'' +
				'}';
	}
}
