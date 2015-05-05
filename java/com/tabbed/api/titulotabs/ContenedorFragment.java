package com.tabbed.api.titulotabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by API on 30/04/2015.
 */
public class ContenedorFragment extends Fragment{

    private static final String TITULO = "titulo";
    public static Fragment nuevaInstancia(CharSequence titulo) {

        Bundle bundle = new Bundle();
        bundle.putCharSequence(TITULO, titulo);

        ContenedorFragment fragment = new ContenedorFragment();
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        return inflater.inflate(R.layout.paginador, container, false);
    }

    @Override
    public void onViewCreated (View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        Bundle args = getArguments();

        if( args != null){

            TextView title = (TextView) view.findViewById(R.id.textTitulo);
            title.setText("Titulo: " + args.getCharSequence(TITULO));
        }
    }
}
