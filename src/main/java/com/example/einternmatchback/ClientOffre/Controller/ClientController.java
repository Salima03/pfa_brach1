package com.example.einternmatchback.ClientOffre.Controller;

import com.example.einternmatchback.ClientOffre.entity.CompanyOffer;
import com.example.einternmatchback.ClientOffre.service.OffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@PreAuthorize("hasRole('STUDENT')")
public class ClientController {
    @Autowired
    private OffreService offreService;

    public void StudentController(OffreService offreService) {
        this.offreService = offreService;
    }

    @GetMapping("/offers")
    public ResponseEntity<List<CompanyOffer>> getAllOffers(
            @RequestParam(required = false) String location) {

        if (location != null) {
            return ResponseEntity.ok(offreService.getOffresByLocation(location));
        }
        return ResponseEntity.ok(offreService.getAllOffres());
    }

    @PostMapping("/favorites/{offerId}")
    public ResponseEntity<String> addFavorite(
            @PathVariable int offerId,
            Principal principal) {

        // Vous devrez modifier votre service pour utiliser l'email du principal
        offreService.addFavoris(principal.getName(), offerId);
        return ResponseEntity.ok("Offre ajoutée aux favoris");
    }

    @GetMapping("/favorites")
    public ResponseEntity<List<CompanyOffer>> getFavorites(Principal principal) {
        // Adaptez cette méthode dans votre service pour retourner List<CompanyOffer>
        return ResponseEntity.ok(offreService.getUserFavorites(principal.getName()));
    }
}