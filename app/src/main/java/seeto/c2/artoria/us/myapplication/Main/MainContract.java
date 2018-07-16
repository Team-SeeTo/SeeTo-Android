package seeto.c2.artoria.us.myapplication.Main;

import seeto.c2.artoria.us.myapplication.BaseView;

public interface MainContract {
    interface View extends BaseView{
        void viewpagerinit();
        void navigationinit();
        void fabinit();
    }

    interface Presenter{

    }
}
