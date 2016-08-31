package com.gencat.kitchenite;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.gencat.kitchenite.model.FeedAdapter;
import com.gencat.kitchenite.model.Fixtures;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // Get the intent, verify the action and get the query
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            getSupportActionBar().setTitle("Cari: " + query);
        }

        ListView listView = (ListView) findViewById(R.id.feed_list);
        listView.setAdapter(new FeedAdapter(getApplicationContext(), Fixtures.getSearchResult())); //TODO

    }
}
