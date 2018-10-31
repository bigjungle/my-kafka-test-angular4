package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Datable;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.util.List;

/**
 * Spring Data JPA repository for the Datable entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DatableRepository extends JpaRepository<Datable, Long> {
    @Query("select distinct datable from Datable datable left join fetch datable.columns")
    List<Datable> findAllWithEagerRelationships();

    @Query("select datable from Datable datable left join fetch datable.columns where datable.id =:id")
    Datable findOneWithEagerRelationships(@Param("id") Long id);

}
