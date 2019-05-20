package br.com.wcisang.domain.interactor

abstract class CompletableUseCase<in Params> : UseCase<Nothing?, Params>() {

    protected abstract suspend fun executeCompletableOnBackground(params: Params?)

    override suspend fun executeOnBackground(params: Params?): Nothing? {
        executeCompletableOnBackground(params)
        return null
    }
}