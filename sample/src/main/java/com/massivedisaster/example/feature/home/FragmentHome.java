/*
 * ActivityFragmentManager - A library to help android developer working easily with activities and fragments.
 *
 * Copyright (c) 2017 ActivityFragmentManager
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.massivedisaster.example.feature.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.massivedisaster.activitymanager.ActivityFragmentManager;
import com.massivedisaster.adal.fragment.AbstractBaseFragment;
import com.massivedisaster.example.activity.ActivityFullscreen;
import com.massivedisaster.example.activity.ActivityToolbar;
import com.massivedisaster.example.activitymanager.R;
import com.massivedisaster.example.feature.navigation.FragmentAddReplace;
import com.massivedisaster.example.feature.sharedelements.FragmentSharedElementsOptions;

import static com.massivedisaster.activitymanager.ActivityFragmentManager.open;

/**
 * Fragment Home
 */
public class FragmentHome extends AbstractBaseFragment implements View.OnClickListener {

    @Override
    protected int layoutToInflate() {
        return R.layout.fragment_home;
    }

    @Override
    protected void getFromBundle(Bundle bundle) {

    }

    @Override
    protected void restoreInstanceState(@Nullable Bundle savedInstanceState) {

    }

    @Override
    protected void doOnCreated() {
        getActivity().setTitle(getString(R.string.home));

        Button btnSharedElements = findViewById(R.id.btnSharedElements);
        Button btnOpenFragmentOtherActivity = findViewById(R.id.btnOpenFragmentOtherActivity);
        Button btnOpenFragmentOtherActivityFullscreen = findViewById(R.id.btnOpenFragmentOtherActivityFullscreen);
        Button btnOpenFragmentOtherActivityWithCustomAnimation = findViewById(R.id.btnOpenFragmentOtherActivityWithCustomAnimation);

        btnOpenFragmentOtherActivity.setOnClickListener(this);
        btnOpenFragmentOtherActivityFullscreen.setOnClickListener(this);
        btnOpenFragmentOtherActivityWithCustomAnimation.setOnClickListener(this);
        btnSharedElements.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnOpenFragmentOtherActivity:
                open(getActivity(), ActivityToolbar.class, FragmentAddReplace.class)
                        .commit();
                break;
            case R.id.btnOpenFragmentOtherActivityFullscreen:
                open(getActivity(), ActivityFullscreen.class, FragmentAddReplace.class)
                        .commit();
                break;
            case R.id.btnOpenFragmentOtherActivityWithCustomAnimation:
                open(getActivity(), ActivityToolbar.class, FragmentAddReplace.class)
                        .commit();
                break;
            case R.id.btnSharedElements:
                ActivityFragmentManager.open(getActivity(), ActivityToolbar.class, FragmentSharedElementsOptions.class)
                        .commit();
                break;
            default:
                break;
        }
    }
}
