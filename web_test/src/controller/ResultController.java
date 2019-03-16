package controller;

import com.alibaba.fastjson.JSONArray;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import service.ITestService;
import service.impl.UserSeriveIMpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class  ResultController extends HttpServlet {

    @Autowired
    private UserSeriveIMpl userSeriveIMpl;

    @Override
    public void init(ServletConfig config) throws ServletException {
        WebApplicationContext cont = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
        userSeriveIMpl=(UserSeriveIMpl)cont.getBean("userSeriveIMpl");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object age = req.getSession().getAttribute("age");
        String s = String.valueOf(age);
        System.out.println(userSeriveIMpl);
        //.....
        List<User> userAge = null;
        try {
            userAge = userSeriveIMpl.findByUserAge(Integer.valueOf(s));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        resp.setCharacterEncoding("UTF-8");
        String jsonString = JSONArray.toJSONString(userAge);
        resp.getWriter().write(jsonString);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
