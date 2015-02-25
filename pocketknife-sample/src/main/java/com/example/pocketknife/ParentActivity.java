package com.example.pocketknife;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import pocketknife.InjectExtra;
import pocketknife.PocketKnife;
import pocketknife.SaveState;

public class ParentActivity extends FragmentActivity {

    public static final String PARENT_EXTRA = "PARENT_EXTRA";

    @InjectExtra(PARENT_EXTRA)
    int parentExtra;

    @SaveState
    int paInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.simple_activity);
        PocketKnife.injectExtras(this);

        PocketKnife.restoreInstanceState(this, savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        PocketKnife.saveInstanceState(this, outState);
    }
}
