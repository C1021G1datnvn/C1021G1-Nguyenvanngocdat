package service.service.impl;

import model.service.RentType;
import repository.service.IRentType;
import repository.service.impl.RentTypeRepo;
import service.service.IRentTypeService;

import java.util.List;

public class RentTypeService implements IRentTypeService {
    RentTypeRepo rentTypeRepo = new RentTypeRepo();
    @Override
    public List<RentType> selectAllService() {
        return rentTypeRepo.selectAllService();
    }
}
