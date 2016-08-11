<?php
/**
 * Created by PhpStorm.
 * User: William Sentosa
 * Date: 8/11/2016
 * Time: 4:16 PM
 */

namespace App\Http\Services;
use App\Rating;

class RatingService {
    public function countRatingByRecipe($recipeId) {
        $rateAvg = Rating::where('recipe_id', '=', $recipeId)
                        ->get()
                        ->avg('rate');
        return $rateAvg;
    }

}