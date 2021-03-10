package com.transaction.first;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DateRepository extends JpaRepository<Transaction, Integer> {
	@Override
	List<Transaction> findAll();
	@Query(value = "select * from reposting where DATE(created_date)=?1",nativeQuery = true)
	List<Transaction> findByDa(String date);
	@Query(value = "select * from reposting where DATE(created_date)=?1 and status=?2",nativeQuery = true)
	List<Transaction> findByDate(String date,String sta);
//	@Query(value = "select unique(org_code) from reposting where DATE(created_date)=?1",nativeQuery = true)
//	List<String> findOrg_code(String date);
	@Query(value = "select count(id) from reposting where DATE(created_date)=?1 and status=?2 and org_code=?3",nativeQuery = true )
	int findCount(String date,String sta,String oc);
}
