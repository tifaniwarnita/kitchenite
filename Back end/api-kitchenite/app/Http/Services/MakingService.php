<?php
/**
 * Created by PhpStorm.
 * User: William Sentosa
 * Date: 8/11/2016
 * Time: 4:50 PM
 */

namespace App\Http\Services;
use App\Making;

class MakingService {
    public function countMakingByRecipe($recipeId) {
        $makings = Making::where('recipe_id', '=', $recipeId)
                            ->get();
        return count($makings);
    }
}