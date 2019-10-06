package io.ksrntheja.movie.info.service.resources;

import io.ksrntheja.movie.info.service.models.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieInfoResource {

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable String movieId) {
        System.out.println("Movie Id :: " + movieId);
        return new Movie(movieId, "Movie1Name");
    }

}
