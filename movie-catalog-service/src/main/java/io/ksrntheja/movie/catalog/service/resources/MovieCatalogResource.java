package io.ksrntheja.movie.catalog.service.resources;

import io.ksrntheja.movie.catalog.service.models.CatalogItem;
import io.ksrntheja.movie.catalog.service.models.Movie;
import io.ksrntheja.movie.catalog.service.models.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @RequestMapping("{userId}")
    public List<CatalogItem> getCatalog(@PathVariable String userId) {
        System.out.println("User Id :: " + userId);

        RestTemplate restTemplate = new RestTemplate();

        List<Rating> ratings = Arrays.asList(
                new Rating("1234", 4),
                new Rating("5678", 3)
        );

/*        List<CatalogItem> list = new ArrayList<>();
        for (Rating rating : ratings) {
            CatalogItem catalogItem = new CatalogItem("Movie1", "Movie1Desc", 5);
            list.add(catalogItem);
        }
        return list;*/

/*        return ratings.stream().map(rating -> new CatalogItem("Movie1", "Movie1Desc", 5))
                .collect(Collectors.toList());*/

/*        return Collections.singletonList(
                new CatalogItem("Movie1", "Movie1Desc", 5)
        );*/

        return ratings.stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
            return new CatalogItem(movie.getName(), "DESC", rating.getRating());
        }).collect(Collectors.toList());
    }

}
