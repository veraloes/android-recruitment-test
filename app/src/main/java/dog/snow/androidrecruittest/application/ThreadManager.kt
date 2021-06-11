package dog.snow.androidrecruittest.application

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class ThreadManager(
    val backThread: Executor = Executors.newSingleThreadExecutor(),
    val mainThread: Executor = MainThreadExecutor()
)

class MainThreadExecutor : Executor {
    private val mainThread: Handler = Handler(Looper.getMainLooper())

    override fun execute(command: Runnable) {
        mainThread.post(command)
    }
}