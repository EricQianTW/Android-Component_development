/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ericshenn.baselibrary.base;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.List;

/**
 * This provides methods to help Activities load their UI.
 */
public class ActivityUtils {

    /**
     * The {@code fragment} is added to the container view with id {@code frameId}. The operation is
     * performed by the {@code fragmentManager}.
     *
     */
    public static void addFragmentToActivity (FragmentManager fragmentManager,
                                              Fragment fragment, int frameId) {
//        checkNotNull(fragmentManager);
//        checkNotNull(fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(frameId, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    /**
     * The {@code fragment} is added to the container view with id {@code frameId}. The operation is
     * performed by the {@code fragmentManager}.
     *
     */
    public static void addFragmentToActivity (FragmentManager fragmentManager,
                                              List<Fragment> fragmentArray, List<Integer> frameIdArray) {
//        checkNotNull(fragmentManager);
//        for (Fragment item : fragmentArray) {
//            checkNotNull(item);
//        }

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        for(int i = 0; i < fragmentArray.size(); i++){
            transaction.replace(frameIdArray.get(i), fragmentArray.get(i));
        }
        transaction.commit();
    }

    /**
     * The {@code fragment} is added to the container view with id {@code frameId}. The operation is
     * performed by the {@code fragmentManager}.
     *
     */
    public static void addFragmentToFragment (FragmentManager fragmentManager,
                                              List<Fragment> fragmentArray, List<Integer> frameIdArray) {
//        checkNotNull(fragmentManager);
//        for (Fragment item : fragmentArray) {
//            checkNotNull(item);
//        }

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        for(int i = 0; i < fragmentArray.size(); i++){
            transaction.replace(frameIdArray.get(i), fragmentArray.get(i));
        }
        transaction.commitAllowingStateLoss();
    }

    /**
     * The {@code fragment} is added to the container view with id {@code frameId}. The operation is
     * performed by the {@code fragmentManager}.
     *
     */
    public static void replaceFragmentFromActivity (FragmentManager fragmentManager,
                                                    int id, @NonNull Fragment fragment) {
//        checkNotNull(fragmentManager);
//        checkNotNull(fragment);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if(!fragment.isAdded()){
            transaction.replace(id,fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }else {
            transaction.show(fragment);
        }
    }

    /**
     * The {@code fragment} is added to the container view with id {@code frameId}. The operation is
     * performed by the {@code fragmentManager}.
     *
     */
    public static void removeFragmentFromActivity (FragmentManager fragmentManager, Fragment fragment) {
//        checkNotNull(fragmentManager);
//        checkNotNull(fragment);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.remove(fragment);
        transaction.commit();
    }
}
