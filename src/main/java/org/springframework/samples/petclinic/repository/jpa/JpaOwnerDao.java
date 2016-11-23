package org.springframework.samples.petclinic.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.taglibs.standard.tag.common.core.ForEachSupport;
import org.springframework.stereotype.Repository;

@Repository
public class JpaOwnerDao {
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Object[]> getOwnerIdFirstName() {
		System.out.println("reached JpaOwnerDao.getOwnerIdFirstName");
		Query query = this.em.createQuery("select o.id,o.firstName from Owner o");
		List<Object[]> list = query.getResultList();
		System.out.println("JpaOwnerDao.getOwnerIdFirstName" + list);
		return list;

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Object[]> getPetIdFirstName(int id) {
		System.out.println("JpaOwnerDao.getpetIdFirstName() execution started:");
		Query query = this.em.createQuery("select p.id,p.name from Pet p where p.owner.id=:id");
		query.setParameter("id", id);
		List<Object[]> list = query.getResultList();
		System.out.println("JpaOwnerDao.getVetIdFirstName() execution completed:" + list);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getVetIdFirstName() {
		System.out.println("JpaOwnerDao.getVetIdFirstName() execution started:");
		Query query = this.em.createQuery("select v.id,v.firstName from Vet v");
		List<Object[]> list = query.getResultList();
		System.out.println("JpaOwnerDao.getVetIdFirstName() execution completed:" + list);
		return list;
	}

}
