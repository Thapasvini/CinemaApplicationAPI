package com.CinemaProject.CinemaAPIApplication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class ReviewService
{
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;
    //here we have to assosiate every review with one of the cinemas to make it easier we use mongotemplate
    // this is one way to interact with database

    @PostMapping
    public Reviews createReview(String reviewbody,String imdbId)
    {
        Reviews review= reviewRepository.insert(new Reviews(reviewbody));

        mongoTemplate.update(Cinema.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();// here first is that we get a single movie
        return review;
    }


    public List<Reviews> getReviews()
    {
        return reviewRepository.findAll();
    }
//    public ResponseEntity<List<Cinema>> getReviews()
//    {
//        return new ResponseEntity<>()
//    }
}
