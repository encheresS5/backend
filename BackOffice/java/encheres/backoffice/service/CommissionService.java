package encheres.backoffice.service;

import encheres.backoffice.models.Commission;
import encheres.backoffice.repository.CommissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommissionService {
    @Autowired
    CommissionRepository commissionRepository;

    //getting all commission record by using the method findaAll() of CrudRepository
    public List<Commission> getAllCommissions()
    {
        List<Commission> commission = new ArrayList<Commission>();
        commissionRepository.findAll().forEach(commission::add);
        return commission;
    }
    //getting a specific record by using the method findById() of CrudRepository
    public Commission getCommissionsById(int id)
    {
        return commissionRepository.findById(id).get();
    }
    //saving a specific record by using the method save() of CrudRepository
    public void saveOrUpdate(Commission commission)
    {
        commissionRepository.save(commission);
    }
    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(int id)
    {
        commissionRepository.deleteById(id);
    }
    //updating a record
    public void update(Commission commission, int bookid)
    {
        commissionRepository.save(commission);
    }
}
