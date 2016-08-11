<?php
/**
 * Created by PhpStorm.
 * User: William Sentosa
 * Date: 8/11/2016
 * Time: 5:37 PM
 */

namespace App\Http\Services;
use App\Nutrient;

class NutrientService {
    public function getNutrientByRecipe($recipeId) {
        $nutrients = Nutrient::where('recipe_id', '=', $recipeId)
            ->get();
        return count($makings);
    }
}