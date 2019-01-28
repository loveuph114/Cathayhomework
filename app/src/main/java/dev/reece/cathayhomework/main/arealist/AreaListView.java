package dev.reece.cathayhomework.main.arealist;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;

import dev.reece.cathayhomework.R;
import dev.reece.cathayhomework.data.model.Area;
import dev.reece.cathayhomework.main.navigator.OnToAreaPageListener;

/**
 * Created by reececheng on 2019/1/24.
 */

public class AreaListView extends ConstraintLayout implements AreaListContract.View {

    private RecyclerView mRecyclerView;
    private AreaListAdapter mAdapter;

    public AreaListView(Context context) {
        super(context);
        init();
    }

    public AreaListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AreaListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.area_list_layout, this);

        mRecyclerView = findViewById(R.id.list_recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.addItemDecoration(new AreaListDecoration());
        mRecyclerView.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(getContext(), R.anim.layout_animation_up));

        mAdapter = new AreaListAdapter();
        mRecyclerView.setAdapter(mAdapter);
    }

    public void setOnToAreaPageListener(OnToAreaPageListener listener) {
        mAdapter.setOnToAreaPageListener(listener);
    }

    @Override
    public void showList(ArrayList<Area> data) {
        mAdapter.setData(data);
    }

}
