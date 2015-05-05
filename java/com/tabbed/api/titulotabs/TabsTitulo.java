package com.tabbed.api.titulotabs;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class TabsTitulo extends Fragment {

    static class EjemploPaginadorArticulo {
        private final CharSequence mTitulo;

        EjemploPaginadorArticulo(CharSequence titulo) {
            mTitulo = titulo;
        }

        Fragment crearFragment() {
            return ContenedorFragment.nuevaInstancia(mTitulo);
        }

        CharSequence getTitle() {
            return mTitulo;
        }
    }

    private SlidingTabLayout mDeslizador;
    private ViewPager mViewPager;
    private List<EjemploPaginadorArticulo> mTabs = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mTabs.add(new EjemploPaginadorArticulo("Primero"));
        mTabs.add(new EjemploPaginadorArticulo("Segundo"));
        mTabs.add(new EjemploPaginadorArticulo("Tercero"));
    }

    @Override
    public android.view.View onCreateView(LayoutInflater inflater, ViewGroup container,
                                          Bundle savedInstanceState) {
        return inflater.inflate(R.layout.ejemplo_fragment, container, false);
    }

    @Override
    public void onViewCreated(android.view.View view, Bundle savedInstanceState){
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mViewPager.setAdapter(new EjemploFragmentPagerAdapter(getChildFragmentManager()));
        mDeslizador = (SlidingTabLayout) view.findViewById(R.id.sliding_tabs);
        mDeslizador.setViewPager(mViewPager);
        mDeslizador.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return Color.RED;
            }
        });


    }


    private class EjemploFragmentPagerAdapter extends FragmentPagerAdapter {
        public EjemploFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return mTabs.get(i).crearFragment();
        }

        @Override
        public int getCount() {
            return mTabs.size();
        }

        @Override
        public CharSequence getPageTitle(int position){
            return mTabs.get(position).getTitle();
        }
    }

}
