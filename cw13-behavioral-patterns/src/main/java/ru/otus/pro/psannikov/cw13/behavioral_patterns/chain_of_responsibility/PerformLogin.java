package ru.otus.pro.psannikov.cw13.behavioral_patterns.chain_of_responsibility;

import ru.otus.pro.psannikov.cw13.behavioral_patterns.chain_of_responsibility.data.AuthCtx;
import ru.otus.pro.psannikov.cw13.behavioral_patterns.chain_of_responsibility.data.Resource;

public class PerformLogin {
    public static void main(String[] args) {
        AuthStep authorizationStep = new AuthorizationStep(null);
        AuthStep authenticationStep = new AuthenticationStep(authorizationStep);
        AuthStep getUserStep = new GetUserStep(authenticationStep);


        AuthCtx ctx = new AuthCtx("green", "greenpwd");
        ctx.setResource(new Resource("resource"));

        getUserStep.check(ctx);

        System.out.println(ctx.isGranted());
    }
}
