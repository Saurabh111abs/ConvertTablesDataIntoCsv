package com.dummy.controller;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dummy.service.DataService;


@RestController
public class HomeController {
	
//	    @Value("${csv.output.path}") // Assuming you have a property for the output path
//	    private String outputPath;
	
	@Autowired
	private DataService  dataService;
	
	@GetMapping("/getData")
	public List<Object[]> getData() {
		
		return dataService.getAddress();
		
	}
	
	@GetMapping("/get")
	public List<Object[]> getData1() {
		
		return dataService.getCustomer();
		
	}
	
	  @GetMapping("/generate")
	    public String generateCsv() {
	        try {
	            // Specify the output file
	            String outputFilePath = "F:\\" + File.separator + "combinedData.csv";
	            File outputFile = new File(outputFilePath);

	            // Generate and write the combined data to the CSV file
	            dataService.writeCombinedDataToCsvFile(outputFile);

	            // Success message or further processing
	            System.out.println("CSV file generated successfully: " + outputFilePath);

	        } catch (IOException e) {
	            // Handle the exception (log or respond to the client)
	            e.printStackTrace();
	            return "error"; // You might want to redirect to an error page or return an error response
	        }

	        return "success"; // You might want to redirect to a success page or return a success response
	    }
	
}
