package io.ksrntheja.ratings.data.service.resources;

import io.ksrntheja.ratings.data.service.models.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable String movieId) {
        return new Rating(movieId, 5);
    }

}
