package com.noisyninja.androidlistpoc.views

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.annotation.Nullable
import android.support.v7.app.AppCompatActivity
import com.noisyninja.androidlistpoc.NinjaApp
import com.noisyninja.androidlistpoc.R
import com.noisyninja.androidlistpoc.layers.UtilModule
import com.noisyninja.androidlistpoc.layers.database.viewmodel.MeViewModel
import com.noisyninja.androidlistpoc.layers.database.viewmodel.ViewModelFactory
import com.noisyninja.androidlistpoc.model.Me
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

/**
 * main presenter
 * Created by sudiptadutta on 12/05/18.
 */

class MainPresenter internal constructor(private val iMainActivity: IMainActivity, private val ninjaApp: NinjaApp) : IMainPresenter {

    @Inject
    lateinit var vmf: ViewModelFactory
    @Inject
    lateinit var util: UtilModule

    var meViewModel: MeViewModel

    init {
        ninjaApp.ninjaComponent.inject(this)
        meViewModel = ViewModelProviders.of(iMainActivity as AppCompatActivity, vmf).get(MeViewModel::class.java)
    }

    /**
     * fetches the list of users from viewmodel which also acts as the database/network repository
     */
    override fun getList() {

        meViewModel.getMe().
                observe(iMainActivity as AppCompatActivity, object : Observer<List<Me>> {
                    override fun onChanged(@Nullable result: List<Me>?) {
                        //meViewModel.getMe().removeObserver(this)//to not update
                        handleResponse(result)
                    }
                })
    }

    /**
     * opens detail activity
     */
    override fun showDetail(me: Me) {
        val intent = Intent(ninjaApp, DetailActivity::class.java)
        intent.putExtra(util.getStringRes(R.string.user_id_key), me.name.first)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        ninjaApp.startActivity(intent)
    }

    /**
     * reverses list order
     */
    override fun reverseList(arrayList: ArrayList<ArrayList<Me>>): ArrayList<ArrayList<Me>> {
        Collections.reverse(arrayList)
        return ArrayList(arrayList)
    }

    /**
     * handle response
     */
    fun handleResponse(result: List<Me>?) {
        if (result == null) {
            util.logI("null response")
            iMainActivity.setList(ArrayList())
        } else {
            util.logI("got response")

            val array: ArrayList<ArrayList<Me>> = makeGridLayoutReady(result)
            //ninjaComponent.util().logI(ninjaComponent.util().toJson(array))
            iMainActivity.setList(array)
        }
    }

    /**
     * this creates a nested array of users for the gridlayout and sticky headers
     */
    fun makeGridLayoutReady(result: List<Me>): ArrayList<ArrayList<Me>> {
        val array: ArrayList<ArrayList<Me>> = ArrayList()
        var array2: ArrayList<Me> = ArrayList()
        var counter = 0
        var pageCount = 0
        for (me: Me in result) {
            me.page = pageCount
            array2.add(me)
            counter++
            if (counter % 9 == 0) {
                pageCount++
                array.add(array2)
                array2 = ArrayList()
            }
        }
        if (array.size < counter) {//adding leftovers
            array.add(array2)
        }
        return array
    }


}
