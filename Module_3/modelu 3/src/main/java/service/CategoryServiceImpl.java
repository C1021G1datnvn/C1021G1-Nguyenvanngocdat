package service;

import model.Category;
import repository.Categoryreponsitory;

import java.util.List;

public class CategoryServiceImpl implements CategoryService{
    Categoryreponsitory categoryReponsitory = new Categoryreponsitory();
    @Override
    public List<Category> selectAll() {
        return categoryReponsitory.selectAll();
    }
}
