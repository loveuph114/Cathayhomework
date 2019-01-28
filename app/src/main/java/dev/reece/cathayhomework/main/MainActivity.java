package dev.reece.cathayhomework.main;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import dev.reece.cathayhomework.R;
import dev.reece.cathayhomework.data.model.AreaPlantData;
import dev.reece.cathayhomework.main.arealist.AreaListFragment;
import dev.reece.cathayhomework.main.navigator.IToolbarController;
import dev.reece.cathayhomework.main.navigator.Navigator;

/**
 * Created by reececheng on 2019/1/24.
 */

public class MainActivity extends AppCompatActivity implements IToolbarController {

    public static final String ARGS_KEY_AREA_PLANT_DATA = MainActivity.class.getSimpleName() + "area_plant_data";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        if(getIntent().getExtras() != null && getIntent().getExtras().containsKey(ARGS_KEY_AREA_PLANT_DATA)) {
            AreaPlantData data = getIntent().getExtras().getParcelable(ARGS_KEY_AREA_PLANT_DATA);

            DataManager.getInstance().setData(data);

            Navigator.newInstance()
                    .fragment(new AreaListFragment())
                    .isAddToBack(false)
                    .navigate(this);

            setupBackStackChange();
        } else {
            // TODO handle error
        }

    }

    private void setupBackStackChange() {
        getFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                Fragment fragment = getFragmentManager().findFragmentById(R.id.main_container);
                if(fragment instanceof BaseFragment) {
                    ((BaseFragment) fragment).onVisible();
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            if(getFragmentManager().getBackStackEntryCount() > 0) {
                onBackPressed();
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setToolbar(String title, boolean displayHomeAsUpEnabled) {
        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
            getSupportActionBar().setDisplayHomeAsUpEnabled(displayHomeAsUpEnabled);
        }
    }

}
