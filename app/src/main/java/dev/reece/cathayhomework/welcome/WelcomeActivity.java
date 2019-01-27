package dev.reece.cathayhomework.welcome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import dev.reece.cathayhomework.data.api.ApiClient;
import dev.reece.cathayhomework.data.api.ApiService;
import dev.reece.cathayhomework.R;
import dev.reece.cathayhomework.data.model.Area;
import dev.reece.cathayhomework.data.model.AreaPlantData;
import dev.reece.cathayhomework.main.MainActivity;
import io.reactivex.disposables.CompositeDisposable;

public class WelcomeActivity extends AppCompatActivity implements WelcomeContract.View {
    private WelcomePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_layout);

        ApiService apiService = ApiClient.getApiService();
        WelcomeRepository repository = new WelcomeRepository(apiService);

        CompositeDisposable compositeDisposable = new CompositeDisposable();
        mPresenter = new WelcomePresenter(this, repository, compositeDisposable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.loadData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    public void loadCompleted(AreaPlantData data) {
        Intent it = new Intent(this, MainActivity.class);
        it.putExtra(MainActivity.ARGS_KEY_AREA_PLANT_DATA, data);
        startActivity(it);

        finish();
    }

    @Override
    public void showError() {

    }
}
