package dev.reece.cathayhomework.main.plant;

import dev.reece.cathayhomework.data.model.Plant;

/**
 * Created by reececheng on 2019/1/27.
 */

public interface PlantInfoContract {
    interface View {
        void showPlantInfo(Plant plant);
    }

    // no need presenter ...
}
