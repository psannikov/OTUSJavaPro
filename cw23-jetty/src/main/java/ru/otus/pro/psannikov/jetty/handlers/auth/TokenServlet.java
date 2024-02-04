package ru.otus.pro.psannikov.jetty.handlers.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;


public class TokenServlet extends HttpServlet {

    TokenService service = new TokenService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HashMap<String, String> parameterMap = new HashMap<>();

        String reqLine = req.getReader().lines().collect(Collectors.joining(""));

        Arrays.stream(reqLine.split("&")).forEach(line -> {
                String[] pair = line.split("=");
                if (pair.length == 2) {
                    parameterMap.put(pair[0], pair[1]);
                }
            }
        );

        Token token = service.getToken(parameterMap.get("login"), parameterMap.get("password"));
        if (token == null) {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN);
        }

        ObjectMapper mapper = new ObjectMapper();
        resp.getWriter().println(mapper.writeValueAsString(token));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getParameter("token");
        if (service.checkToken(token)) {
            resp.setStatus(200);
        } else {
            resp.setStatus(403);
        }
    }
}
