package com.CinemaProject.CinemaAPIApplication;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CinemaService
{
    @Autowired // we can either intialize below with new keyword or
    // use above anotation to let framework know we want to intialize this class repository
    private CinemaRepository cinemaRepository;

    public List<Cinema> getAllCinemas()
    {
        return cinemaRepository.findAll();
    }

    public Optional<Cinema> getCinema(ObjectId id)
    {
        return cinemaRepository.findById(id);
    }

    public Optional<Cinema> getCinemabyImdbId(String imdbId)
    {
        return cinemaRepository.findCinemaByImdbId(imdbId);
    }

}
