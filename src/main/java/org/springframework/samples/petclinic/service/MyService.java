package org.springframework.samples.petclinic.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.repository.jpa.JpaOwnerDao;
import org.springframework.stereotype.Service;

@Service
public class MyService {
	private JpaOwnerDao jpaOwnerDao;
    @Autowired
	public void setJpaOwnerDao(JpaOwnerDao jpaOwnerDao) {
		this.jpaOwnerDao = jpaOwnerDao;
	}

	public Map<String, String> getOwnerIdFirstName() {

		System.out.println("reached MyService.getOwnerIdFirstName");

		List<Object[]> list = jpaOwnerDao.getOwnerIdFirstName();
		Map<String, String> map = new HashMap<String, String>();
		for (Object[] objects : list) {
			map.put(Integer.toString((int) objects[0]), (String) objects[1]);
		}
		System.out.println("MyService.getOwnerIdFirstName execution completed");
		return map;
	}

	public Map<String, String> getPetIdFirstName(int id) {

		System.out.println("reached MyService.getPetIdFirstName");

		List<Object[]> list = jpaOwnerDao.getPetIdFirstName(id);
		Map<String, String> map = new HashMap<String, String>();
		for (Object[] objects : list) {
			map.put(Integer.toString((int)objects[0]), (String) objects[1]);
		}
		System.out.println("MyService.getPetIdFirstName execution completed");
		return map;
	}
	public Map<String, String> getVetIdFirstName() {

		System.out.println("reached MyService.getVetIdFirstName");

		List<Object[]> list = jpaOwnerDao.getVetIdFirstName();
		Map<String, String> map = new HashMap<String, String>();
		for (Object[] objects : list) {
			map.put(Integer.toString((int)objects[0]), (String) objects[1]);
		}
		System.out.println("MyService.getVetIdFirstName execution completed");
		return map;
	}
	
	
}
