package demo.frap.michaeljacksonapp.Activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.frap.michaeljacksonapp.Fragments.Track_List;
import demo.frap.michaeljacksonapp.Interfaces.AddFragmentCallback;
import demo.frap.michaeljacksonapp.R;

import static demo.frap.michaeljacksonapp.R.id.mFragmentContainer;

public class MainActivity extends AppCompatActivity  implements AddFragmentCallback {

    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    frameLayout=(FrameLayout)findViewById(mFragmentContainer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        addFirstFragment();



    }

    private void addFirstFragment() {


        replaceFragment(new Track_List(), true, "track_list", "track_list");

    }


    public void replaceFragment(Fragment fragment, boolean addToBackStack, String transactionName, String tag)
    {
        try {

            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            // fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            fragmentTransaction.add(frameLayout.getId(), fragment, tag);
            if (addToBackStack)
                fragmentTransaction.addToBackStack(transactionName);

            fragmentTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
