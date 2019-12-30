package com.pedrosoares.cotacaoapp.core.base

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.util.Log
import android.view.View
import com.pedrosoares.cotacaoapp.core.base.BaseContract.Presenter

abstract class BaseFragment<P : Presenter?> : Fragment(), BaseContract.View<P> {
    protected var presenter: P? = null

    val isConnected: Boolean
        get() {
            val connected: Boolean

            context?.let{
                val connectivityManager = it.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                connected = connectivityManager.activeNetworkInfo != null && connectivityManager.activeNetworkInfo.isConnected
                return connected
            }
            return false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = createPresenter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter?.let { presenter!!.onAttach() }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        presenter?.let { presenter!!.onDetach() }

    }

    companion object {

        fun setFragment(id: Int, fragment: Fragment, fragmentActivity: FragmentActivity) {
            val fragmentManager = fragmentActivity.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(id, fragment).commit()
        }

        fun popFragment(fragmentActivity: FragmentActivity?, id: Int, flag: Int) {
            try {
                if (fragmentActivity != null && fragmentActivity.supportFragmentManager != null) {
                    fragmentActivity.supportFragmentManager.popBackStack(id, flag)
                }
            } catch (e: Exception) {
                Log.e(e.message, e.toString())
            }

        }

        fun removeFragment(activity: FragmentActivity, fragment: Fragment?) {
            try {
                if (fragment != null) {
                    activity.supportFragmentManager.popBackStack(fragment.tag, FragmentManager.POP_BACK_STACK_INCLUSIVE)
                }
            } catch (e: Exception) {
                Log.e(e.message, e.toString())
            }

        }
    }

}
