package com.example.MiniProject2.repositories;

import com.example.MiniProject2.models.Captain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaptainRepository extends JpaRepository<Captain, Long> {
    List<Captain> findByAvgRatingScoreGreaterThan(Double threshold);
    Captain findByLicenseNumber(String licenseNumber);
}
