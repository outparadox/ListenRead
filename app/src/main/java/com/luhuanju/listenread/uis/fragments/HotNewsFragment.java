package com.luhuanju.listenread.uis.fragments;/*
 * —————————————————————–
 * Copyright (C) 2016，上海宅米贸易有限公司， All rights reserved.
 * —————————————————————–
 * Author: luhuanju
 * 热点新闻Fragment
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.luhuanju.listenread.R;
import com.luhuanju.listenread.presenters.IHotNewsFragmentPresenter;
import com.luhuanju.listenread.presenters.impls.HotNewsFragmentPresenter;
import com.luhuanju.listenread.uis.IHotNewsFragmentVu;
import com.tuesda.walker.circlerefresh.CircleRefreshLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class HotNewsFragment extends Fragment implements IHotNewsFragmentVu, CircleRefreshLayout.OnCircleRefreshListener {
    @InjectView(R.id.list)
    ListView mList;
    CircleRefreshLayout mRefreshLayout;
//    @InjectView(R.id.hotnews_recy)
//    RecyclerView mShowDataRecy;


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
                mIHotNewsFragmentPresenter.onShowDataOnP(getActivity());
            }
        });
        initData(view);


        String[] strs = {
                "The",
                "Canvas",
                "class",
                "holds",
                "the",
                "draw",
                "calls",
                ".",
                "To",
                "draw",
                "something,",
                "you",
                "need",
                "4 basic",
                "components",
                "Bitmap",
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, strs);
        mList.setAdapter(adapter);
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
        mIHotNewsFragmentPresenter = mIHotNewsFragmentPresenter != null ? mIHotNewsFragmentPresenter : new HotNewsFragmentPresenter(getActivity(), this);
        mIHotNewsFragmentPresenter.onShowDataOnP(getActivity());
    }
}
