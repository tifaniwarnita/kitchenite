<?php
/**
 * Created by PhpStorm.
 * User: William Sentosa
 * Date: 8/11/2016
 * Time: 5:09 PM
 */

namespace App\Http\Services;
use App\Instruction;

class InstructionService {
    public function getInstructionByRecipe($recipeId) {
        $instructions = Instruction::where('recipe_id', '=', $recipeId)
            ->orderBy('step_number', 'asc')
            ->get();
        return $instructions;
    }
}