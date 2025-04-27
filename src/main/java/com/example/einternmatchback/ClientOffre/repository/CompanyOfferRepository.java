package com.example.einternmatchback.ClientOffre.repository;

import com.example.einternmatchback.ClientOffre.entity.CompanyOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CompanyOfferRepository extends JpaRepository<CompanyOffer, Integer> {
    //List<CompanyOffer> findByLocation(String location);
    List<CompanyOffer> findByLocationContainingIgnoreCase(String location);
    long count();
    // Ajoutez si nécessaire
    //@Query("SELECT o FROM CompanyOffer o WHERE LOWER(o.location) LIKE LOWER(concat('%', :location, '%'))")
    //List<CompanyOffer> searchByLocation(@Param("location") String location);
}
