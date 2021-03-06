package br.com.wcisang.lodjinhacleankoincoroutines

import android.app.Application
import br.com.wcisang.lodjinhacleankoincoroutines.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(
                viewModelModule,
                repositoryModule,
                useCaseModule,
                dataSourceModule,
                networkModule
            )
        }
    }

}