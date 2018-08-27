package seeto.c2.artoria.us.myapplication.ui.Main;

import seeto.c2.artoria.us.myapplication.ui.BaseView;

public interface MainContract {
    interface View extends BaseView{
        void viewpagerinit();
        void navigationinit();
        void fabinit();
        void showOptionDialog();
        void anmationinit();
        void main_fabclicked();
        void showSearchDialog();
    }

    interface Presenter{

    }
}
