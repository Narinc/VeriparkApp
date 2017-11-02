package volkan.com.veriparkapp.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by volkan on 31.10.2017 22:36.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected String ACTIVE_FRAGMENT = "nothing";

    protected abstract int getLayoutId();

    protected abstract Context getContext();

    protected BasePresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
    }
}
