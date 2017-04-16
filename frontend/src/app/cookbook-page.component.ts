import {Component} from "@angular/core";
import {RecipeService} from "./recipe/recipe.service";
import {Observable} from "rxjs/Observable";

import {Recipe} from "./recipe/recipe.model";

@Component({
    selector: 'cookbook-page',
    template: `
<h2 class="text-center">My Cookbook</h2>
<div class="row">
    <div class="mx-auto p-3">
        <recipe-list [recipes]="recipes"></recipe-list>
    </div>
</div>
`
})

export class CookbookPageComponent {
    recipes: Observable<Recipe[]>;

    constructor(
        private recipeService: RecipeService
    ) {
    }

}
