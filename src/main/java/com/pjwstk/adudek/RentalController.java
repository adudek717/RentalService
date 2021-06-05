package com.pjwstk.adudek;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class RentalController {
    private final RentalService rentalService;

    public RentalController(RentalService rentalService) { this.rentalService = rentalService; }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable("id") Long id) {
        return ResponseEntity.ok(rentalService.getMovie(id));
    }

    @PutMapping("/isAvailable/{id}")
    public ResponseEntity<Void> returnMovie(@PathVariable("id") Long id) {
         rentalService.returnMovie(id);
         return ResponseEntity.ok().build();
    }
}
