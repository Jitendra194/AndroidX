package com.pills.mydemoapplication.views.hq.bottom_nav_drawer

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.pills.mydemoapplication.R
import com.pills.mydemoapplication.databinding.BottomNavigationDrawerBinding
import com.pills.mydemoapplication.utils.animation_utils.*
import com.pills.mydemoapplication.utils.extention_utils.setMarginTop
import com.pills.mydemoapplication.views.hq.nav_drawer_adapter.NavigationAdapter
import com.pills.mydemoapplication.views.hq.nav_drawer_adapter.NavigationModel
import com.pills.mydemoapplication.views.hq.nav_drawer_adapter.NavigationModelItem
import com.pills.mydemoapplication.views.hq.nav_drawer_adapter.NavigationModelItem.Companion.EDIT_PROFILE
import com.pills.mydemoapplication.views.hq.nav_drawer_adapter.NavigationModelItem.Companion.FEEDBACK
import com.pills.mydemoapplication.views.hq.nav_drawer_adapter.NavigationModelItem.Companion.HELP
import com.pills.mydemoapplication.views.hq.nav_drawer_adapter.NavigationModelItem.Companion.HOME
import com.pills.mydemoapplication.views.hq.nav_drawer_adapter.NavigationModelItem.Companion.PAYMENT_METHOD
import com.pills.mydemoapplication.views.hq.nav_drawer_adapter.NavigationModelItem.Companion.SIGN_OUT
import kotlinx.android.synthetic.main.bottom_navigation_drawer.*

class BottomNavigationDrawerFragment : Fragment(), NavigationAdapter.NavigationAdapterListener {

    lateinit var binding: BottomNavigationDrawerBinding

    private val behavior: BottomSheetBehavior<FrameLayout> by lazy { BottomSheetBehavior.from(binding.backgroundContainer) }
    private val navAdapter: NavigationAdapter by lazy { NavigationAdapter(this) }
    private val bottomSheetCallback = BottomNavigationDrawerCallback()
    private val closeDrawerOnBackPressed = object : OnBackPressedCallback(false) {
        override fun handleOnBackPressed() {
            closeDrawer()
        }
    }
    private val backButtonStateChange = object : OnStateChangedAction {
        override fun onStateChanged(sheet: View, newState: Int) {
            closeDrawerOnBackPressed.isEnabled = newState != BottomSheetBehavior.STATE_HIDDEN
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this, closeDrawerOnBackPressed)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = DataBindingUtil.inflate<BottomNavigationDrawerBinding>(inflater, R.layout.bottom_navigation_drawer, container, false).run {
        binding = this
        lifecycleOwner = viewLifecycleOwner
        root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBottomSheetBehavior()
        setBottomSheetInsets()
        setupNavigationRecyclerView()
    }

    override fun onNavItemClicked(item: NavigationModelItem.NavMenuItem) {
        if (NavigationModel.setNavigationMenuItemChecked(item.id, item.checked)) launchMenuDestination(item.id)
        closeDrawer()
    }

    fun toggle() = when (behavior.state) {
        BottomSheetBehavior.STATE_HIDDEN -> openDrawer()
        BottomSheetBehavior.STATE_HALF_EXPANDED,
        BottomSheetBehavior.STATE_EXPANDED,
        BottomSheetBehavior.STATE_COLLAPSED -> closeDrawer()
        else -> closeDrawer()
    }

    fun addOnSlideAction(action: OnSlideAction) = bottomSheetCallback.addOnSlideAction(action)

    fun addOnStateChangedAction(action: OnStateChangedAction) = bottomSheetCallback.addOnStateChangedAction(action)

    fun openDrawer() { behavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED }

    fun closeDrawer() { behavior.state = BottomSheetBehavior.STATE_HIDDEN }

    private fun setupBottomSheetBehavior() = bottomSheetCallback.apply {
        scrim_view.setOnClickListener { closeDrawer() }
        addOnSlideAction(AlphaSlideAction(scrim_view))
        addOnStateChangedAction(VisibilityStateAction(scrim_view))
        addOnStateChangedAction(backButtonStateChange)
    }.also {
        behavior.addBottomSheetCallback(it)
        behavior.state = BottomSheetBehavior.STATE_HIDDEN
    }

    private fun setBottomSheetInsets() = foreground_container.setOnApplyWindowInsetsListener { view, insets ->
        view.setMarginTop(insets.systemWindowInsetTop)
        insets
    }

    private fun setupNavigationRecyclerView() = NavigationModel.apply {
        nav_recycler_view.adapter = navAdapter
        navigationList.observe(viewLifecycleOwner, Observer { navAdapter.submitList(it) })
        setNavigationMenuItemChecked(HOME, false)
    }

    private fun launchMenuDestination(destinationId: Int) = when(destinationId) {
        HOME -> Log.i("DESTINATION", destinationId.toString())
        EDIT_PROFILE -> Log.i("DESTINATION", destinationId.toString())
        PAYMENT_METHOD -> Log.i("DESTINATION", destinationId.toString())
        FEEDBACK -> Log.i("DESTINATION", destinationId.toString())
        HELP -> Log.i("DESTINATION", destinationId.toString())
        SIGN_OUT -> Log.i("DESTINATION", destinationId.toString())
        else -> Log.i("DESTINATION", "Unsupported destination")
    }
}