package com.example.einternmatchback.ClientOffre.service;

import com.example.einternmatchback.ClientOffre.entity.CompanyOffer;
import com.example.einternmatchback.ClientOffre.entity.Favoris;
import com.example.einternmatchback.ClientOffre.repository.CompanyOfferRepository;
import com.example.einternmatchback.ClientOffre.repository.FavorisRepository;
import com.example.einternmatchback.Authentification.user.User;
import com.example.einternmatchback.Authentification.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OffreService {
    private final CompanyOfferRepository offerRepository;
    private final FavorisRepository favorisRepository;
    private final UserRepository userRepository;

    public List<CompanyOffer> getAllOffres() {
        return offerRepository.findAll();
    }

    public List<CompanyOffer> getOffresByLocation(String location) {
        return offerRepository.findByLocationContainingIgnoreCase(location);
    }

    public void addFavoris(String userEmail, Integer offerId) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        CompanyOffer offer = offerRepository.findById(offerId)
                .orElseThrow(() -> new RuntimeException("Offre non trouvée"));

        if (!favorisRepository.existsByUserAndOffer(user, offer)) {
            Favoris favoris = new Favoris();
            favoris.setUser(user);
            favoris.setOffer(offer);
            favorisRepository.save(favoris);
        }
    }

    public List<CompanyOffer> getUserFavorites(String userEmail) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        return favorisRepository.findByUser(user)
                .stream()
                .map(Favoris::getOffer)
                .collect(Collectors.toList());
    }
}