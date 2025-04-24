package com.example.MiniProject2.services;

import com.example.MiniProject2.models.Captain;
import com.example.MiniProject2.repositories.CaptainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaptainService {

    private final CaptainRepository captainRepository;

    @Autowired
    public CaptainService(CaptainRepository captainRepository) {
        this.captainRepository = captainRepository;
    }

    public Captain addCaptain(Captain captain) {
        return captainRepository.save(captain);
    }

    public List<Captain> getAllCaptains() {
        return captainRepository.findAll();
    }

    public Captain getCaptainById(Long id) {
        return captainRepository.findById(id).orElse(null);
    }

    public List<Captain> getCaptainsByRating(Double ratingThreshold) {
        return captainRepository.findByAvgRatingScoreGreaterThan(ratingThreshold);
    }

    public Captain getCaptainByLicenseNumber(String licenseNumber) {
        return captainRepository.findByLicenseNumber(licenseNumber);
    }
}
