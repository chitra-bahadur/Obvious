package com.assignment.obvious.di.component;

import com.assignment.obvious.data.repository.Repository;
import com.assignment.obvious.ui.detail.ImageDetailsFragment;
import com.assignment.obvious.ui.grid.ImageGridFragment;
import com.assignment.obvious.ui.main.MainActivity;

import dagger.Subcomponent;

// @Subcomponent annotation informs Dagger this interface is a Dagger Subcomponent
@Subcomponent
public interface MainComponent {
    //MainActivity get injection from MainComponent it will have MainActivity specific  configuration
    //this removes the responsibility to inject MainActivity from ApplicationComponent class.


    //You also must define a subcomponent factory inside MainComponent so that ApplicationComponent
    // knows how to create instances of MainComponent.
    @Subcomponent.Factory
    interface Factory {
        MainComponent create();
    }

    // This tells Dagger that MainActivity requests injection from MainComponent
    // so that this subcomponent graph needs to satisfy all the dependencies of the
    // fields that MainActivity is injecting
    void inject(MainActivity mainActivity);

    void inject(Repository repository);

    void inject(ImageDetailsFragment imageDetailsFragment);

    void inject(ImageGridFragment imageGridFragment);
}
