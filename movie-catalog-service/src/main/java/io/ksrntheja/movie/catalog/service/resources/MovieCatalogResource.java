package io.ksrntheja.movie.catalog.service.resources;

import io.ksrntheja.movie.catalog.service.models.CatalogItem;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @RequestMapping("{userId}")
    public List<CatalogItem> getCatalog(@PathVariable String userId) {
        System.out.println("User Id :: " + userId);

        return Collections.singletonList(
                new CatalogItem("Movie1", "Movie1Desc", 5)
        );
    }

}
