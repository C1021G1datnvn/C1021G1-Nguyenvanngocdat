package repository.service;

import model.service.Service;

import java.util.List;

public interface IService {
    List<Service> selectAllService();
    void create(Service service);
}
