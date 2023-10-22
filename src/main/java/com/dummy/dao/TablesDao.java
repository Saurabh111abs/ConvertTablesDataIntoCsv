package com.dummy.dao;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


@Repository
public class TablesDao {
	
    @Autowired
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
	@Transactional
    public List<Object[]> getCustomers() {
        String sql = "SELECT * from customer";
        List<Object[]> customers = entityManager.createNativeQuery(sql).getResultList();
        System.out.println(customers);
        return customers;
       
    }
    
    @SuppressWarnings("unchecked")
    @Transactional
    public List<Object[]> getAddress() {
        String sql1 = "SELECT * from address";
        List<Object[]> addresses = entityManager.createNativeQuery(sql1).getResultList();
        return addresses;
        
        
    }
    

 
    
}   
    


