package com.capstonedesign.backend.repository;

import com.capstonedesign.backend.domain.Cup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CupRepository extends CrudRepository<Cup, Long> {
}
