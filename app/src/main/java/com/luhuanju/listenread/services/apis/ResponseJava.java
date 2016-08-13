//package com.luhuanju.listenread.services.apis;/*
// * Copyright (C) 2016，上海宅米贸易有限公司
// *
// * Author: huanjulu on 16/8/12
// */
//
//import retrofit.RetrofitError;
//import retrofit.client.Response;
//
///**
// * Communicates responses from a server or offline requests. One and only one method will be
// * invoked in response to a given request.
// * <p>
// * specified, the following defaults are used:
// * <ul>
// * <li>Android: Callbacks are executed on the application's main (UI) thread.</li>
// * <li>JVM: Callbacks are executed on the background thread which performed the request.</li>
// * </ul>
// *
// * @param <T> expected response type
// */
//public interface ResponseJava<T> {
//
//    /** Successful HTTP response. */
//    void success(T t, Response response);
//
//    /**
//     * Unsuccessful HTTP response due to network failure, non-2XX status code, or unexpected
//     * exception.
//     */
//    void failure(RetrofitError error);
//}