<?php
/**
 * Created by PhpStorm.
 * User: William Sentosa
 * Date: 8/11/2016
 * Time: 5:37 PM
 */

namespace App\Http\Services;
use App\Nutrient;
use App\Recipe_ingredient;

class NutrientService {
    public function getNutrientByRecipe($recipeId) {
        $nutrients = Recipe_ingredient::where('recipe_id', '=', $recipeId)
                                        ->join('ingredients', 'recipe_ingredients.ingredient_id', '=', 'ingredients.id')
                                        ->join('ingredient_nutrients', 'ingredients.id', '=', 'ingredient_nutrients.ingredient_id')
                                        ->join('nutrients', 'nutrients.id', '=', 'ingredient_nutrients.nutrient_id');
        return $nutrients;
    }
}