package demo.frap.michaeljacksonapp.Interfaces;

import android.support.v4.app.Fragment;

/**
 * Created by Ramandeep on 9/27/17.
 */

public interface AddFragmentCallback {

    void replaceFragment(Fragment fragment, boolean addToBackStack, String transactionName, String tag);
}
