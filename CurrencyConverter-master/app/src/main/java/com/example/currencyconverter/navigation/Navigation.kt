package com.example.currencyconverter.navigation

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.currencyconverter.R
import com.example.currencyconverter.ui.main.CurrencyFragment

object Navigation {
    /**
     * Navigates to an [SupportActivity]
     *
     * @param context the given context from starting the next activity.
     * @param clazz the next activity class.
     * @param bundle the [Bundle] with data requested by Map.
     * @param finishCurrentActivity indicates if the current activity must finished or not.
     */
//    fun navigateToActivity(context: Context, clazz: Class<out SupportActivity>, bundle: Bundle? = null, finishCurrentActivity: Boolean = true) {
//        val intent = Intent(context, clazz)
//        bundle?.let {
//            intent.putExtras(it)
//        }
//        context.startActivity(intent)
//        if (context is SupportActivity && finishCurrentActivity) {
//            context.finish()
//        }
//    }

    /**
     * Adds a [Fragment] in the backstack in the [FragmentManager]
     *
     * @param fragment the fragment to be added.
     */
    fun addFragment(
        supportFragmentManager: FragmentManager, @IdRes idResContainer: Int,
        fragment: Fragment
    ) {
        val transaction = supportFragmentManager.beginTransaction()
        if (fragment is CurrencyFragment) {
            transaction.add(idResContainer, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
            return
        } else {
            transaction.setCustomAnimations(
                R.anim.slide_in_right,
                R.anim.slide_out_right,
                R.anim.slide_in_right,
                R.anim.slide_out_right
            )
            transaction.add(idResContainer, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

    /**
     * Replace a [Fragment] in the backstack in the [FragmentManager]
     *
     * @param fragment the fragment to be added.
     */
    fun replaceFragment(
        supportFragmentManager: FragmentManager, @IdRes idResContainer: Int,
        fragment: Fragment
    ) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(idResContainer, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}