package volkan.com.veriparkapp.ui.indexes;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.LinearLayout;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import volkan.com.veriparkapp.R;
import volkan.com.veriparkapp.base.BaseFragment;
import volkan.com.veriparkapp.data.model.stock_indexes_info.response.StockandIndex;
import volkan.com.veriparkapp.ui.ActivityEvents;

/**
 * A simple {@link Fragment} subclass.
 */
public class IndexesFragment extends BaseFragment<IndexesScreen.Presenter> implements IndexesScreen.View {

    @BindView(R.id.content)
    LinearLayout content;

    public static IndexesFragment newInstance() {

        Bundle args = new Bundle();

        IndexesFragment fragment = new IndexesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public IndexesFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_indexes;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        assert llBackAndHeader != null;
        llBackAndHeader.setVisibility(View.VISIBLE);

        assert tvHeader != null;
        tvHeader.setText(getString(R.string.imkb_stockes_indexes));
    }

    @Override
    public View getSnackbarAnchorView() {
        return content;
    }

    @OnClick(R.id.iv_undo)
    void undo() {
        getActivity().onBackPressed();
    }

    @OnClick(R.id.btn_show_shares_and_bills)
    void click() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("“dd:MM:yyyy HH:mm");
        String request = "RequestIsValid".concat(simpleDateFormat.format(date));

        //Interestingly, quotes occurs
        String[] strings = request.split("“");
        request = strings[0].concat(strings[1]);

        presenter.getEncryptedKey(request);
    }

    @Override
    public void showStockList(List<StockandIndex> stockandIndexes) {
        ActivityEvents activityEvents = (ActivityEvents) getActivity();
        activityEvents.showStockesList(stockandIndexes);
    }
}
