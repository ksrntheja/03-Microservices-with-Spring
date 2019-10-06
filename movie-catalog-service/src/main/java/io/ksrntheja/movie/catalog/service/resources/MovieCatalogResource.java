package io.ksrntheja.movie.catalog.service.resources;

import io.ksrntheja.movie.catalog.service.models.CatalogItem;
import io.ksrntheja.movie.catalog.service.models.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        return ratings.stream().map(rating -> new CatalogItem("Movie1", "Movie1Desc", 5))
                .collect(Collectors.toList());

/*        return Collections.singletonList(
                new CatalogItem("Movie1", "Movie1Desc", 5)
        );*/
    }

}
