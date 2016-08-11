<?php
/**
 * Created by PhpStorm.
 * User: William Sentosa
 * Date: 8/11/2016
 * Time: 4:51 PM
 */

namespace App\Http\Services;
use App\Comment;

class CommentService {
    public function countCommentByRecipe($recipeId) {
        $comments = Comment::where('recipe_id', '=', $recipeId)
                            ->get();
        return count($comments);
    }
}