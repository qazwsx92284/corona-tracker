package com.min0.corona.repository;

import com.min0.corona.pojo.Corona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoronaRepository extends JpaRepository<Corona, Long> {

}
