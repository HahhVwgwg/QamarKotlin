package e.muslim.prayer.di

import e.muslim.prayer.presentation.activity.BottomNavigationViewModel
import e.muslim.prayer.presentation.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { MainViewModel() }
    viewModel { BottomNavigationViewModel() }
}