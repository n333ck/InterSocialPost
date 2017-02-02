package voxfeed.com.intersocialpost.activities;

/**
 * Created by rjasso on 02/02/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import voxfeed.com.intersocialpost.R;
import voxfeed.com.intersocialpost.model.Post;

public class PostActivity extends AppCompatActivity {
    @BindView(R.id.textview)
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        Post post = intent.getParcelableExtra(getString(R.string.post_bundle));

        //TODO Fix Parcelable
        if (post != null) {
            mTextView.setText(post.getSocialNetwork());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
