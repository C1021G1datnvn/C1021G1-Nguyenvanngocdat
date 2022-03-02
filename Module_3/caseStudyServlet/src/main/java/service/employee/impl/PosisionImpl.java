package service.employee.impl;

import model.employee.Posision;
import repository.employee.impl.PositionRepo;
import service.employee.IPosisionService;

import java.util.List;

public class PosisionImpl implements IPosisionService {
    PositionRepo positionRepo = new PositionRepo();
    @Override
    public List<Posision> selectAll() {
        return positionRepo.selectAll();
    }
}
