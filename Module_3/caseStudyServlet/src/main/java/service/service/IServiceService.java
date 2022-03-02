package service.service;

import model.service.Service;

import java.util.List;

public interface IServiceService {
    List<Service> selectAllService();
    void create(Service service);
}
