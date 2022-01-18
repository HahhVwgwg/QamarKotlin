package e.muslim.prayer.presentation.activity

import e.muslim.prayer.utils.NonNullObservableField
import e.muslim.prayer.utils.SingleLiveData
import e.muslim.prayer.utils.base_classes.BaseViewModel

class BottomNavigationViewModel : BaseViewModel() {
    val first = NonNullObservableField(true)
    val second = NonNullObservableField(false)
    val third = NonNullObservableField(false)
    val fourth = NonNullObservableField(false)
    val fifth = NonNullObservableField(false)
    val bottomNavigationVisibility = NonNullObservableField(true)
    val clickedMenu = SingleLiveData<Int>()
    var openedMenu = 1

    fun onClick(menuType: Int) {
        if (openedMenu != menuType) {
            when {
                bottomNavigationVisibility.get() && menuType == 6 -> bottomNavigationVisibility.set(
                    false
                )
                !bottomNavigationVisibility.get() && menuType != 6 -> bottomNavigationVisibility.set(
                    true
                )
            }
            if (menuType == 6)
                return
            when (openedMenu) {
                1 -> first.set(false)
                2 -> second.set(false)
                3 -> third.set(false)
                4 -> fourth.set(false)
                5 -> fifth.set(false)
            }
            when (menuType) {
                1 -> first.set(true)
                2 -> second.set(true)
                3 -> third.set(true)
                4 -> fourth.set(true)
                5 -> fifth.set(true)
            }
            clickedMenu.value = menuType
            openedMenu = menuType
        }
    }

    fun onMainFragmentsOpened() {
        bottomNavigationVisibility.set(true)
    }
}