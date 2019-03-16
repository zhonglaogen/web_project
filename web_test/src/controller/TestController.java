package controller;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import service.ITestService;
import service.impl.UserSeriveIMpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class TestController extends HttpServlet {

    @Autowired
    private UserSeriveIMpl userSeriveIMpl;


    @Override
    public void init(ServletConfig config) throws ServletException {
        WebApplicationContext cont = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
        userSeriveIMpl=(UserSeriveIMpl)cont.getBean("userSeriveIMpl");

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        super.doGet(req, resp);
        ServletInputStream inputStream = req.getInputStream();
        int read = inputStream.read();
        System.out.println(read);
        String id = req.getParameter("id");
//        String name = req.getParameter("name");
//        System.out.println(id + "----->" + name);
////        doPost(req, resp);
        try {
            User userByID = userSeriveIMpl.findUserByID(Integer.valueOf(id));
            if (userByID != null) {
                resp.getWriter().print(userByID.getName());
            } else {
                resp.getWriter().print("error");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String age = req.getParameter("age");
        String name = req.getParameter("name");
        User u = new User();
        u.setName(name);
        u.setAge(Integer.valueOf(age));
        try {
            userSeriveIMpl.addUser(u);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
////        System.out.println(id + "------->" + name);
//        resp.getWriter().print("success");
        System.out.println(age + "------>" + name);
//        resp.setCharacterEncoding("UTF-8");
//        resp.getWriter().write(age + "------>" + name);
        HttpSession session=req.getSession();
        session.setAttribute("age",age);
//        req.getRequestDispatcher("/result.jsp").forward(req, resp);
    }
}
