package ru.otus.pro.psannikov.cw13.behavioral_patterns.chain_of_responsibility;

import ru.otus.pro.psannikov.cw13.behavioral_patterns.chain_of_responsibility.data.AuthCtx;
import ru.otus.pro.psannikov.cw13.behavioral_patterns.chain_of_responsibility.data.User;
import ru.otus.pro.psannikov.cw13.behavioral_patterns.chain_of_responsibility.data.UserStorage;

public class GetUserStep extends AuthStep {

    public GetUserStep(final AuthStep next) {
        super(next);
    }

    @Override
    public void check(AuthCtx ctx) {
        System.out.println("---------> Looking for user");
        User user = UserStorage.getUser(ctx.getUserName());
        if (user != null) {
            ctx.setUser(user);
            next(ctx);
        }
    }
}
