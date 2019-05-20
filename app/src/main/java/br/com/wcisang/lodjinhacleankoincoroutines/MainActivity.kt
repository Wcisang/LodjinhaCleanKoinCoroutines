package br.com.wcisang.lodjinhacleankoincoroutines

import android.os.Bundle
import br.com.wcisang.lodjinhacleankoincoroutines.ui.BaseActivity
import br.com.wcisang.lodjinhacleankoincoroutines.ui.home.HomeFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.mainContainer, HomeFragment())
            .commit()
    }

}
