package de.memorian.showcaseview.targets;

import android.app.Activity;
import android.graphics.Point;
import android.view.ViewParent;

import de.memorian.showcaseview.actionbar.ActionBarViewWrapper;
import de.memorian.showcaseview.actionbar.reflection.BaseReflector;

public class ActionItemTarget implements Target {

    private final Activity mActivity;
    private final int mItemId;

    ActionBarViewWrapper mActionBarWrapper;

    public ActionItemTarget(Activity activity, int itemId) {
        mActivity = activity;
        mItemId = itemId;
    }

    @Override
    public Point getPoint() {
        setUp();
        return new ViewTarget(mActionBarWrapper.getActionItem(mItemId)).getPoint();
    }

    protected void setUp() {
        BaseReflector reflector = BaseReflector.getReflectorForActivity(mActivity);
        ViewParent p = reflector.getActionBarView(); //ActionBarView
        mActionBarWrapper = new ActionBarViewWrapper(p);
    }

}
