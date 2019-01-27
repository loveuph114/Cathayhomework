package dev.reece.cathayhomework.welcome;

import dev.reece.cathayhomework.data.model.AreaPlantData;

/**
 * Created by reececheng on 2019/1/24.
 */

public class WelcomeContract {

    interface View {
        void loadCompleted(AreaPlantData data);
        void showError();
    }

    interface Presenter {
        void loadData();
        void onDestroy();
    }
}
