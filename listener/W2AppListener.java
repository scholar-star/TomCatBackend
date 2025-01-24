package org.zerock.tomproject2.listener;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
@Log4j2
// 이벤트 리스너
public class W2AppListener implements ServletContextListener {
    @Override // 프로젝트 실행 시 초기화
    public void contextInitialized(ServletContextEvent ce) {
        log.info("---------init--------");
        log.info("---------init--------");
        log.info("---------init--------");

        ServletContext sc = ce.getServletContext();
        sc.setAttribute("appName","w2");
    }

    // ServletContext : 현재 웹 애플리케이션 내 공유 자원

    @Override // 프로젝트 종료 시 소멸함수
    public void contextDestroyed(ServletContextEvent ce) {
        log.info("---------destroy--------");
        log.info("---------destroy--------");
        log.info("---------destroy--------");
    }
}
