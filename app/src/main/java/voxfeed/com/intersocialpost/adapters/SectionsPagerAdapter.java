package voxfeed.com.intersocialpost.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import voxfeed.com.intersocialpost.R;
import voxfeed.com.intersocialpost.fragments.InicioFragment;
import voxfeed.com.intersocialpost.fragments.PostFragment;

/**
 * Created by rjasso on 02/02/2017.
 */

public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return InicioFragment.newInstance();
            case 1:
                return PostFragment.newInstance();
        }
        return InicioFragment.newInstance();
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.inicio);
            case 1:
                return mContext.getString(R.string.publicaciones);
        }
        return null;
    }
}