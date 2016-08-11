<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

use App\Http\Requests;
use App\Http\Services\RatingService;

class RecipeController extends Controller
{
    public function getRatingByRecipe($recipeId) {
        $ratingService = new RatingService();
        $rate = $ratingService->countRatingByRecipe($recipeId);
        return $rate;
    }
}
