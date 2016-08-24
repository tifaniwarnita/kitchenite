<?php
/**
 * Created by PhpStorm.
 * User: William Sentosa
 * Date: 8/11/2016
 * Time: 4:59 PM
 */

namespace App\Http\Services;
use App\Ingredient;
use App\Recipe_ingredient;

class IngredientService {
    public function getIngredientByRecipe($recipeId) {
        $ingredients = Recipe_ingredient::where('recipe_id', '=', $recipeId)
                                        ->join('ingredients', 'recipe_ingredients.ingredient_id', '=', 'ingredients.id');
        return $ingredients;
    }
}