package com.cleansample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.data.DataClass
import com.domain.DomainClass
import com.domain.model.User
import com.domain.usecase.GetIUserUseCase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mDomainClass: DomainClass
    @Inject
    lateinit var mDataClass: DataClass

    @Inject
    lateinit var userUseCase: GetIUserUseCase
    @Inject
    lateinit var factory: ActivityViewModelFactory

    lateinit var viewModel: ActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppClass.getAppComp().inject(this)


        viewModel = ViewModelProviders.of(this, factory).get(ActivityViewModel::class.java)

        viewModel.hitAPI()

        viewModel.obUser.observe(this, Observer {
            initAdapter(this, it)
        })

        viewModel.obLoader.observe(this, Observer {
            when (it) {
                true -> progress.visibility = View.VISIBLE
                else -> progress.visibility = View.GONE
            }
        })
    }

    fun initAdapter(context: Context?, users: List<User>) {
        list.adapter = UsersAdapter(users)
        list.layoutManager = LinearLayoutManager(context)
    }
}
