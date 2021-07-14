package com.portfolio.drinkme.ui.home

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.View
import androidx.fragment.app.Fragment
import com.portfolio.drinkme.R
import com.portfolio.drinkme.ui.home.fragments.DailyFragment
import com.portfolio.drinkme.ui.home.fragments.FavouriteFragment
import com.portfolio.drinkme.ui.home.fragments.SmoothieFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        window.statusBarColor = Color.parseColor("#ffffff")
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        val smoothFragment = SmoothieFragment()
        val favouriteFragment = FavouriteFragment()
        val dailyFragment = DailyFragment()

        makeCurrentFragment(smoothFragment)

        bottomNavigationHome.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.pageSmoothie ->makeCurrentFragment(smoothFragment)
                R.id.pageFavourite ->makeCurrentFragment(favouriteFragment)
                R.id.pageDaily -> makeCurrentFragment(dailyFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayoutHome,fragment)
            commit()
        }
    }



}