package volkan.com.veriparkapp.ui;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import butterknife.OnClick;
import volkan.com.veriparkapp.R;
import volkan.com.veriparkapp.base.BaseActivity;
import volkan.com.veriparkapp.data.model.stock_indexes_info.response.StockandIndex;
import volkan.com.veriparkapp.data.source.indexes.IndexesRemoteDataSource;
import volkan.com.veriparkapp.data.source.indexes.IndexesRepository;
import volkan.com.veriparkapp.ui.indexes.IndexesFragment;
import volkan.com.veriparkapp.ui.indexes.IndexesPresenter;
import volkan.com.veriparkapp.ui.indexlist.IndexListFragment;
import volkan.com.veriparkapp.ui.indexlist.IndexListPresenter;
import volkan.com.veriparkapp.util.ActivityUtils;

public class MainActivity extends BaseActivity implements ActivityEvents{
    private static final String TAG = "MainActivity";

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected Context getContext() {
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: ");
    }

    @OnClick(R.id.btn_show_stocks)
    void showStock() {
        IndexesFragment indexesFragment = IndexesFragment.newInstance();
        ActivityUtils.addFragmentToActivityWithTag(getSupportFragmentManager(), indexesFragment, R.id.contentFrame, "BUTTONSFRAGMENT");
        presenter = new IndexesPresenter(IndexesRepository.getInstance(IndexesRemoteDataSource.getInstance()), indexesFragment);    }

    @Override
    public void showStockesList(List<StockandIndex> stockandIndexes) {
        IndexListFragment listFragment = IndexListFragment.newInstance(stockandIndexes);
        ActivityUtils.addFragmentToActivityWithTag(getSupportFragmentManager(), listFragment, R.id.contentFrame, "LISTFRAGMENT");
        presenter = new IndexListPresenter(IndexesRepository.getInstance(IndexesRemoteDataSource.getInstance()), listFragment);    }
}
