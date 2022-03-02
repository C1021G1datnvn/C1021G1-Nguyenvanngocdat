package service.employee.impl;

import model.employee.Division;
import repository.employee.impl.DivisionRepo;
import service.employee.IDivisionService;

import java.util.List;

public class DivisionImpl implements IDivisionService {
    DivisionRepo divisionRepo = new DivisionRepo();
    @Override
    public List<Division> selectAll() {
        return divisionRepo.selectAll();
    }
}
