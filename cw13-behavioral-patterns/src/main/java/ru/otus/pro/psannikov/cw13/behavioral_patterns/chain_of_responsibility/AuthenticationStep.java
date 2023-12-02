package ru.otus.pro.psannikov.cw13.behavioral_patterns.chain_of_responsibility;


import ru.otus.pro.psannikov.cw13.behavioral_patterns.chain_of_responsibility.data.AuthCtx;
import ru.otus.pro.psannikov.cw13.behavioral_patterns.chain_of_responsibility.data.User;

public class AuthenticationStep extends AuthStep {

    public AuthenticationStep(final AuthStep next) {
        super(next);
    }

    @Override
    public void check(AuthCtx ctx) {
        System.out.println("---------> Authentication");
        User user = ctx.getUser();
        if (user != null && user.getPasswd().equals(ctx.getPassword())) {
            next(ctx);
        }
    }
}
