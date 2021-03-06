package se.iix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import se.iix.models.Ingredient;
import se.iix.models.Recipe;
import se.iix.models.User;
import se.iix.services.da.RecipeDAService;
import se.iix.services.da.UserDAService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class FixtureLoader implements ApplicationRunner {

    private final RecipeDAService recipeDAService;
    private final UserDAService userDAService;

    @Autowired
    public FixtureLoader(
            final RecipeDAService recipeDAService,
            final UserDAService userDAService
    ) {
        this.recipeDAService = recipeDAService;
        this.userDAService = userDAService;
    }

    @Override
    public void run(
            final ApplicationArguments applicationArguments
    ) throws Exception {

        final User kalleKock = userDAService.save(new User("Kalle Kock", "123"));

        // 4 port
        final List<Ingredient> pannkakaIngredients = new ArrayList<>();
        pannkakaIngredients.add(new Ingredient("Vetemjöl", 2.5, "dl"));
        pannkakaIngredients.add(new Ingredient("Mjölk", 6, "dl"));
        pannkakaIngredients.add(new Ingredient("Ägg", 3, "st"));
        final Set<String> pannkakaTags = new HashSet<>();
        pannkakaTags.add("Lunch");
        pannkakaTags.add("Vegetarian");
        final Recipe pannkaka = new Recipe("Pannkaka", pannkakaIngredients,
                "1. Blanda mjöl och salt i en bunke.\n" +
                "2. Vispa i hälften av mjölken och vispa till en slät smet. Vispa i resten av mjölken och äggen.\n" +
                "3. Smält smöret i stekpannan och vispa ner i smeten.\n" +
                "4. Stek tunna pannkakor av smeten i en stek- eller pannkakspanna.\n" +
                "5. Servera med sylt, bär eller frukt.", kalleKock, 4, pannkakaTags);
        recipeDAService.save(pannkaka);

        // 2 port
        final List<Ingredient> falukorvsmackaIngredients = new ArrayList<>();
        falukorvsmackaIngredients.add(new Ingredient("Skivor falukorv", 6, "st"));
        falukorvsmackaIngredients.add(new Ingredient("Ägg", 2, "st"));
        falukorvsmackaIngredients.add(new Ingredient("Sirapslimpa", 2, "skivor"));
        falukorvsmackaIngredients.add(new Ingredient("Senap", 2, "tsk"));
        falukorvsmackaIngredients.add(new Ingredient("Ketchup", 2, "msk"));
        final Set<String> falukorvsmackaTags = new HashSet<>();
        falukorvsmackaTags.add("Light meal");
        final Recipe falukorvsmacka = new Recipe("Falukorvsmacka", falukorvsmackaIngredients,
                "1. Stek falukorven gyllene i smöret. Stek äggen på båda sidor. Salta och peppra.\n" +
                        "2. Rosta brödskivorna i samma stekpanna.\n" +
                        "3. Fördela korven och äggen på de rostade brödskivorna.\n" +
                        "4. Toppa mackorna med senap och ketchup.\n" +
                        "5. Servera gärna med ett glas kall mjölk.",
                kalleKock, 2, falukorvsmackaTags);
        recipeDAService.save(falukorvsmacka);
    }
}
