package com.example.venkataraman.hola;

import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class DietActivity extends AppCompatActivity {

    public TextView day, f0, f1, f2, f3, f4, f5, content;
    public ImageView f;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);

        Toolbar t = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(t);
        getSupportActionBar().setTitle("Diet");

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        Window window = this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.Sugar));


        day = (TextView) findViewById(R.id.day);
        f0 = (TextView) findViewById(R.id.f0);
        f1 = (TextView) findViewById(R.id.f1);
        f2 = (TextView) findViewById(R.id.f2);
        f3 = (TextView) findViewById(R.id.f3);
        f4 = (TextView) findViewById(R.id.f4);
        f5 = (TextView) findViewById(R.id.f5);
        content = (TextView) findViewById(R.id.content);

        Calendar calendar = Calendar.getInstance();
        String day_of_week = getDayOfWeek(calendar.get(Calendar.DAY_OF_WEEK));
        day.setText("Day : "+day_of_week);
        getFood(day_of_week);

        String tmp = "Incorporating more plant-based foods into your diet is a great way to boost your health. A vegetarian diet has been shown to reduce your risk of heart disease , type-2 diabetes and even certain types of cancer. Whether you already follow a vegetarian diet or are just looking to go meatless sometimes, this 7-day, 1,200-calorie vegetarian meal plan makes it easy to eat your veggies! The registered dietitians and culinary experts at EatingWell have done the work for you and planned out a week of delicious vegetarian meals and snacks. Since it can be challenging to get certain nutrients when limiting animal products, we made sure to include a variety of healthy foods like nuts, whole grains, plenty of fruits and vegetables, and protein-rich beans and tofu. We also included the calorie totals next to each meal so you can swap things in and out to make this plan work for you. We hope you enjoy this week filled with nourishing and healthy meatless meals. Not sure if this is the plan for you? We offer a variety of meal plans for different health conditions, needs and diets.";
        content.setText(tmp);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            Intent i = new Intent(DietActivity.this, NavActivity.class);
            startActivity(i);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void getFood(String day_of_week) {
        if (day_of_week.equals("Tuesday")) {
            //f.setImageResource(R.drawable.d0);
            //Breakfast
            final String string0 = "Oatmeal with Fruit & Nuts\n" +
                    "• 1/2 cup oatmeal cooked in 1/2 cup skim milk and 1/2 cup water\n" +
                    "• 1/2 medium apple, diced\n" +
                    "• 1 Tbsp. chopped walnuts\n" +
                    "• Top oatmeal with apple, walnuts and a pinch of cinnamon.";
            f0.setText("Breakfast (297 calories)");
            f0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f0.getText().toString().trim().contentEquals(string0)) {
                        f0.setText("Breakfast (297 calories)");
                    }
                    else if (f0.getText().toString().trim().contentEquals("Breakfast (297 calories)")) {
                        f0.setText(string0);
                    }
                }
            });

            //AN Snack
            final String string1 = "• 1/2 medium apple";
            f1.setText("A.M. Snack (47 calories)");
            f1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f1.getText().toString().trim().contentEquals(string1)) {
                        f1.setText("A.M. Snack (47 calories)");
                    }
                    else if (f1.getText().toString().trim().contentEquals("A.M. Snack (47 calories)")) {
                        f1.setText(string1);
                    }
                }
            });

            //Lunch
            final String string2 = "Green salad with Spiced Chickpea \"Nuts\"\n" +
                    "• 2 cups mixed greens\n" +
                    "• 5 cherry tomatoes, halved\n" +
                    "• 1/2 cup cucumber slices)\n" +
                    "• 1/4 cup Spiced Chickpea \"Nuts\"\n" +
                    "• 1 Tbsp. feta cheese\n" +
                    "• Combine ingredients and top with 1 Tbsp. each olive oil & balsamic vinegar.";
            f2.setText("Lunch (337 calories)");
            f2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f2.getText().toString().trim().contentEquals(string2)) {
                        f2.setText("Lunch (337 calories)");
                    }
                    else if (f2.getText().toString().trim().contentEquals("Lunch (337 calories)")) {
                        f2.setText(string2);
                    }
                }
            });

            //P.M. Snack
            final String string3 = "• 1/2 cup nonfat plain Greek yogurt\n" +
                    "• 1/4 cup sliced strawberries";
            f3.setText("P.M. Snack (80 calories)");
            f3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f3.getText().toString().trim().contentEquals(string3)) {
                        f3.setText("P.M. Snack (80 calories)");
                    }
                    else if (f3.getText().toString().trim().contentEquals("P.M. Snack (80 calories)")) {
                        f3.setText(string3);
                    }
                }
            });

            //Dinner
            final String string4 = "• 1 serving Mozzarella, Basil & Zucchini Frittata\n" +
                    "• 1 cup mixed greens\n" +
                    "• Top salad with 1/2 Tbsp. each olive oil & balsamic vinegar.\n" +
                    "• 2 diagonal slices baguette (1/4 inch thick), preferably whole-wheat, toasted";
            f4.setText("Dinner (431 calories)");
            f4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f4.getText().toString().trim().contentEquals(string4)) {
                        f4.setText("Dinner (431 calories)");
                    }
                    else if (f4.getText().toString().trim().contentEquals("Dinner (431 calories)")) {
                        f4.setText(string4);
                    }
                }
            });

            //Evening Snack
            final String string5 = "";
            f5.setText(string5);
            f5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f5.getText().toString().trim().contentEquals(string5)) {
                        f5.setText("");
                    }
                    else if (f5.getText().toString().trim().contentEquals("")) {
                        f5.setText(string5);
                    }
                }
            });
        }
        else if (day_of_week.equals("Wednesday")) {
            //f.setImageResource(R.drawable.d1);
            //Breakfast
            final String string0 = "• 1 cup nonfat plain Greek yogurt\n" +
                    "• 1/4 cup muesli\n" +
                    "• 1/4 cup blueberries";
            f0.setText("Breakfast (264 calories)");
            f0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f0.getText().toString().trim().contentEquals(string0)) {
                        f0.setText("Breakfast (264 calories)");
                    }
                    else if (f0.getText().toString().trim().contentEquals("Breakfast (264 calories)")) {
                        f0.setText(string0);
                    }
                }
            });

            //AN Snack
            final String string1 = "• 1/2 medium apple";
            f1.setText("A.M. Snack (70 calories)");
            f1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f1.getText().toString().trim().contentEquals(string1)) {
                        f1.setText("A.M. Snack (70 calories)");
                    }
                    else if (f1.getText().toString().trim().contentEquals("A.M. Snack (70 calories)")) {
                        f1.setText(string1);
                    }
                }
            });

            //Lunch
            final String string2 = "• 2 Tomato-Cheddar Cheese Toasts\n" +
                    "• 2 cups mixed greens\n" +
                    "• 1/2 cup cucumber slices)\n" +
                    "• 1/4 cup grated carrot\n" +
                    "• 1 Tbsp. chopped walnuts\n" +
                    "• Combine ingredients and top salad with 1/2 Tbsp. each olive oil & balsamic vinegar.";
            f2.setText("Lunch (316 calories)");
            f2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f2.getText().toString().trim().contentEquals(string2)) {
                        f2.setText("Lunch (316 calories)");
                    }
                    else if (f2.getText().toString().trim().contentEquals("Lunch (316 calories)")) {
                        f2.setText(string2);
                    }
                }
            });

            //P.M. Snack
            final String string3 = "• 6 walnut halves";
            f3.setText("P.M. Snack (78 calories)");
            f3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f3.getText().toString().trim().contentEquals(string3)) {
                        f3.setText("P.M. Snack (78 calories)");
                    }
                    else if (f3.getText().toString().trim().contentEquals("P.M. Snack (78 calories)")) {
                        f3.setText(string3);
                    }
                }
            });

            //Dinner
            final String string4 = "• 2 Butternut Squash & Black Bean Tostadas";
            f4.setText("Dinner (422 calories)");
            f4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f4.getText().toString().trim().contentEquals(string4)) {
                        f4.setText("Dinner (422 calories)");
                    }
                    else if (f4.getText().toString().trim().contentEquals("Dinner (422 calories)")) {
                        f4.setText(string4);
                    }
                }
            });

            //Evening Snack
            final String string5 = "• 1 Tbsp. chocolate chips, preferably dark chocolate";
            f5.setText("Evening Snack (50 calories)");
            f5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f5.getText().toString().trim().contentEquals(string5)) {
                        f5.setText("Evening Snack (50 calories)");
                    }
                    else if (f5.getText().toString().trim().contentEquals("Evening Snack (50 calories)")) {
                        f5.setText(string5);
                    }
                }
            });
        }
        else if (day_of_week.equals("Thursday")) {
            //f.setImageResource(R.drawable.d2);
            //Breakfast
            final String string0 = "• 1 slice whole-wheat bread, toasted\n" +
                    "• 1 Tbsp. peanut butter\n" +
                    "• 1 banana";
            f0.setText("Breakfast (279 calories)");
            f0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f0.getText().toString().trim().contentEquals(string0)) {
                        f0.setText("Breakfast (279 calories)");
                    }
                    else if (f0.getText().toString().trim().contentEquals("Breakfast (279 calories)")) {
                        f0.setText(string0);
                    }
                }
            });

            //AN Snack
            final String string1 = "• 1 hard-boiled egg seasoned with a pinch each of salt and pepper";
            f1.setText("A.M. Snack (70 calories)");
            f1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f1.getText().toString().trim().contentEquals(string1)) {
                        f1.setText("A.M. Snack (70 calories)");
                    }
                    else if (f1.getText().toString().trim().contentEquals("A.M. Snack (70 calories)")) {
                        f1.setText(string1);
                    }
                }
            });

            //Lunch
            final String string2 = "Green salad with Spiced Chickpea \"Nuts\" \n" +
                    "• 2 cups mixed greens\n" +
                    "• 5 cherry tomatoes, halved\n" +
                    "• 1/2 cup cucumber slices)\n" +
                    "• 1/4 cup Spiced Chickpea \"Nuts\"\n" +
                    "• 1 Tbsp. feta cheese\n" +
                    "• Combine ingredients and top salad with 1 Tbsp. each olive oil & balsamic vinegar.";
            f2.setText("Lunch (337 calories)");
            f2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f2.getText().toString().trim().contentEquals(string2)) {
                        f2.setText("Lunch (337 calories)");
                    }
                    else if (f2.getText().toString().trim().contentEquals("Lunch (337 calories)")) {
                        f2.setText(string2);
                    }
                }
            });

            //P.M. Snack
            final String string3 = "• 2/3 cup nonfat plain Greek yogurt\n" +
                    "• 3 Tbsp. blueberries";
            f3.setText("P.M. Snack (103 calories)");
            f3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f3.getText().toString().trim().contentEquals(string3)) {
                        f3.setText("P.M. Snack (103 calories)");
                    }
                    else if (f3.getText().toString().trim().contentEquals("P.M. Snack (103 calories)")) {
                        f3.setText(string3);
                    }
                }
            });

            //Dinner
            final String string4 = "• 1 3/4 cups Tomato & Artichoke Gnocchi";
            f4.setText("Dinner (427 calories)");
            f4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f4.getText().toString().trim().contentEquals(string4)) {
                        f4.setText("Dinner (427 calories)");
                    }
                    else if (f4.getText().toString().trim().contentEquals("Dinner (427 calories)")) {
                        f4.setText(string4);
                    }
                }
            });

            //Evening Snack
            final String string5 = "";
            f5.setText("");
            f5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f5.getText().toString().trim().contentEquals(string5)) {
                        f5.setText("");
                    }
                    else if (f5.getText().toString().trim().contentEquals("")) {
                        f5.setText(string5);
                    }
                }
            });
        }
        else if (day_of_week.equals("Friday")) {
            //f.setImageResource(R.drawable.d3);
            //Breakfast
            final String string0 = "• 1 cup nonfat plain Greek yogurt\n" +
                    "• 1/2 cup muesli\n" +
                    "• 1/2 cup blueberries)\n" +
                    "• Top yogurt with blueberries and muesli.";
            f0.setText("Breakfast (264 calories)");
            f0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f0.getText().toString().trim().contentEquals(string0)) {
                        f0.setText("Breakfast (264 calories)");
                    }
                    else if (f0.getText().toString().trim().contentEquals("Breakfast (264 calories)")) {
                        f0.setText(string0);
                    }
                }
            });

            //AN Snack
            final String string1 = "• 8 walnut halves";
            f1.setText("A.M. Snack (105 calories)");
            f1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f1.getText().toString().trim().contentEquals(string1)) {
                        f1.setText("A.M. Snack (105 calories)");
                    }
                    else if (f1.getText().toString().trim().contentEquals("A.M. Snack (105 calories)")) {
                        f1.setText(string1);
                    }
                }
            });

            //Lunch
            final String string2 = "Leftovers \n" +
                    "• 1 cup Tomato & Artichoke Gnocchi\n" +
                    "• 2 cups mixed greens\n" +
                    "• Top greens with 1/2 Tbsp. each olive oil & balsamic vinegar.";
            f2.setText("Lunch (332 calories)");
            f2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f2.getText().toString().trim().contentEquals(string2)) {
                        f2.setText("Lunch (332 calories)");
                    }
                    else if (f2.getText().toString().trim().contentEquals("Lunch (332 calories)")) {
                        f2.setText(string2);
                    }
                }
            });

            //P.M. Snack
            final String string3 = "• 2 clementines";
            f3.setText("P.M. Snack (70 calories)");
            f3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f3.getText().toString().trim().contentEquals(string3)) {
                        f3.setText("P.M. Snack (70 calories)");
                    }
                    else if (f3.getText().toString().trim().contentEquals("P.M. Snack (70 calories)")) {
                        f3.setText(string3);
                    }
                }
            });

            //Dinner
            final String string4 = "Bean & Veggie Rice Bowl \n" +
                    "• 1/2 cup cooked brown rice\n" +
                    "• 1/2 cup cooked black beans\n" +
                    "• 1/2 green bell pepper and 1/2 onion, sliced and sautéed in 1 tsp. olive oil\n" +
                    "• 1 oz. shredded Cheddar cheese\n" +
                    "• 1/4 cup salsa\n" +
                    "• Top rice with beans, vegetables, cheese and salsa. Garnish with cilantro, lime and hot sauce, if desired.";
            f4.setText("Dinner (420 calories)");
            f4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f4.getText().toString().trim().contentEquals(string4)) {
                        f4.setText("Dinner (420 calories)");
                    }
                    else if (f4.getText().toString().trim().contentEquals("Dinner (420 calories)")) {
                        f4.setText(string4);
                    }
                }
            });

            //Evening Snack
            final String string5 = "";
            f5.setText("");
            f5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f5.getText().toString().trim().contentEquals(string5)) {
                        f5.setText("");
                    }
                    else if (f5.getText().toString().trim().contentEquals("")) {
                        f5.setText(string5);
                    }
                }
            });
        }
        else if (day_of_week.equals("Saturday")) {
            //f.setImageResource(R.drawable.d4);
            //Breakfast
            final String string0 = "Egg Toast\n" +
                    "• 1 slice whole-wheat bread, toasted\n" +
                    "• 1/4 medium avocado, mashed\n" +
                    "• 1 large egg, cooked in 1/4 tsp. olive oil or coat pan with a thin layer of cooking spray (1-second spray)\n" +
                    "• Top toast with avocado and egg.\n" +
                    "• 1 clementine";
            f0.setText("Breakfast (266 calories) ");
            f0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f0.getText().toString().trim().contentEquals(string0)) {
                        f0.setText("Breakfast (266 calories) ");
                    }
                    else if (f0.getText().toString().trim().contentEquals("Breakfast (266 calories) ")) {
                        f0.setText(string0);
                    }
                }
            });

            //AN Snack
            final String string1 = "• 1/2 green bell pepper, sliced\n" +
                    "• 2 Tbsp. hummus";
            f1.setText("A.M. Snack (64 calories)");
            f1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f1.getText().toString().trim().contentEquals(string1)) {
                        f1.setText("A.M. Snack (64 calories)");
                    }
                    else if (f1.getText().toString().trim().contentEquals("A.M. Snack (64 calories)")) {
                        f1.setText(string1);
                    }
                }
            });

            //Lunch
            final String string2 = "Apple & Cheddar Pita Pocket\n" +
                    "• 1 whole-wheat pita round (6-1/2-inch)\n" +
                    "• 1 Tbsp. mustard\n" +
                    "• 1/2 medium apple, sliced\n" +
                    "• 1 oz. Cheddar cheese\n" +
                    "• 1 cup mixed greens\n" +
                    "• Cut pita in half and spread mustard inside. Fill with apple slices and cheese. Toast until the cheese begins to melt. Add greens and serve.";
            f2.setText("Lunch (351 calories) ");
            f2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f2.getText().toString().trim().contentEquals(string2)) {
                        f2.setText("Lunch (351 calories) ");
                    }
                    else if (f2.getText().toString().trim().contentEquals("Lunch (351 calories) ")) {
                        f2.setText(string2);
                    }
                }
            });

            //P.M. Snack
            final String string3 = "• 1/2 medium apple\n" +
                    "• 4 walnut halves";
            f3.setText("P.M. Snack (100 calories)");
            f3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f3.getText().toString().trim().contentEquals(string3)) {
                        f3.setText("P.M. Snack (100 calories)");
                    }
                    else if (f3.getText().toString().trim().contentEquals("P.M. Snack (100 calories)")) {
                        f3.setText(string3);
                    }
                }
            });

            //Dinner
            final String string4 = "• 1 2/3 cups Vegetarian Tikka Masala\n" +
                    "• 1/2 cup brown rice\n" +
                    "• 2 cups spinach, steamed\n" +
                    "• 1/2 whole-wheat pita round (6-1/2-inch)";
            f4.setText("Dinner (438 calories)");
            f4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f4.getText().toString().trim().contentEquals(string4)) {
                        f4.setText("Dinner (438 calories)");
                    }
                    else if (f4.getText().toString().trim().contentEquals("Dinner (438 calories)")) {
                        f4.setText(string4);
                    }
                }
            });

            //Evening Snack
            final String string5 = "";
            f5.setText("");
            f5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f5.getText().toString().trim().contentEquals(string5)) {
                        f5.setText("");
                    }
                    else if (f5.getText().toString().trim().contentEquals("")) {
                        f5.setText(string5);
                    }
                }
            });
        }
        else if (day_of_week.equals("Sunday")) {
            //f.setImageResource(R.drawable.d6);
            //Breakfast
            final String string0 = "• 1 cup nonfat plain Greek yogurt\n" +
                    "• 1/2 cup muesli\n" +
                    "• 1/2 cup blueberries or other berries)\n" +
                    "• Top yogurt with berries and muesli.";
            f0.setText("Breakfast (264 calories)");
            f0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f0.getText().toString().trim().contentEquals(string0)) {
                        f0.setText("Breakfast (264 calories)");
                    }
                    else if (f0.getText().toString().trim().contentEquals("Breakfast (264 calories)")) {
                        f0.setText(string0);
                    }
                }
            });

            //AN Snack
            final String string1 = "• 1/2 cup cucumber slices)\n" +
                    "• 2 Tbsp. hummus";
            f1.setText("A.M. Snack (60 calories)");
            f1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f1.getText().toString().trim().contentEquals(string1)) {
                        f1.setText("A.M. Snack (60 calories)");
                    }
                    else if (f1.getText().toString().trim().contentEquals("A.M. Snack (60 calories)")) {
                        f1.setText(string1);
                    }
                }
            });

            //Lunch
            final String string2 = "Leftovers \n" +
                    "• 1 2/3 cups Vegetarian Tikka Masala\n" +
                    "• 1/2 whole-wheat pita round (6-1/2-inch)\n" +
                    "• 2 cups spinach, steamed";
            f2.setText("Lunch (329 calories)");
            f2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f2.getText().toString().trim().contentEquals(string2)) {
                        f2.setText("Lunch (329 calories)");
                    }
                    else if (f2.getText().toString().trim().contentEquals("Lunch (329 calories)")) {
                        f2.setText(string2);
                    }
                }
            });

            //P.M. Snack
            final String string3 = "• 1 medium apple\n" +
                    "• 4 walnut halves";
            f3.setText("P.M. Snack (147 calories)");
            f3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f3.getText().toString().trim().contentEquals(string3)) {
                        f3.setText("P.M. Snack (147 calories)");
                    }
                    else if (f3.getText().toString().trim().contentEquals("P.M. Snack (147 calories)")) {
                        f3.setText(string3);
                    }
                }
            });

            //Dinner
            final String string4 = "Pita \"Pizzas\" \n" +
                    "• 1 whole-wheat pita round (6-1/2-inch)\n" +
                    "• 1 small tomato, sliced\n" +
                    "• 1 oz. pearl mozzarella balls\n" +
                    "• 1 Tbsp. chopped fresh basil\n" +
                    "• Brush pita with 1 tsp. olive oil and top with tomato and mozzarella. Toast until cheese begins to melt. Top with basil just before serving.\n" +
                    "• 2 cups mixed greens\n" +
                    "• Top greens with 1/2 Tbsp. each olive oil & balsamic vinegar.";
            f4.setText("Dinner (394 calories)");
            f4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f4.getText().toString().trim().contentEquals(string4)) {
                        f4.setText("Dinner (394 calories)");
                    }
                    else if (f4.getText().toString().trim().contentEquals("Dinner (394 calories)")) {
                        f4.setText(string4);
                    }
                }
            });

            //Evening Snack
            final String string5 = "";
            f5.setText("");
            f5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f5.getText().toString().trim().contentEquals(string5)) {
                        f5.setText("");
                    }
                    else if (f5.getText().toString().trim().contentEquals("")) {
                        f5.setText(string5);
                    }
                }
            });
        }
        else if (day_of_week.equals("Monday")) {
            //f.setImageResource(R.drawable.d6);
            //Breakfast
            final String string0 = "Oatmeal with Fruit & Nuts \n" +
                    "• 1/2 cup oatmeal cooked in 1/2 skim milk and 1/2 cup water\n" +
                    "• 1/2 medium apple, diced\n" +
                    "• 1 Tbsp. chopped walnuts\n" +
                    "• Top oatmeal with apple, walnuts and a pinch of cinnamon.";
            f0.setText("Breakfast (297 calories)");
            f0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f0.getText().toString().trim().contentEquals(string0)) {
                        f0.setText("Breakfast (297 calories)");
                    }
                    else if (f0.getText().toString().trim().contentEquals("Breakfast (297 calories)")) {
                        f0.setText(string0);
                    }
                }
            });

            //AN Snack
            final String string1 = "• 1/2 medium apple";
            f1.setText("A.M. Snack (47 calories)");
            f1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f1.getText().toString().trim().contentEquals(string1)) {
                        f1.setText("A.M. Snack (47 calories)");
                    }
                    else if (f1.getText().toString().trim().contentEquals("A.M. Snack (47 calories)")) {
                        f1.setText(string1);
                    }
                }
            });

            //Lunch
            final String string2 = "• 2 Tomato-Cheddar Cheese Toasts\n" +
                    "• 2 cups mixed greens\n" +
                    "• 1/2 cup cucumber, sliced\n" +
                    "• 1/4 cup grated carrot\n" +
                    "• 1 Tbsp. chopped walnuts\n" +
                    "• Combine salad ingredients and top with 1/2 Tbsp. each olive oil & balsamic vinegar.";
            f2.setText("Lunch (316 calories)");
            f2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f2.getText().toString().trim().contentEquals(string2)) {
                        f2.setText("Lunch (316 calories)");
                    }
                    else if (f2.getText().toString().trim().contentEquals("Lunch (316 calories)")) {
                        f2.setText(string2);
                    }
                }
            });

            //P.M. Snack
            final String string3 = "• 2/3 cup nonfat plain Greek yogurt\n" +
                    "• 1/4 cup blueberries";
            f3.setText("P.M. Snack (109 calories)");
            f3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f3.getText().toString().trim().contentEquals(string3)) {
                        f3.setText("P.M. Snack (109 calories)");
                    }
                    else if (f3.getText().toString().trim().contentEquals("P.M. Snack (109 calories)")) {
                        f3.setText(string3);
                    }
                }
            });

            //Dinner
            final String string4 = "• 1 1/2 cups Farmers' Market Fried Rice";
            f4.setText("Dinner (400 calories)");
            f4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f4.getText().toString().trim().contentEquals(string4)) {
                        f4.setText("Dinner (400 calories)");
                    }
                    else if (f4.getText().toString().trim().contentEquals("Dinner (400 calories)")) {
                        f4.setText(string4);
                    }
                }
            });

            //Evening Snack
            final String string5 = "• 1 Tbsp. chocolate chips, preferably dark chocolate";
            f5.setText("Evening Snack (50 calories)");
            f5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (f5.getText().toString().trim().contentEquals(string5)) {
                        f5.setText("Evening Snack (50 calories)");
                    }
                    else if (f5.getText().toString().trim().contentEquals("Evening Snack (50 calories)")) {
                        f5.setText(string5);
                    }
                }
            });
        }
    }

    private String getDayOfWeek(int value) {
        String day = "";
        switch (value) {
            case 1:
                day = "Sunday";
                break;
            case 2:
                day = "Monday";
                break;
            case 3:
                day = "Tuesday";
                break;
            case 4:
                day = "Wednesday";
                break;
            case 5:
                day = "Thursday";
                break;
            case 6:
                day = "Friday";
                break;
            case 7:
                day = "Saturday";
                break;
        }
        return day;
    }

}
