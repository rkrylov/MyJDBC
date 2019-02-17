package mate.academy.myJdbc.service;

import mate.academy.myJdbc.model.User;
import mate.academy.myJdbc.web.Request;
import mate.academy.myJdbc.web.ViewModel;

public interface SecurityService {
    ViewModel doLogin(Request request);

    boolean doRegistration(User user);
}
