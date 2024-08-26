//package com.example.talent_api.controllers;
//
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/manager")
//public class HiringManagerController {
//
//    //Can change what is returning later
//    //For now I have it return a String
//
//    @GetMapping
//    public String getAll() {
//        return "Get list of record of managers";
//    }
//
//    @GetMapping("/{id}")
//    public String getManagerByID(@PathVariable("id") long id) {
//        return "This is ID of single record manager: " + id;
//    }
//
//    @PostMapping
//    public String addManager() {
//
//        return "This is to add Manager";
//    }
//
//    @PutMapping("/{id}")
//    public String putCustomer(@PathVariable("id") long managerID) {
//
//        return "Update this Manager by id: " + managerID;
//
//    }
//
//    @DeleteMapping("/{id}")
//    public String deleteCustomerById(@PathVariable("id") long id) {
//        // repo.delete(id);
//        return "Delete manager by this ID";
//    }
//
//}
package com.example.talent_api.controllers;

import com.example.talent_api.entity.HiringManager;
import com.example.talent_api.repository.HiringManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class HiringManagerController {

    @Autowired
    private HiringManagerRepository hiringManagerRepository;

    @GetMapping
    public List<HiringManager> getAllHiringManagers() {
        return (List<HiringManager>) hiringManagerRepository.findAll();
    }

    @GetMapping("/{id}")
    public HiringManager getHiringManagerById(@PathVariable Long id) {
        return hiringManagerRepository.findById(id).orElse(null);
    }

    @PostMapping
    public HiringManager createHiringManager(@RequestBody HiringManager hiringManager) {
        return hiringManagerRepository.save(hiringManager);
    }

    @PutMapping("/{id}")
    public HiringManager updateHiringManager(@PathVariable Long id, @RequestBody HiringManager hiringManagerDetails) {
        HiringManager hiringManager = hiringManagerRepository.findById(id).orElse(null);
        if (hiringManager != null) {
            hiringManager.setName(hiringManagerDetails.getName());
            hiringManager.setEmail(hiringManagerDetails.getEmail());
            hiringManager.setDepartment(hiringManagerDetails.getDepartment());
            hiringManager.setPhone(hiringManagerDetails.getPhone());
            return hiringManagerRepository.save(hiringManager);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteHiringManager(@PathVariable Long id) {
        hiringManagerRepository.deleteById(id);
    }
}