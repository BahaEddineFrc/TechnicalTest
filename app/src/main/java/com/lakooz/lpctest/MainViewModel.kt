package com.lakooz.lpctest

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lakooz.lpctest.model.Pot
import com.lakooz.lpctest.networking.RestApiClient
import com.lakooz.lpctest.repositories.PotRepository
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = PotRepository.instance

    private val _isRefreshing = MutableLiveData<Boolean>()
    val isRefreshing: LiveData<Boolean>
        get() = _isRefreshing

    private val _error = MutableLiveData<Boolean>()
    val error: LiveData<Boolean>
        get() = _error

    fun getPots() {

        _isRefreshing.value = true

        RestApiClient.getPots()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<List<Pot>> {

                var disposable: Disposable? = null

                override fun onSubscribe(d: Disposable) {
                    disposable = d
                }

                override fun onSuccess(pots: List<Pot>) {
                    disposable?.dispose()

                    repository.insertAllAndSynchronize(pots)
                    _isRefreshing.value = false
                    _error.value = false
                }

                override fun onError(e: Throwable) {
                    _isRefreshing.value = false
                    _error.value = true
                }

            }

            )
    }

    fun createPot(category: Int, viewPagerAdapter: ViewPagerAdapter) {

        _isRefreshing.value = true

        RestApiClient.createPot(category)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<Pot> {

                var disposable: Disposable? = null

                override fun onSubscribe(d: Disposable) {
                    disposable = d
                }

                override fun onSuccess(pot: Pot) {
                    disposable?.dispose()

                    repository.createOrUpdate(pot)
                    viewPagerAdapter.updateFragment(category)

                    _isRefreshing.value = false
                    _error.value = false
                }

                override fun onError(e: Throwable) {
                    _isRefreshing.value = false
                    _error.value = true
                }

            }

            )
    }


}