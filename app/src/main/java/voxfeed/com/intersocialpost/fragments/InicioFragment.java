package voxfeed.com.intersocialpost.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import voxfeed.com.intersocialpost.R;

/**
 * Created by rjasso on 02/02/2017.
 */

public class InicioFragment extends Fragment {
    public InicioFragment() {
    }

    public static InicioFragment newInstance() {
        return new InicioFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_inicio, container, false);
        return rootView;
    }
}
