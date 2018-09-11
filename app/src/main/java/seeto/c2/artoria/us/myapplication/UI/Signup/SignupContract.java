package seeto.c2.artoria.us.myapplication.UI.Signup;

import seeto.c2.artoria.us.myapplication.UI.BaseView;

public interface SignupContract {
    interface View extends BaseView{

    }

    interface Presenter{
        void SignupRequest(String id, String username, String password);
    }
}
