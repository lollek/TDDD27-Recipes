package se.iix.services.da;

import org.springframework.data.repository.Repository;
import se.iix.models.Recipe;
import se.iix.models.User;

import java.util.List;
import java.util.Optional;

public interface RecipeDAService extends Repository<Recipe, Long> {

    List<Recipe> findAll();
    List<Recipe> findAllByTitleContainingIgnoreCase(String title);
    List<Recipe> findTop10ByOrderByIdAsc();
    List<Recipe> findTop10ByOrderByIdDesc();

    Optional<Recipe> findById(Long id);

    List<Recipe> findAllByAuthor(User author);

    Recipe save(Recipe recipe);
}
