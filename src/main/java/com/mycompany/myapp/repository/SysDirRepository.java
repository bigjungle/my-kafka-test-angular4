package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.SysDir;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the SysDir entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SysDirRepository extends JpaRepository<SysDir, Long> {

}
