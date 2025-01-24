package org.zerock.tomproject2.listener;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionContext;

@WebListener
@Log4j2
public class LoginListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        // 세션 관련 이벤트 리스너
        String name = event.getName(); // 세션 이름
        Object obj = event.getValue(); // 세션값

        if(name.equals("loginInfo")) { // 로그인 세션이 추가된거라면
            log.info("A user logined....");
            log.info(obj);
        }
    }
}
