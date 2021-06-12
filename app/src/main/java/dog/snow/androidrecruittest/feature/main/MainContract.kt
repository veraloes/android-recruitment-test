package dog.snow.androidrecruittest.feature.main

import dog.snow.androidrecruittest.application.base.BasePresenterInterface
import dog.snow.androidrecruittest.repository.model.RawPhoto

interface MainContract {
    interface View {
        fun showData(list: List<RawPhoto>)
    }

    interface Presenter : BasePresenterInterface<View>
}