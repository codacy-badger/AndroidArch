package com.noisyninja.androidlistpoc.views


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.noisyninja.androidlistpoc.R
import kotlinx.android.synthetic.main.activity_detail.*


open class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)
        val userId = intent.getStringExtra(getString(R.string.user_id_key))
        loadUser(userId)
    }

    fun loadUser(userId: String?) {
        //todo get user from repository!
    }

}
