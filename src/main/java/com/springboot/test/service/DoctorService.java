package com.springboot.test.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.test.entity.Doctor;
import com.springboot.test.exception.ResourceNotFoundException;
import com.springboot.test.repository.DoctorRepository;

@Service
public class DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	public List<Doctor> getDoctors()
	{
		List<Doctor> doctors = new ArrayList<>();
		doctorRepository.findAll().forEach(doctors::add);
		Collections.sort(doctors);
		return doctors;
	}
	
	public Doctor getDoctorById(int id)
	{
		
		try {
			return doctorRepository.findById(id).get();
			
		} 
		catch (Exception e) {
			return null;
		}
	}
	
	public void addDoctor(Doctor doctor)
	{
		doctorRepository.save(doctor);
	}
	
	
	public Doctor updateDoctor(Doctor doctor)
	{
		Doctor existingDoctor = doctorRepository.findById(doctor.getId()).orElseThrow
				            (()->new ResourceNotFoundException("Doctor not found"+doctor)); 
		existingDoctor.setSalary(doctor.getSalary());
		return doctorRepository.save(doctor);
	}

}
