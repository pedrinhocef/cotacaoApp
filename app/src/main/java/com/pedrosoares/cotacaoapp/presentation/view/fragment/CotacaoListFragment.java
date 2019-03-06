package com.pedrosoares.cotacaoapp.presentation.view.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pedrosoares.cotacaoapp.R;
import com.pedrosoares.cotacaoapp.core.base.BaseFragment;
import com.pedrosoares.cotacaoapp.model.domain.BTCDomain;
import com.pedrosoares.cotacaoapp.model.domain.CoinsDomain;
import com.pedrosoares.cotacaoapp.model.domain.EURDomain;
import com.pedrosoares.cotacaoapp.model.domain.LTCDomain;
import com.pedrosoares.cotacaoapp.model.domain.USDDomain;
import com.pedrosoares.cotacaoapp.model.util.RecyclerItemClickListener;
import com.pedrosoares.cotacaoapp.presentation.CoinsPresentationContract;
import com.pedrosoares.cotacaoapp.presentation.view.adapter.CotacaoAdapter;
import com.pedrosoares.cotacaoapp.presentation.presenter.CoinsPresenter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CotacaoListFragment extends BaseFragment<CoinsPresentationContract.CoinsPresenter>
                            implements CoinsPresentationContract.Fragment {

    //region BINDS
    @Bind(R.id.rv_list_cotacao)
    RecyclerView rvListCotacao;

    @Bind(R.id.tv_date_hour)
    TextView tvDateAndHour;

    @Bind(R.id.ll_success)
    LinearLayout llSuccess;

    @Bind(R.id.fragment_error)
    ConstraintLayout constraintError;

    @Bind(R.id.fragment_loading)
    ConstraintLayout constraintLoading;
    //endregion

    CotacaoAdapter cotacaoAdapter;
    List<Object> coinsDomainList = new ArrayList<>();
    private int month;
    ProgressDialog progressDialog;



    public CotacaoListFragment() {
        // Required empty public constructor
    }

    @OnClick(R.id.image_refresh)
    void onClickReload(){
        presenter.fetchCoins();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cotacao_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, getActivity());
        presenter.fetchCoins();
        getFullDate();
    }

    @Override
    public CoinsPresentationContract.CoinsPresenter createPresenter() {
        return new CoinsPresenter(getContext(), this);
    }

    @Override
    public void populateCoins(CoinsDomain coinsDomain) {

        addCoinsToArray(coinsDomain);

        if (getContext() != null) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);

            cotacaoAdapter = new CotacaoAdapter(getContext(),coinsDomainList);
            rvListCotacao.setLayoutManager(layoutManager);
            rvListCotacao.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
            rvListCotacao.setAdapter(cotacaoAdapter);

            showSuccessScreen();

            listOnClick();
        }

    }

    private void addCoinsToArray(CoinsDomain coinsDomain) {
        BTCDomain btc = coinsDomain.getBTC();
        USDDomain usd = coinsDomain.getUSD();
        LTCDomain ltc = coinsDomain.getLTC();
        EURDomain eur = coinsDomain.getEUR();

        coinsDomainList.add(0,btc);
        coinsDomainList.add(1,usd);
        coinsDomainList.add(2,ltc);
        coinsDomainList.add(3,eur);
    }

    private void showSuccessScreen() {
        progressDialog.cancel();
        constraintLoading.setVisibility(View.GONE);
        constraintError.setVisibility(View.GONE);
        llSuccess.setVisibility(View.VISIBLE);
    }


    @Override
    public void loading() {
        constraintLoading.setVisibility(View.VISIBLE);
        constraintError.setVisibility(View.GONE);
        llSuccess.setVisibility(View.GONE);
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Carregando dados... aguarde");
        progressDialog.setIndeterminate(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
    }

    @Override
    public void error() {
        progressDialog.cancel();
        constraintLoading.setVisibility(View.GONE);
        constraintError.setVisibility(View.VISIBLE);
        llSuccess.setVisibility(View.GONE);
    }

    public void getFullDate(){
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH) + 1;
        Date date = calendar.getTime();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String formattedDate = dateFormat.format(date);
        tvDateAndHour.setText("Atualizado em "+ day+" de "+monthName(month)+", às "+formattedDate);
    }

    private String monthName(int monthNumber) {
        switch (monthNumber){
            case 1: return "janeiro";
            case 2: return "fevereiro";
            case 3: return  "março";
            case 4: return "abril";
            case 5: return "maio";
            case 6: return "junho";
            case 7: return "julho";
            case 8: return "agosto";
            case 9: return "setembro";
            case 10: return "outubro";
            case 11: return "novembro";
            case 12: return "dezembro";

            default: return "Mês inválido";
        }
    }


    private void listOnClick(){
        rvListCotacao.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), rvListCotacao, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                AlertCambioFragment fragment = new AlertCambioFragment();
                ft.addToBackStack(null);
                ft.replace(R.id.content_frame, fragment);
                ft.commit();
            }

            @Override
            public void onLongItemClick(View view, int position) {}

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {}
        }));
    }
}
