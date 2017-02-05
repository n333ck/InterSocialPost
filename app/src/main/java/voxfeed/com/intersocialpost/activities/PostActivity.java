package voxfeed.com.intersocialpost.activities;

/**
 * Created by rjasso on 02/02/2017.
 */

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import voxfeed.com.intersocialpost.R;
import voxfeed.com.intersocialpost.adapters.StatsAdapter;
import voxfeed.com.intersocialpost.model.PostFull;
import voxfeed.com.intersocialpost.model.StatsItem;
import voxfeed.com.intersocialpost.presenters.PostActivityPresenter;
import voxfeed.com.intersocialpost.presenters.PostActivityPresenterImpl;
import voxfeed.com.intersocialpost.presenters.PostActivityView;

public class PostActivity extends AppCompatActivity implements PostActivityView{
    @BindView(R.id.brand_image) ImageView mBrandImage;
    @BindView(R.id.brand_textview) TextView mBrandTextView;
    @BindView(R.id.title) TextView mTitleTextView;
    @BindView(R.id.earnings) TextView mEarningsTextView;
    @BindView(R.id.constrain_layout) ConstraintLayout mConstraintLayout;
    @BindView(R.id.stats_recycler_view) RecyclerView mRecyclerView;
    @BindView(R.id.ver_publicacion_textview) TextView mVerPublicacion;

    private Context mContext;
    final List<Target> mTargets = new ArrayList<>();
    private PostActivityPresenter mPostActivityPresenter;
    private StatsAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_post);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        final PostFull post = intent.getParcelableExtra(getString(R.string.post_bundle));
        mContext = this;

        if (post != null) {
            Picasso.with(this).load(post.getBrand().getLogo()).into(mBrandImage);
            mBrandTextView.setText(post.getBrand().getName());
            mTitleTextView.setText(post.getCampaign().getName());

            double earnings = post.getEarnings();
            DecimalFormat df = new DecimalFormat(getString(R.string.zero));
            String formatted = df.format(earnings);
            mEarningsTextView.setText(String.valueOf(getString(R.string.dolar) + formatted + getString(R.string.usd)));

            final Target target = new Target(){

                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(mContext.getResources(), bitmap);
                    mConstraintLayout.setBackground(bitmapDrawable);
                    mTargets.remove(this);
                }

                @Override
                public void onBitmapFailed(final Drawable errorDrawable) {
                    mTargets.remove(this);
                }

                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onPrepareLoad(final Drawable placeHolderDrawable) {
                    mConstraintLayout.setBackground(placeHolderDrawable);
                }
            };
            mTargets.add(target);
            Picasso.with(getApplicationContext()).load(post.getCampaign().getCoverImage()).into(target);
        }

        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(), linearLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);

        mPostActivityPresenter = new PostActivityPresenterImpl(this);
        mPostActivityPresenter.loadPosts(post.getStats());
        mPostActivityPresenter.getSocialColor(post.getSocialNetwork());

        mVerPublicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPostActivityPresenter.openBrowser(post.getPost().getLink());
            }
        });
    }

    @Override
    public void updatePosts(List<StatsItem> stats) {
        mAdapter = new StatsAdapter(stats);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void updateTextVerPublicacion(String text, int color) {
        mVerPublicacion.setText(text);
        mVerPublicacion.setTextColor(color);
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

    @Override
    public void openBrowser(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        } else {
            startActivity(intent);
        }
    }

}
