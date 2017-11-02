package volkan.com.veriparkapp.ui.indexlist;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import volkan.com.veriparkapp.R;
import volkan.com.veriparkapp.base.BaseFragment;
import volkan.com.veriparkapp.data.model.stock_indexes_info.response.StockandIndex;

/**
 * A simple {@link Fragment} subclass.
 */
public class IndexListFragment extends BaseFragment<IndexListScreen.Presenter> implements IndexListScreen.View {

    private static final String EXTRA_ITEMS = "items";

    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.lv_indexes)
    ListView lvIndexes;
    @BindView(R.id.content)
    LinearLayout content;

    public static IndexListFragment newInstance(List<StockandIndex> stockandIndexes) {

        Bundle args = new Bundle();
        args.putSerializable(EXTRA_ITEMS, (Serializable) stockandIndexes);

        IndexListFragment fragment = new IndexListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public IndexListFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_index_list;
    }

    @Override
    public View getSnackbarAnchorView() {
        return content;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        assert llBackAndHeader != null;
        llBackAndHeader.setVisibility(View.VISIBLE);

        assert tvHeader != null;
        tvHeader.setText(getString(R.string.imkb_stockes_indexes_list));

        assert ivSearch != null;
        ivSearch.setVisibility(View.VISIBLE);

        List<StockandIndex> indexList = (List<StockandIndex>) getArguments().getSerializable(EXTRA_ITEMS);
        IndexListAdapter adapter = new IndexListAdapter(getContext(), indexList);
        lvIndexes.setAdapter(adapter);
    }
}
