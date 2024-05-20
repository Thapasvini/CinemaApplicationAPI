package com.CinemaProject.CinemaAPIApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cinemas")
public class CinemaController
{
    @Autowired
    private CinemaService cinemaService;

    @GetMapping
    public ResponseEntity<List<Cinema>> getAllCinemas()
    {
        return new ResponseEntity<List<Cinema>>(cinemaService.getAllCinemas(), HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Optional<Cinema>> getMovie(@PathVariable("id")ObjectId id)
//    {
//        return new ResponseEntity<>(cinemaService.getCinema(id),HttpStatus.OK);
//    }
    // in bove we are using optional because sometines null will be returned if there is no movie
// here if we maintain two getmappings with both id and imdbId it throws ambiguous exception
    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Cinema>> getMovieImdbId(@PathVariable("imdbId")String imdbId)
    {
        return new ResponseEntity<>(cinemaService.getCinemabyImdbId(imdbId),HttpStatus.OK);
    }

}
