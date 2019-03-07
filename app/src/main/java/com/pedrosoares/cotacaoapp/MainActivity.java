package com.pedrosoares.cotacaoapp;

import android.os.Bundle;
import android.widget.Toast;

import com.pedrosoares.cotacaoapp.core.base.BaseActivity;
import com.pedrosoares.cotacaoapp.presentation.view.fragment.CotacaoListFragment;

import static com.pedrosoares.cotacaoapp.core.base.BaseFragment.setFragment;

public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (isConected()) {
            setFragment(R.id.frame_main_activity, new CotacaoListFragment(), this);
        } else {
            Toast.makeText(this, "Sem Conexão de Dados :(", Toast.LENGTH_SHORT).show();
            //setFragment(R.id.frame_main_activity, new TratarConexao(), this);
        }
    }
}
