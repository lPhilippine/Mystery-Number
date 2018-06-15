package com.example.philippine.mysterynumber;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by philippine on 14/06/2018.
 */

public class GameFragment extends Fragment {

    private MainActivity mActivity;

    private int x;
    private int life;
    private int games;
    private int win;
    private int restart = 1;
    private int new_game = 0;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_game, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (MainActivity) context;
    }
}
