package submission.objectdetail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<ObjectModel> list = new ArrayList<>();
    final String STATE_LIST = "state_list";
    final String STATE_MODE = "state_mode";
    int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list = new ArrayList<>();

        if (savedInstanceState == null) {
            list.addAll(ObjectData.getData());
            showRecyclerCard();
            mode = R.id.action_card;

        } else {
            ArrayList<ObjectModel> stateList = savedInstanceState.getParcelableArrayList(STATE_LIST);
            int stateMode = savedInstanceState.getInt(STATE_MODE);
            list.addAll(stateList);
            setMode(stateMode);
        }
    }

    private void showRecyclerList(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListAdapter listAdapter = new ListAdapter(this);
        listAdapter.setListObject(list);
        rvCategory.setAdapter(listAdapter);
    }

    private void showRecyclerGrid(){
        rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
        GridAdapter gridAdapter = new GridAdapter(this);
        gridAdapter.setListObject(list);
        rvCategory.setAdapter(gridAdapter);
    }

    private void showRecyclerCard(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardAdapter cardAdapter = new CardAdapter(this);
        cardAdapter.setListObject(list);
        rvCategory.setAdapter(cardAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_list:
                showRecyclerList();
                break;

            case R.id.action_grid:
                showRecyclerGrid();
                break;

            case R.id.action_card:
                showRecyclerCard();
                break;
        }
        mode = selectedMode;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(STATE_LIST, list);
        outState.putInt(STATE_MODE, mode);
    }
}
