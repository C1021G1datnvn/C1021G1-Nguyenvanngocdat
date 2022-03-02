package repository.employee;

import model.employee.EducationDegree;

import java.util.List;

public interface IEducationDegree {
    List<EducationDegree> selectAll();
}
