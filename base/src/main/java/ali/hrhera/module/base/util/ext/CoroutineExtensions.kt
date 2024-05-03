package appssquare.projects.HealloCare.utils.ext

import android.util.Log
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow

private val mainScope = CoroutineScope(Dispatchers.Main + SupervisorJob())
private val ioScope = CoroutineScope(Dispatchers.IO + SupervisorJob())
private val defaultScope = CoroutineScope(Dispatchers.Default + SupervisorJob())

@Suppress("FunctionName")
fun <T> ConsumableSharedFlow(canReplay: Boolean = false) = MutableSharedFlow<T>(
    replay = if (canReplay) 1 else 0,
    extraBufferCapacity = 1,
    onBufferOverflow = BufferOverflow.DROP_OLDEST
)


fun uiLaunch(block: suspend CoroutineScope.() -> Unit) = mainScope.launch(
    context = CoroutineExceptionHandler { _, e ->
        Log.e("CoroutineExtensions", "MainScope Error->Coroutine failed: ${e.localizedMessage}")
    },
    block = block
)

fun launchIo(block: suspend CoroutineScope.() -> Unit) = ioScope.launch(
    context = CoroutineExceptionHandler { _, e ->
        Log.e("CoroutineExtensions", "ioScope Error->Coroutine failed: ${e.localizedMessage}")
    },
    block = block
)

fun ioLaunch(block: suspend CoroutineScope.() -> Unit) = launchIo(block)
fun defaultLaunch(block: suspend CoroutineScope.() -> Unit) = defaultScope.launch(
    context = CoroutineExceptionHandler { _, e ->
        Log.e("CoroutineExtensions", "defaultScope Error->Coroutine failed: ${e.localizedMessage}")
    },
    block = block
)