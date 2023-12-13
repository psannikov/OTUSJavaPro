package ru.otus.pro.psannikov.jetty.handlers.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


public class Multiply extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String arg1 = req.getParameter("arg1");
        String arg2 = req.getParameter("arg2");

        if (arg1 == null || arg2 == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Argument arg1 or arg2 is missing");
            return;
        }

        MultiplyData result = new MultiplyData(Double.valueOf(arg1), Double.valueOf(arg2), null);
        result.setResult(result.getArg1() * result.getArg2());

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(result);

        resp.getWriter().print(json);
    }
}
