package service.service.impl;

import model.service.Service;
import repository.service.impl.ServiceRepo;
import service.service.IServiceService;

import java.util.List;

public class ServiceImpl implements IServiceService {
    ServiceRepo serviceRepo = new ServiceRepo();
    @Override
    public List<Service> selectAllService() {
        return serviceRepo.selectAllService();
    }

    @Override
    public void create(Service service) {
        serviceRepo.create(service);
    }
}
