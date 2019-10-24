package com.cleansample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.data.DataClass
import com.domain.DomainClass
import com.domain.usecase.GetIUserUseCase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mDomainClass: DomainClass
    @Inject
    lateinit var mDataClass: DataClass

    @Inject lateinit var userUseCase:GetIUserUseCase
    lateinit var factory : ActivityViewModelFactory
    lateinit var viewModel : ActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppClass.getAppComp().inject(this)
        factory = ActivityViewModelFactory(userUseCase)
        viewModel = ViewModelProviders.of(this,factory).get(ActivityViewModel::class.java)

        viewModel.hitAPI()
    }
}
