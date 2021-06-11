package dog.snow.androidrecruittest.application

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.MapKey
import dagger.Module
import javax.inject.Inject
import javax.inject.Provider
import kotlin.reflect.KClass

class PresenterFactory @Inject constructor(
    private val presenters: ViewModelPresenters
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        var provider = presenters[modelClass]
        if (provider == null) {
            for ((key, value) in presenters) {
                if (modelClass.isAssignableFrom(key)) {
                    provider = value
                }
            }
        }
        @Suppress("UNCHECKED_CAST")
        return requireNotNull(provider).get() as T
    }
}

@Module
abstract class PresenterFactoryBuilder {

    @Binds
    abstract fun bindPresenterFactory(factory: PresenterFactory): ViewModelProvider.Factory
}

@MapKey
@Retention
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
annotation class PresenterKey(val value: KClass<out ViewModel>)

private typealias ViewModelPresenters = @JvmSuppressWildcards Map<Class<out ViewModel>, Provider<ViewModel>>