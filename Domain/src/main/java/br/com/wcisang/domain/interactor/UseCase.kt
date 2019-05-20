package br.com.wcisang.domain.interactor

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

abstract class UseCase<T, in Params> {

    protected abstract suspend fun executeOnBackground(params: Params?): T

    open suspend fun execute(params: Params? = null) : Resource<T>{
        return try {
            val result = executeOnBackground(params)
            Resource.success(result)
        } catch (cancellationException: CancellationException) {
            Resource.error(cancellationException.localizedMessage)
        } catch (e: Exception) {
            Resource.error(e.localizedMessage)
        }
    }

    protected suspend fun <X> runAsync(
        context: CoroutineContext = Dispatchers.IO,
        block: suspend () -> X
    ): X {
        return block.invoke()
    }
}