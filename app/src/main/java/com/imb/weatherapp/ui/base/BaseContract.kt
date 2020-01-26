package com.imb.weatherapp.ui.base

class BaseContract {

    interface Presenter<in T> {
        fun attach(view: T)
    }

}