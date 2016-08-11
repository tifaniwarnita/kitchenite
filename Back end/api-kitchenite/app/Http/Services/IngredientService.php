<?php
/**
 * Created by PhpStorm.
 * User: William Sentosa
 * Date: 8/11/2016
 * Time: 4:59 PM
 */

namespace App\Http\Services;
use App\Ingredient;

class IngredientService {
    public function getIngredientByRecipe($recipeId) {
        $ingredients = Ingredient::where('recipe_id', '=', $recipeId)
                                    ->get();
        return $ingredients;
    }
}