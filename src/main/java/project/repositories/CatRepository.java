package project.repositories;

import org.springframework.data.repository.CrudRepository;


import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.Repository;
import project.entity.Cat;

import java.util.List;


public interface CatRepository extends ListCrudRepository<Cat, Integer> {

}
