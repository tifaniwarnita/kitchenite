<?php

use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateIngredientNutrientsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('ingredient_nutrients', function (Blueprint $table) {
            $table->increments('id');
            $table->float('nutrition_amount');
            $table->integer('ingredient_id');
            $table->integer('nutrient_id');
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::drop('ingredient_nutrients');
    }
}
