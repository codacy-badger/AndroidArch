package com.noisyninja.androidlistpoc.views.custom

import android.databinding.DataBindingUtil
import android.support.annotation.NonNull
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.noisyninja.androidlistpoc.R
import com.noisyninja.androidlistpoc.databinding.ListMainBinding
import com.noisyninja.androidlistpoc.model.Me
import com.noisyninja.androidlistpoc.views.IMainPresenter


/**
 * main adapter for sticky grids layout
 * Created by sudiptadutta on 12/05/18.
 */

class MainAdapter(private val mResultsList: ArrayList<Me>, private val mIMainPresenter: IMainPresenter) : RecyclerView.Adapter<MainAdapter.MeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MeViewHolder {
        val inflater = LayoutInflater.from(parent?.context)
        val binding = DataBindingUtil.inflate<ListMainBinding>(inflater, R.layout.list_main, parent, false)
        return MeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mResultsList.size
    }

    override fun onBindViewHolder(viewHolder: MeViewHolder, position: Int) {
        val me = mResultsList[position]
        viewHolder.bind(me, mIMainPresenter)
    }


    inner class MeViewHolder(private val mListMainBinding: ListMainBinding) : RecyclerView.ViewHolder(mListMainBinding.root) {
        fun bind(@NonNull me: Me, @NonNull mainPresenter: IMainPresenter) {
            mListMainBinding.me = me
            mListMainBinding.mainPresenter = mainPresenter
            mListMainBinding.executePendingBindings()
        }
    }
}
