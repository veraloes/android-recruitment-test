package dog.snow.androidrecruittest.application.base

import androidx.lifecycle.ViewModel
import java.lang.ref.WeakReference

abstract class BasePresenter<ViewType> : ViewModel(), BasePresenterInterface<ViewType> {
    private var view: WeakReference<ViewType>? = null

    override fun attach(view: ViewType) {
        this.view = WeakReference(view)
    }

    protected fun getScreen(): ViewType? = view?.get()
}