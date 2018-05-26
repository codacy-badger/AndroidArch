package com.noisyninja.androidlistpoc.views.custom

import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import com.codewaves.stickyheadergrid.StickyHeaderGridAdapter
import com.noisyninja.androidlistpoc.R
import com.noisyninja.androidlistpoc.databinding.ListHeaderBinding
import com.noisyninja.androidlistpoc.databinding.ListMainBinding
import com.noisyninja.androidlistpoc.model.Me
import com.noisyninja.androidlistpoc.views.IMainPresenter


/**
 * main adapter for sticky grids layout
 * Created by sudiptadutta on 12/05/18.
 */

class MainAdapter(private val mResultsList: ArrayList<ArrayList<Me>>, private val mIMainPresenter: IMainPresenter) : StickyHeaderGridAdapter() {

    override fun onBindItemViewHolder(viewHolder: ItemViewHolder?, section: Int, offset: Int) {
        val vh = viewHolder as MeViewHolder
        vh.mListDetailBinding.me = mResultsList[section][offset]
        vh.mListDetailBinding.mainPresenter = mIMainPresenter
        vh.mListDetailBinding.executePendingBindings()
    }

    override fun onBindHeaderViewHolder(viewHolder: HeaderViewHolder?, section: Int) {
        val vh = viewHolder as MeHeaderViewHolder
        vh.mListHeaderBinding.me = mResultsList[section][0]
        vh.mListHeaderBinding.mainPresenter = mIMainPresenter
        vh.mListHeaderBinding.executePendingBindings()
    }

    override fun getSectionCount(): Int {
        return mResultsList.size
    }

    override fun getSectionItemCount(section: Int): Int {
        return mResultsList[section].size
    }

    override fun onCreateHeaderViewHolder(parent: ViewGroup?, headerType: Int): HeaderViewHolder {
        val inflater = LayoutInflater.from(parent?.context)
        val binding = DataBindingUtil.inflate<ListHeaderBinding>(inflater, R.layout.list_header, parent, false)
        return MeHeaderViewHolder(binding)
    }

    override fun onCreateItemViewHolder(parent: ViewGroup?, itemType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent?.context)
        val binding = DataBindingUtil.inflate<ListMainBinding>(inflater, R.layout.list_main, parent, false)
        return MeViewHolder(binding)
    }

    inner class MeViewHolder(val mListDetailBinding: ListMainBinding) : ItemViewHolder(mListDetailBinding.root)

    inner class MeHeaderViewHolder(val mListHeaderBinding: ListHeaderBinding) : HeaderViewHolder(mListHeaderBinding.root)
}
