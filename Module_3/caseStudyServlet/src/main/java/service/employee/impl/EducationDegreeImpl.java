package service.employee.impl;

import model.employee.EducationDegree;
import repository.employee.impl.EducationDegreeRepo;
import service.employee.IEducationDegreeService;

import java.util.List;

public class EducationDegreeImpl implements IEducationDegreeService {
    EducationDegreeRepo educationDegreeRepo = new EducationDegreeRepo();
    @Override
    public List<EducationDegree> selectAll() {
        return educationDegreeRepo.selectAll();
    }
}
