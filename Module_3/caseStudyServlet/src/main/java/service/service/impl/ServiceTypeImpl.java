package service.service.impl;

import model.service.ServiceType;
import repository.service.impl.ServiceTypeRepo;
import service.service.IServiceTypeService;

import java.util.List;

public class ServiceTypeImpl implements IServiceTypeService {
    ServiceTypeRepo serviceTypeRepo = new ServiceTypeRepo();
    @Override
    public List<ServiceType> selectAllService() {
        return serviceTypeRepo.selectAllService();
    }
}
