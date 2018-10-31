package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.ARightUser;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the ARightUser entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ARightUserRepository extends JpaRepository<ARightUser, Long> {

}
