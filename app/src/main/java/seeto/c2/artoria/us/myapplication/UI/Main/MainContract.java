package seeto.c2.artoria.us.myapplication.UI.Main;

import seeto.c2.artoria.us.myapplication.UI.BaseView;

public interface MainContract {
    interface View extends BaseView{
        void viewpagerinit();
        void navigationinit();
        void fabinit();
        void getuserinfo();
        void showOptionDialog(String context);
        void showIdeasDialog(String context);
        void anmationinit();
        void main_fabclicked();
        void showSearchDialog();
        void showSelectDateDialog();
    }

    interface Presenter{
        void SimpleProfileRequest(String token);
    }
}
