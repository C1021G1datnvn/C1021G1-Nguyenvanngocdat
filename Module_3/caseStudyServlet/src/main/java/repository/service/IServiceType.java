package repository.service;

import model.service.ServiceType;

import java.util.List;

public interface IServiceType {
    List<ServiceType> selectAllService();
}
