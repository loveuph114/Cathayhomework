package dev.reece.cathayhomework.main.areainfo;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import dev.reece.cathayhomework.R;
import dev.reece.cathayhomework.main.areainfo.data.IAreaInfoItem;
import dev.reece.cathayhomework.main.navigator.OnToPlantPageListener;

/**
 * Created by reececheng on 2019/1/26.
 */

public class AreaInfoView extends ConstraintLayout implements AreaInfoContract.View {

    private ProgressBar mProgressBar;
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

        mProgressBar = findViewById(R.id.area_info_progressbar);

        mRecyclerView = findViewById(R.id.area_info_recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.addItemDecoration(new AreaInfoDecoration());

        mAdapter = new AreaInfoAdapter();
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showAreaInfo(ArrayList<IAreaInfoItem> data) {
        mProgressBar.setVisibility(GONE);
        mAdapter.setData(data);
    }

    @Override
    public void showError() {
        mProgressBar.setVisibility(GONE);
        Toast.makeText(getContext(), R.string.loading_error, Toast.LENGTH_SHORT).show();
    }

    public void setOnToPlantPageListener(OnToPlantPageListener listener) {
        mAdapter.setOnToPlantPageListener(listener);
    }
}
