package dog.snow.androidrecruittest.application.base

interface BasePresenterInterface<ViewType> {
    fun attach(view: ViewType)
}