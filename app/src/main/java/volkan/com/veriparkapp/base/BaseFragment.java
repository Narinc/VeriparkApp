package volkan.com.veriparkapp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import volkan.com.veriparkapp.R;
import volkan.com.veriparkapp.util.ErrorUtils;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by volkan on 31.10.2017 22:37.
 */

public abstract class BaseFragment<T> extends Fragment implements BaseView<T> {

    @Nullable
    @BindView(R.id.content)
    protected LinearLayout content;
    @Nullable
    @BindView(R.id.iv_search)
    protected ImageView ivSearch;
    @Nullable
    @BindView(R.id.iv_undo)
    protected ImageView ivUndo;
    @Nullable
    @BindView(R.id.tvHeader)
    protected TextView tvHeader;
    @Nullable
    @BindView(R.id.ll_back_and_header)
    protected LinearLayout llBackAndHeader;

    protected abstract int getLayoutId();
    protected T presenter;
    protected Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        view.setOnClickListener(null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void setPresenter(T presenter) {
        this.presenter = checkNotNull(presenter);
    }

    @Override
    public void showErrorSnackbar(Throwable t, int resId) {
        ErrorUtils.showSnackbar(getSnackbarAnchorView(), R.string.retry, t,
                -1, null);
    }

    @Override
    public void showErrorSnackbar(String problem, int resId) {
        ErrorUtils.showSnackbar(getSnackbarAnchorView(), R.string.retry, problem,
                -1, null);
    }

    @Override
    public void showErrorSnackbar(int resId, String problem) {
        ErrorUtils.showSnackbar(getSnackbarAnchorView(), resId, problem,
                -1, null);
    }
}
