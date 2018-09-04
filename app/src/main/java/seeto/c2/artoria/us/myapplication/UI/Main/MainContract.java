package seeto.c2.artoria.us.myapplication.UI.Main;

import seeto.c2.artoria.us.myapplication.UI.BaseView;

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
