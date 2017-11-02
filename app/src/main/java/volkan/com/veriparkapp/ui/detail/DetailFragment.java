package volkan.com.veriparkapp.ui.detail;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import volkan.com.veriparkapp.R;
import volkan.com.veriparkapp.base.BaseFragment;
import volkan.com.veriparkapp.data.model.stock_indexes_info.response.StockandIndex;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends BaseFragment<IndexDetailScreen.Presenter> implements IndexDetailScreen.View {

    private static final String EXTRA_ITEM = "item";
    @BindView(R.id.tv_symbol)
    TextView tvSymbol;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_changing)
    TextView tvChanging;
    @BindView(R.id.iv_changing_status)
    ImageView ivChangingStatus;
    @BindView(R.id.tv_daily_high)
    TextView tvDailyHigh;
    @BindView(R.id.tv_daily_low)
    TextView tvDailyLow;
    @BindView(R.id.tv_current)
    TextView tvCurrent;
    @BindView(R.id.tv_volume)
    TextView tvVolume;
    @BindView(R.id.tv_count)
    TextView tvCount;
    @BindView(R.id.content)
    LinearLayout content;
    private StockandIndex stockandIndex;

    public static DetailFragment newInstance(StockandIndex item) {

        Bundle args = new Bundle();
        args.putSerializable(EXTRA_ITEM, item);

        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View getSnackbarAnchorView() {
        return content;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_detail;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        stockandIndex = (StockandIndex) getArguments().getSerializable(EXTRA_ITEM);

        assert llBackAndHeader != null;
        llBackAndHeader.setVisibility(View.VISIBLE);

        assert ivUndo != null;
        ivUndo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
        assert tvHeader != null;

        if (stockandIndex != null) {
            tvHeader.setText(stockandIndex.getSymbol());


            tvSymbol.setText(stockandIndex.getSymbol());
            tvPrice.setText(String.valueOf(stockandIndex.getPrice()));
            tvChanging.setText(String.valueOf(stockandIndex.getDifference()));
            tvDailyHigh.setText(String.valueOf(stockandIndex.getDayPeakPrice()));
            tvDailyLow.setText(String.valueOf(stockandIndex.getDayLowestPrice()));
            tvCurrent.setText(String.valueOf(stockandIndex.getTotal()));
            tvVolume.setText(String.valueOf(stockandIndex.getVolume()));
            tvCount.setText(String.valueOf(stockandIndex.getTotal()));

            if (stockandIndex.getDifference()>0){
                ivChangingStatus.setImageResource(R.drawable.arrow_up);
            }else ivChangingStatus.setImageResource(R.drawable.sort_down);
        }

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("“dd:MM:yyyy HH:mm");
        String request = "RequestIsValid".concat(simpleDateFormat.format(date));

        //Interestingly, quotes occurs
        String[] strings = request.split("“");
        request = strings[0].concat(strings[1]);

        presenter.getEncryptedKey(request);
    }

    @Override
    public String getSymbol() {
        return stockandIndex.getSymbol();
    }
}
