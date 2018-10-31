package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Dep;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Dep entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DepRepository extends JpaRepository<Dep, Long> {

}
