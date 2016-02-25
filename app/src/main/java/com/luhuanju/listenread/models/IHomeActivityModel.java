package com.luhuanju.listenread.models;/*
 * —————————————————————–
 * Copyright (C) 2016，上海宅米贸易有限公司， All rights reserved.
 * —————————————————————–
 * Author: luhuanju
 */

import com.luhuanju.listenread.uis.activitys.HomeActivity;

public interface IHomeActivityModel {

  /*  public abstract void onShowHotNewsUi();

    public abstract void onShowTransceiverUi();

    public abstract void onShowWeeklyUi();

    public abstract void onShowSettingsUi();*/

    <T> T getObjectComponentOnM(HomeActivity context);

}
