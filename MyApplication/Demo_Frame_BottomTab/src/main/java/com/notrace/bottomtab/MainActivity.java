package com.notrace.bottomtab;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.notrace.bottomtab.fragment.AssetsFragment;
import com.notrace.bottomtab.fragment.IndexFragment;
import com.notrace.bottomtab.fragment.MarketFragment;
import com.notrace.bottomtab.fragment.PersonFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends FragmentActivity {

    @Bind(R.id.viewpager)
    ViewPager viewpager;
    @Bind(R.id.viewpagertab)
    SmartTabLayout viewpagertab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupTabView();
    }


    protected  void setupTabView(){
        final LayoutInflater inflater=LayoutInflater.from(this);
        final int[]tabIcons={R.drawable.selector_tab_index,R.drawable.selector_tab_market,R.drawable.selector_tab_assets,R.drawable.selector_tab_personcenter};
        final String TITLE[]={"首页","理财超市","我的资产","个人中心"};
        FragmentPagerItems pages=FragmentPagerItems.with(this)
                .add(R.string.index, IndexFragment.class)
                .add(R.string.market, MarketFragment.class)
                .add(R.string.assets, AssetsFragment.class)
                .add(R.string.person, PersonFragment.class)
                .create();
        FragmentPagerItemAdapter adapter=new FragmentPagerItemAdapter(getSupportFragmentManager(),pages);
        viewpager.setOffscreenPageLimit(pages.size());
        viewpager.setAdapter(adapter);
        viewpagertab.setCustomTabView(new SmartTabLayout.TabProvider() {
            @Override
            public View createTabView(ViewGroup container, int position, PagerAdapter adapter) {
                View linearLayout = inflater.inflate(R.layout.tab_item, container, false);
                ImageView icon_image = (ImageView) linearLayout
                        .findViewById(R.id.tab_icon_imageView);
                TextView icon_text = (TextView) linearLayout.findViewById(R.id.tab_text_textview);
                icon_text.setText(TITLE[position]);
                icon_image.setImageResource(tabIcons[position]);
                return linearLayout;
            }
        });
        viewpagertab.setViewPager(viewpager);
    }



}
