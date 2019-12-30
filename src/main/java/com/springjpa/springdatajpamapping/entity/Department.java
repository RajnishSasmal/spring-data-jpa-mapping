package com.springjpa.springdatajpamapping.entity;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@Entity
@Table(name = "department")
public class Department implements Serializable {


    /**
	 * 
	 */
	private static final long serialVersionUID = -1539457541862849625L;
	@Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    @Column(name = "dept_id")
    private int deptId;
    @Column(name = "dept_name")
    private String deptName;
    @Column(name = "description")
    private String description;
    @OneToMany(targetEntity = Employee.class,cascade = CascadeType.ALL)
    @JoinColumn(name="department_dept_id", referencedColumnName = "dept_id")
    private List<Employee> employees;

    public Department() {
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", description='" + description + '\'' +
                ", employees=" + employees +
                '}';
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + deptId;
		result = prime * result + ((deptName == null) ? 0 : deptName.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((employees == null) ? 0 : employees.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (deptId != other.deptId)
			return false;
		if (deptName == null) {
			if (other.deptName != null)
				return false;
		} else if (!deptName.equals(other.deptName))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (employees == null) {
			if (other.employees != null)
				return false;
		} else if (!employees.equals(other.employees))
			return false;
		return true;
	}
    
    
}
