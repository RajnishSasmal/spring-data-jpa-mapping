package com.springjpa.springdatajpamapping.dto;

import com.springjpa.springdatajpamapping.entity.Department;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class StudentGeneration {

    private Department dept;

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }
}
