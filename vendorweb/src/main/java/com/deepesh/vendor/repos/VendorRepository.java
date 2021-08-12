package com.deepesh.vendor.repos;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.deepesh.vendor.entities.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {
	
//	@Query("SELECT type, COUNT(type) FROM projectdb.vendor GROUP BY type")
//	public List<Object[]> findTypeAndTypeCount();
}
