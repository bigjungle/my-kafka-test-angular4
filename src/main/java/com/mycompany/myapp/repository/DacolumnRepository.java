package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Dacolumn;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Dacolumn entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DacolumnRepository extends JpaRepository<Dacolumn, Long> {

}
