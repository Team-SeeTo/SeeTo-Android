package seeto.c2.artoria.us.myapplication.UI.Ideas;

import seeto.c2.artoria.us.myapplication.UI.BaseView;

public interface IdeasContract {
    interface View extends BaseView{
        void recyclerdatainit();
        void loadMore();
        void IdeasSearchRequest(String search_string);
    }

    interface Presenter{
        void getListDataRequest(String token, String filterBy, int startRank);
        void SearchRequest(String token, String search_string, String filterBy, int startRank);
        void NewIdeaRequest(String category,String token, String title, String body);
    }
}
