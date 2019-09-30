package submission.objectdetail;

import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity {

    public static final String name = "name";
    public static final String remark = "remark";
    public static final String picture = "picture";
    public static final String status = "status";
    public static final String gender = "gender";
    public static final String description = "description";

    TextView tv_name,tv_remark,tv_gender,tv_status,tv_description;
    ImageView iv_picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ActionBar actionBar = getSupportActionBar(); // or getActionBar();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        iv_picture = findViewById(R.id.civ_picture);
        tv_name = findViewById(R.id.tv_name);
        tv_remark = findViewById(R.id.tv_remark);
        tv_gender = findViewById(R.id.tv_gender);
        tv_status = findViewById(R.id.tv_status);
        tv_description = findViewById(R.id.tv_description);

        Glide.with(getApplicationContext())
                .load(getIntent().getStringExtra(picture))
                .into(iv_picture);

        tv_name.setText(getIntent().getStringExtra(name));
        tv_remark.setText(getIntent().getStringExtra(remark));
        tv_gender.setText(getIntent().getStringExtra(gender));
        tv_status.setText(getIntent().getStringExtra(status));
        tv_description.setText(getIntent().getStringExtra(description));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
