package com.noisyninja.androidlistpoc.views

import com.noisyninja.androidlistpoc.model.Me

/**
 * presenter interface
 * Created by sudiptadutta on 12/05/18.
 */
interface IMainPresenter {
    fun showDetail(me: Me)
    fun getList()
    fun reverseList(arrayList: ArrayList<ArrayList<Me>>): ArrayList<ArrayList<Me>>
}