package seeto.c2.artoria.us.myapplication.UI.Ideas;

import seeto.c2.artoria.us.myapplication.UI.BaseView;

public interface IdeasContract {
    interface View extends BaseView{
        void recyclerdatainit();
        void loadMore();

    }

    interface Presenter{
        void getListDataRequest(String token, String filterBy, String startRank);
    }
}
