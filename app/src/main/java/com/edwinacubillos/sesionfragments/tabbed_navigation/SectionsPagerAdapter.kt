package com.edwinacubillos.sesionfragments.tabbed_navigation

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.edwinacubillos.sesionfragments.BatmanFragment
import com.edwinacubillos.sesionfragments.FlashFragment
import com.edwinacubillos.sesionfragments.R
import com.edwinacubillos.sesionfragments.SupermanFragment

private val TAB_TITLES = arrayOf(
    R.string.superman,
    R.string.batman,
    R.string.flash
)

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {

        when (position){
            0 -> return SupermanFragment()
            1 -> return BatmanFragment()
            else -> return FlashFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return 3
    }
}