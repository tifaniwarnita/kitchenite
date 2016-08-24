<?php

namespace App\Http\Controllers;

use App\Http\Services\IngredientService;
use App\Http\Services\InstructionService;
use App\Http\Services\NutrientService;
use Illuminate\Http\Request;

use App\Http\Requests;
use App\Http\Services\RatingService;
use Illuminate\Support\Facades\DB;

class RecipeController extends Controller
{
    public function getRatingByRecipe($recipeId) {
        $ratingService = new RatingService();
        $rate = $ratingService->countRatingByRecipe($recipeId);
        return $rate;
    }
    
    public function getIngredientsByRecipe($recipeId) {
        $ingredientService = new IngredientService();
        $ingredients = $ingredientService->getIngredientByRecipe($recipeId)->get(['name', 'amount', 'measurement']);
        return $ingredients;
    }

    public function getInstructionsByRecipe($recipeId) {
        $instructionService = new InstructionService();
        $instructions = $instructionService->getInstructionByRecipe($recipeId)->get(['step_number', 'explanation']);
        return $instructions;
    }

    public function getNutrientsByRecipe($recipeId) {
        $nutrientService = new NutrientService();
        $nutrients = $nutrientService->getNutrientByRecipe($recipeId)
                                    ->select(DB::raw('nutrients.name, sum(ingredient_amount * nutrition_amount) as amount, nutrients.unit'))
                                    ->groupBy('name')
                                    ->get();
        return $nutrients;
    }
}
