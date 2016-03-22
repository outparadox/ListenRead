package com.luhuanju.listenread.uis.fragments;/*
 * —————————————————————–
 * Copyright (C) 2016，上海宅米贸易有限公司， All rights reserved.
 * —————————————————————–
 * Author: luhuanju
 * 热点新闻Fragment
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.luhuanju.listenread.R;
import com.luhuanju.listenread.entity.HotNewsEntity;
import com.luhuanju.listenread.models.impls.HotNewsFragmentModel;
import com.luhuanju.listenread.presenters.IHotNewsFragmentPresenter;
import com.luhuanju.listenread.presenters.impls.HotNewsFragmentPresenter;
import com.luhuanju.listenread.uis.IHotNewsFragmentVu;
import com.tuesda.walker.circlerefresh.CircleRefreshLayout;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class HotNewsFragment extends Fragment implements IHotNewsFragmentVu, CircleRefreshLayout.OnCircleRefreshListener, HotNewsFragmentModel.HotNewsEntityPOJOCallBack {
    @InjectView(R.id.list)
    ListView mList;
    CircleRefreshLayout mRefreshLayout;
//    @InjectView(R.id.hotnews_recy)
//    RecyclerView mShowDataRecy;

    private String mData[];

    private HotNewsFragmentModel mHotNewsFragmentModel = null;
    private IHotNewsFragmentPresenter mIHotNewsFragmentPresenter = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_hotnews, null);
        mRefreshLayout = (CircleRefreshLayout) view.findViewById(R.id.hotnews_refresh);
        view.findViewById(R.id.textView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIHotNewsFragmentPresenter.onShowDataOnP(getActivity(), mList);
            }
        });

        initData(view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


    @Override
    public void onShowCarouse() {

    }

    @Override
    public void onShowData() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void completeRefresh() {

    }

    @Override
    public void refreshing() {

    }

    private void initData(View view) {

        ButterKnife.inject(this, view);
        //绕过了PRESENTER
        mHotNewsFragmentModel = new HotNewsFragmentModel(getActivity(), mList);
        mHotNewsFragmentModel.setHotNewsEntityPOJOListener(this);

        mIHotNewsFragmentPresenter = mIHotNewsFragmentPresenter != null ? mIHotNewsFragmentPresenter : new HotNewsFragmentPresenter(getActivity(), this);
        mIHotNewsFragmentPresenter.onShowDataOnP(getActivity(), mList);


    }


    @Override
    public void onHotNewsEntityPOJOSuccess(List<HotNewsEntity> hotNewsEntities, FragmentActivity activity, ListView listView) {
        mData = new String[hotNewsEntities.size()];
        for (int m = 0; m < hotNewsEntities.size(); m++) {
            mData[m] = hotNewsEntities.get(m).getTitle();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, mData);
        listView.setAdapter(adapter);
    }

    @Override
    public void onHotNewsEntityPOJOFailed() {

    }
}
