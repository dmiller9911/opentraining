/**
 * 
 * This is OpenTraining, an Android application for planning your your fitness training.
 * Copyright (C) 2012 Christian Skubich
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */

package de.skubware.opentraining;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;


/**
 * Activity to start {@link ExerciseListFragment}. 
 * Most code here auto-generated by template of eclipse.
 * 
 */
public class ExerciseListActivity extends FragmentActivity
        implements ExerciseListFragment.Callbacks {

    private boolean mTwoPane;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise_list);

        if (findViewById(R.id.exercise_detail_container) != null) {
            mTwoPane = true;
            ((ExerciseListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.exercise_list))
                    .setActivateOnItemClick(true);
        }
    }

    @Override
    public void onItemSelected(String id) {
		if (mTwoPane) {
			Bundle arguments = new Bundle();
			arguments.putString(ExerciseDetailFragment.ARG_ITEM_ID, id);
			ExerciseDetailFragment fragment = new ExerciseDetailFragment();
			fragment.setArguments(arguments);
			getSupportFragmentManager().beginTransaction().replace(R.id.exercise_detail_container, fragment).commit();

		} else {
            Intent detailIntent = new Intent(this, ExerciseDetailActivity.class);
            detailIntent.putExtra(ExerciseDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }
    }
}
