package com.miu.animalkingdomexplorer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.ContentView
import androidx.fragment.app.commit
import androidx.navigation.NavHostController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.miu.animalkingdomexplorer.databinding.ActivityMainBinding
import com.miu.animalkingdomexplorer.ui.DashboardFragment
import dagger.hilt.android.AndroidEntryPoint

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        val navHOstFragment=supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        val navController=navHOstFragment.navController
        appBarConfiguration = AppBarConfiguration(navController.graph)
        NavigationUI.setupActionBarWithNavController(this,navController,appBarConfiguration)


    }

    override fun onSupportNavigateUp(): Boolean {
        var navController=findNavController(R.id.nav_host_fragment)
        return navController.navigateUp()||super.onSupportNavigateUp()
    }
}