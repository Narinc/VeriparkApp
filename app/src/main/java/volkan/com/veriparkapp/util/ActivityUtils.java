package volkan.com.veriparkapp.util;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import volkan.com.veriparkapp.R;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by volkannarinc on 29/06/17 11:06.
 */

public class ActivityUtils {
    /**
     * The {@code fragment} is added to the container view with id {@code frameId}. The operation is
     * performed by the {@code fragmentManager}.
     */
    public static void addFragmentToActivityWithTag(@NonNull FragmentManager fragmentManager,
                                                    @NonNull Fragment fragment, int frameId, String tag) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);

        /** if fragment exist in fragmentManager, remove it**/
        if (fragmentManager.findFragmentByTag(tag) != null) {
            popBackStack(fragmentManager, tag, 0);
//            attachFragmentToActivity(fragmentManager, fragment);
        } else {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);
            transaction.add(frameId, fragment, tag);
            transaction.addToBackStack(tag);
            transaction.commitAllowingStateLoss();
        }

    }

    /**
     * The {@code fragment} is added to the container view with id {@code frameId}. The operation is
     * performed by the {@code fragmentManager}.
     */
    public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                             @NonNull Fragment fragment, int frameId) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment);
        transaction.commit();
    }

    /**
     * The {@code fragment} is removed to the container view with id {@code frameId}. The operation is
     * performed by the {@code fragmentManager}.
     */
    public static void removeFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                                @NonNull Fragment fragment, String tag) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.remove(fragment);
        transaction.addToBackStack(tag);
        transaction.commit();
    }

    /**
     * The {@code fragment} is replaced to the container view with id {@code frameId}. The operation is
     * performed by the {@code fragmentManager}.
     */
    public static void replaceFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                                 @NonNull Fragment fragment, int frameId, String tag) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);


        /** if fragment exist in fragmentManager, remove it**/
        if (fragmentManager.findFragmentByTag(tag) != null) {
            popBackStack(fragmentManager, tag, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);

        transaction.replace(frameId, fragment, tag);
        transaction.addToBackStack(tag);
        transaction.commitAllowingStateLoss();
    }

    /**
     * The {@code fragment} is detached to the container view with id {@code frameId}. The operation is
     * performed by the {@code fragmentManager}.
     */
    public static void detachFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                                @NonNull Fragment fragment, String tag) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.detach(fragment);
        transaction.addToBackStack(tag);
        transaction.commit();
    }

    /**
     * The {@code fragment} is attched to the container view with id {@code frameId}. The operation is
     * performed by the {@code fragmentManager}.
     */
    public static void attachFragmentToActivityWithTag(@NonNull FragmentManager fragmentManager,
                                                       @NonNull Fragment fragment, String tag) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.attach(fragment);
        transaction.addToBackStack(tag);
        transaction.commit();
    }

    /**
     * The {@code fragment} is attched to the container view with id {@code frameId}. The operation is
     * performed by the {@code fragmentManager}.
     */
    public static void attachFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                                @NonNull Fragment fragment) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.attach(fragment);
        transaction.commit();
    }

    /**
     * The {@code fragment} is hidden to the container view with id {@code frameId}. The operation is
     * performed by the {@code fragmentManager}.
     */
    public static void hideFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                              @NonNull Fragment fragment, String tag) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.hide(fragment);
        transaction.addToBackStack(tag);
        transaction.commit();
    }

    /**
     * The {@code fragment} is showed to the container view with id {@code frameId}. The operation is
     * performed by the {@code fragmentManager}.
     */
    public static void showFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                              @NonNull Fragment fragment, String tag) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.show(fragment);
        transaction.addToBackStack(tag);
        transaction.commit();
    }

    public static void popBackStack(@NonNull FragmentManager fragmentManager,
                                    String tag, int popType) {
        if (tag == null) {
            fragmentManager.popBackStack();
        } else {
            fragmentManager.popBackStack(tag, popType);
            Log.i("BaseActivity", "popBackStack: " + tag);
            Log.i("BaseActivity", "-------------------------------------------------------");
        }
    }
}
