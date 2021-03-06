package se.iix.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@SuppressWarnings("WeakerAccess")
@Entity
@Table(name = "recipes")
public class Recipe implements Serializable {

    @SuppressWarnings("unused")
    @Id
    @GeneratedValue
    public Long id;

    @Column(nullable = false)
    public String title;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public List<Ingredient> ingredients;

    @ElementCollection(fetch = FetchType.EAGER)
    public Set<String> tags;

    @Column(nullable = false, columnDefinition = "TEXT")
    public String instructions;

    @Column(nullable = false)
    public Integer numPersons;

    @ManyToOne()
    @JoinColumn
    public User author;

    @SuppressWarnings("unused")
    private Recipe() {}

    public Recipe(
            final String title,
            final List<Ingredient> ingredients,
            final String instructions,
            final User author,
            final Integer numPersons,
            final Set<String> tags
    ) {
        this.title = title;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.author = author;
        this.numPersons = numPersons;
        this.tags = tags;
    }

    public boolean validateForSave() {
        if (this.title == null || this.instructions == null || this.author == null || numPersons == null) {
            return false;
        }
        if (ingredients != null) {
            return ingredients.stream().allMatch(Ingredient::validateForSave);
        }
        return true;
    }
}
