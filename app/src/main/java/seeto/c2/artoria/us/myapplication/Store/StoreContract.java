package seeto.c2.artoria.us.myapplication.Store;

import seeto.c2.artoria.us.myapplication.BaseView;

public interface StoreContract {
    interface View extends BaseView{
        void tabsinit();

        void listinit();
    }

    interface Presenter{

    }
}
