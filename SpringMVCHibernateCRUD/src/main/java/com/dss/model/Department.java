/**
 * 
 */
package com.dss.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author ADMIN
 *
 */
@Entity
@Table(name="DEP_TBL")
public class Department{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long depId;
    
    @Column
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="id")
    private List<Employee> empList;

    public Long getDepId() {
        return depId;
    }

    public void setDepId(Long depId) {
        this.depId = depId;
    }

   
    public List<Employee> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Employee> empList) {
        this.empList = empList;
    }
    
    
    
    

}
