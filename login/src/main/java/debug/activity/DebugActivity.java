package debug.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.ericshenn.baselibrary.base.BaseActivity;
import com.ericshenn.baselibrary.utils.IntentUtils;
import com.ericshenn.login.R;
import com.ericshenn.login.login.LoginActivity;

public class DebugActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.debug_act);

        TextView tv_mine = findViewById(R.id.tv_mine);

        tv_mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentUtils.startActivity(DebugActivity.this, LoginActivity.class);
            }
        });
    }
}
