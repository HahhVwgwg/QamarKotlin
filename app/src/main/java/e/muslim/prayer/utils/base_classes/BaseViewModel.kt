package e.muslim.prayer.utils.base_classes

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import e.muslim.prayer.data.Navigation
import e.muslim.prayer.utils.SingleLiveData

@SuppressLint("CheckResult")
abstract class BaseViewModel : ViewModel() {
    var isLoading = MutableLiveData<Boolean>()
    var refresh = SingleLiveData<Boolean>()
    var isRefreshing = MutableLiveData<Boolean>()
    var error = SingleLiveData<Int>()
    var errorString = SingleLiveData<String>()
    var showNetworkError = SingleLiveData<Boolean>()
    var navigateTo = SingleLiveData<Int>()
    var navigateUp = SingleLiveData<Boolean>()
    var navigateWithData = SingleLiveData<Navigation>()
}