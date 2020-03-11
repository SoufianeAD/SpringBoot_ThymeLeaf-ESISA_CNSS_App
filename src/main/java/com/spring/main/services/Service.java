package com.spring.main.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.spring.main.models.Student;

@org.springframework.stereotype.Service
public class Service {

	public Student login(String cin, String massarCode) {
		Student student = null;
		try {
			File file = new File("./src/main/resources/data/StudentsData.xlsx");
			FileInputStream inputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(0);
			int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum() + 3;
			int counter = 4;
			boolean found = false;
			while(counter < rowCount && !found) {
				Row row = sheet.getRow(counter);
				counter++;
				if(cin.equals(row.getCell(6).toString()) && massarCode.equals(row.getCell(7).toString())) {
					found = true;
					student = new Student();
				}
			}
			inputStream.close();
			workbook.close();
		} catch (Exception e) {
			System.err.println("Error while openning the data file: " + e.getMessage());
		}
		return student;
	}
	
	public Student getStudentRow(String cin) {
		Student student = null;
		try {
			File file = new File("./src/main/resources/data/StudentsData.xlsx");
			FileInputStream inputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(0);
			int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum() + 3;
			int counter = 4;
			boolean found = false;
			while(counter < rowCount && !found) {
				Row row = sheet.getRow(counter);
				counter++;
				if(cin.equals(row.getCell(6).toString())) {
					found = true;
					student = new Student();
					student.setCin(row.getCell(6).toString());
					student.setCne(row.getCell(7).toString());
					student.setNom(row.getCell(8).toString());
					student.setPrenom(row.getCell(9).toString());
					student.setDateNaissance(row.getCell(10).toString());
				}
			}
			inputStream.close();
			workbook.close();
		} catch (Exception e) {
			System.err.println("Error while openning the data file: " + e.getMessage());
		}
		return student;
	}
	
	public void setStudentRow(Student student) {
		try {
			File file = new File("./src/main/resources/data/StudentsData.xlsx");
			FileInputStream inputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(0);
			int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum() + 3;
			int counter = 4;
			boolean found = false;
			while(counter < rowCount && !found) {
				Row row = sheet.getRow(counter);
				counter++;
				if(student.getCin().equals(row.getCell(6).toString())) {
					found = true;
					row.getCell(0).setCellValue(student.getCinPere());
					row.getCell(1).setCellValue(student.getNomPere());
					row.getCell(2).setCellValue(student.getPrenomPere());
					row.getCell(3).setCellValue(student.getCinMere());
					row.getCell(4).setCellValue(student.getNomMere());
					row.getCell(5).setCellValue(student.getPrenomMere());
				}
			}
			inputStream.close();
			FileOutputStream outputStream = new FileOutputStream(file);
			workbook.write(outputStream);
			outputStream.close();
			workbook.close();
		} catch (Exception e) {
			System.err.println("Error while openning the data file: " + e.getMessage());
		}
	}
	
}
