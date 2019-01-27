package dev.reece.cathayhomework.main.areainfo;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import java.util.ArrayList;

import dev.reece.cathayhomework.R;
import dev.reece.cathayhomework.main.areainfo.data.IAreaInfoItem;
import dev.reece.cathayhomework.main.navigator.OnToPlantPageListener;

/**
 * Created by reececheng on 2019/1/26.
 */

public class AreaInfoView extends ConstraintLayout implements AreaInfoContract.View {

    private RecyclerView mRecyclerView;
    private AreaInfoAdapter mAdapter;

    public AreaInfoView(Context context) {
        super(context);
        init();
    }

    public AreaInfoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AreaInfoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.area_info_layout, this);

        mRecyclerView = findViewById(R.id.area_recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.addItemDecoration(new AreaInfoDecoration());

        mAdapter = new AreaInfoAdapter();
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void showAreaInfo(ArrayList<IAreaInfoItem> data) {
        mAdapter.setData(data);
    }

    @Override
    public void showError() {

    }

    public void setOnToPlantPageListener(OnToPlantPageListener listener) {
        mAdapter.setOnToPlantPageListener(listener);
    }
}
