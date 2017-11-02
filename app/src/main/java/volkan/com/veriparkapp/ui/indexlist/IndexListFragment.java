package volkan.com.veriparkapp.ui.indexlist;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ToggleButton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
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

        assert toggleSearch != null;
        toggleSearch.setVisibility(View.VISIBLE);

        assert ivUndo != null;
        ivUndo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });


        final List<StockandIndex> indexList = (List<StockandIndex>) getArguments().getSerializable(EXTRA_ITEMS);
        final List<StockandIndex> allList = new ArrayList<>();
        allList.addAll(indexList);

        final IndexListAdapter adapter = new IndexListAdapter(getContext(), this, indexList);
        lvIndexes.setAdapter(adapter);

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                String filter = editable.toString().trim();

                if (filter.equals("")){
                    adapter.setAll(allList);
                    return;
                }

                List<StockandIndex> fildeterdList = new ArrayList<>();
                for (StockandIndex index: allList){
                    if (index.getSymbol().contains(filter)) {
                        fildeterdList.add(index);
                    }
                }

                adapter.setAll(fildeterdList);
                fildeterdList.clear();
            }
        });
    }

    @OnClick(R.id.toggle_search)
    void showSearchArea(ToggleButton toggleButton) {
        if (toggleButton.isChecked()) {
            etSearch.setVisibility(View.VISIBLE);
            etSearch.requestFocus();
            hideKeyboard(true);
        } else {
            etSearch.setVisibility(View.GONE);
            hideKeyboard(false);
        }
    }

    public void hideKeyboard(boolean isVisible) {
        View view = getActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            if (isVisible){
                imm.showSoftInput(etSearch, InputMethodManager.SHOW_IMPLICIT);
            }else {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }


}
