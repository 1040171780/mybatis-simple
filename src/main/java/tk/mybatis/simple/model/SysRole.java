package tk.mybatis.simple.model;

import java.util.Date;
import java.util.List;

/**
 * 角色表
 * @author ok
 */
public class SysRole {
	/**
	 * 角色ID
	 */
	private Long id;
	/**
	 * 角色名
	 */
	private String roleName;
	/**
	 * 有效标志
	 */
	private Integer enabled;
	/**
	 * 创建人
	 */
	private String createBy;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 用户信息
	 */
	private SysUser user;

	/**
	 * 角色包含的权限列表
	 */
	List<SysPrivilege> privilegeList;

	public SysRole() {
	}

	public List<SysPrivilege> getPrivilegeList() {
		return privilegeList;
	}

	public void setPrivilegeList(List<SysPrivilege> privilegeList) {
		this.privilegeList = privilegeList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public SysUser getUser() {
		return user;
	}

	public void setUser(SysUser user) {
		this.user = user;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public Integer getEnabled(){
		return enabled;
	}
}
