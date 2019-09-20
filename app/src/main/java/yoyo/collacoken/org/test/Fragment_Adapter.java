package yoyo.collacoken.org.test;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.RecyclerView;
public class Fragment_Adapter extends FragmentPagerAdapter {
    public Fragment_Adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return Fragment_login.newInstance("cbxcb", "Page # 1");
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return Fragment_signUp.newInstance("kfgf", "Page # 2");

            default:
                return new Fragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
    @Override
    public CharSequence getPageTitle(int position) {
       if(position==0)
       {
           return "Login";
       }
       else
       {
           return "SignIn";
       }
    }
}
