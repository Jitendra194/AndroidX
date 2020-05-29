package com.pills.mydemoapplication.views.hq

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import com.pills.mydemoapplication.R
import com.pills.mydemoapplication.databinding.HQActivityBinding
import com.pills.mydemoapplication.di.viewmodel_factory.ViewModelProviderFactory
import com.pills.mydemoapplication.utils.animation_utils.HalfClockwiseRotateSlideAction
import com.pills.mydemoapplication.utils.animation_utils.ShowHideFabStateAction
import com.pills.mydemoapplication.views.hq.bottom_nav_drawer.BottomNavigationDrawerFragment
import com.pills.mydemoapplication.views.hq.nav_drawer_adapter.NavigationAdapter
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.h_q_activity.*
import javax.inject.Inject

class HQActivity : DaggerAppCompatActivity(), NavController.OnDestinationChangedListener,
    Toolbar.OnMenuItemClickListener {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    private lateinit var binding: HQActivityBinding

    private val navController by lazy { findNavController(R.id.main_hq_navigation) }
    private val hqViewModel: HQViewModel by viewModels { viewModelProviderFactory }
    private val bottomNavDrawer: BottomNavigationDrawerFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.bottom_nav_drawer) as BottomNavigationDrawerFragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.h_q_activity)
        setupStatusBar()
        setupNavigationController()
        setupFloatingActionButton()
        setUpBottomNavigation()
        setUpAppBar()
    }

    private fun setupStatusBar() = window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

    private fun setupNavigationController() = navController.addOnDestinationChangedListener(this)

    private fun setupFloatingActionButton() = fab.apply {
        setShowMotionSpecResource(R.animator.fab_show)
        setHideMotionSpecResource(R.animator.fab_hide)
    }

    private fun setUpBottomNavigation() = bottomNavDrawer.apply {
        addOnSlideAction(HalfClockwiseRotateSlideAction(this@HQActivity.binding.bottomAppBarChevron))
        addOnStateChangedAction(ShowHideFabStateAction(this@HQActivity.binding.fab))
    }

    private fun setUpAppBar() = bar.apply {
        setOnMenuItemClickListener(this@HQActivity)
        setNavigationOnClickListener { bottomNavDrawer.toggle() }
        bottom_app_bar_content_container.setOnClickListener { bottomNavDrawer.toggle() }
    }

    override fun onDestinationChanged(controller: NavController, destination: NavDestination, arguments: Bundle?) {

    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        return false
    }
}
