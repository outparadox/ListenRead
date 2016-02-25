package com.luhuanju.listenread.presenters;/*
 * —————————————————————–
 * Copyright (C) 2016，上海宅米贸易有限公司， All rights reserved.
 * —————————————————————–
 * Author: luhuanju
 * presenter基类
 */

public interface IPersenter {

     /**
      * when presenter is start()
      */
     public abstract void baseStart();

     /**
      * when presenter is finish()
      */
     public abstract void baseFinish();
}
