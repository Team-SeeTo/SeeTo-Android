package seeto.c2.artoria.us.myapplication.UI.Store;

import seeto.c2.artoria.us.myapplication.UI.BaseView;

public interface StoreContract {
    interface View extends BaseView{
        void tabsinit();

        void listinit();
    }

    interface Presenter{

    }
}
