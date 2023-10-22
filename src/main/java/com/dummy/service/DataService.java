package com.dummy.service;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dummy.dao.TablesDao;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

@Service
public class DataService {
	
	@Autowired
	private TablesDao tablesDao;
	
 	

	public List<Object[]> getAddress() {
		List<Object[]>  address =	tablesDao.getAddress();
		return address;
	}
	

	public List<Object[]> getCustomer() {
		List<Object[]>  customer =	tablesDao.getCustomers();
		return customer;
	}
	
	   public void writeListToCsvFile(List<Object[]> data, File outputFile) throws IOException {
	        CsvMapper csvMapper = new CsvMapper();
	        CsvSchema schema = csvMapper.schemaFor(Object[].class);

	        csvMapper.writer(schema).writeValue(outputFile, data);
	    }

	    public void writeCombinedDataToCsvFile(File outputFile) throws IOException {
	        List<Object[]> customers = getCustomer();
	        List<Object[]> addresses = getAddress();

	        // Combine the data
	        customers.addAll(addresses);
	        System.out.println("hello");

	        // Write to CSV
	        writeListToCsvFile(customers, outputFile);
	    }


}
