package project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.entity.Cat;
import project.repositories.CatRepository;
import java.util.List;

@Service
public class CatsDataService {
    @Autowired
    private CatRepository catRepository;
    @Transactional
    public List<Cat> getAllCats()
    {

        return (List<Cat>) catRepository.findAll();
    }
    @Transactional
    public void addCat(Cat cat)
    {
        catRepository.save(cat);
    }

}
