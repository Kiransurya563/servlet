package servletefour_crud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import servletefour_crud.dto.StudentDto;

public class StudentDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public String insert(StudentDto d1) {
		entityTransaction.begin();
		entityManager.persist(d1);
		entityTransaction.commit();
		return "account created succesfully";
	}

	public Object findById(String email) {
		StudentDto sdto = entityManager.find(StudentDto.class, email);
		if (sdto == null) {
			return "no data found";// string
		} else
			return sdto;// object-->classtype
	}

	public String deleteById(String email) {
		StudentDto sdto = entityManager.find(StudentDto.class, email);
		if(sdto!=null) {
		entityTransaction.begin();
		entityManager.remove(sdto);
		entityTransaction.commit();
		return "data govindaaaaa";
		}
		else
			return "no govindaaaaa";
	}
	
	
	public Object fetchAll() {
		//select  vn from tab_name vn;
		//select a from StudentDto a;
		Query q=entityManager.createQuery("select a from StudentDto a");
		List<StudentDto> list=q.getResultList();
		if(list.isEmpty()) {
			return "no data found";
		}
		else
			return list;
	}
	
	public String deleteAll() {
		//select  vn from tab_name vn;
		//select a from StudentDto a;
		Query q=entityManager.createQuery("select a from StudentDto a");
		List<StudentDto> list=q.getResultList();
		
		if(list.isEmpty()) {
			return "no data found";
		}
		else
		{
			for(StudentDto s:list) {
				entityTransaction.begin();
				entityManager.remove(s);
				entityTransaction.commit();
			}
			return "all data govindaaaaa";
		}
	}

}















