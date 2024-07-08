package com.lyn.firstjobapp.companies;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class companiesController {
    private ICompaniesService companiesService;

    public companiesController(ICompaniesService companiesService) {
        this.companiesService = companiesService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> findAllCompagnies() {
        return ResponseEntity.ok(companiesService.findAllCompanies());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Company> findCompanyById(@PathVariable Long id) {
        Company company = companiesService.findCompanyById(id);
        if (company != null)
            return new ResponseEntity<>(company, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody Company company) {
        companiesService.createCompany(company);
        return new ResponseEntity<>("Company Successfull Create", HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable Long id) {
        boolean delete = companiesService.deleteCompanyById(id);
        return (delete ? (new ResponseEntity<>("Compagny is successfull delete", HttpStatus.OK)) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company updateCompany) {
        boolean update = companiesService.updateCompany(id, updateCompany);
        return (update ? new ResponseEntity<>("Company is succesfull Update", HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
