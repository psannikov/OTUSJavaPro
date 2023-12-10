package ru.otus.pro.psannikov.cw13.behavioral_patterns.chain_of_responsibility;

import ru.otus.pro.psannikov.cw13.behavioral_patterns.chain_of_responsibility.data.AuthCtx;
import ru.otus.pro.psannikov.cw13.behavioral_patterns.chain_of_responsibility.data.Realm;
import ru.otus.pro.psannikov.cw13.behavioral_patterns.chain_of_responsibility.data.User;

public class AuthorizationStep extends AuthStep {
    public AuthorizationStep(final AuthStep next) {
        super(next);
    }

    @Override
    public void check(AuthCtx ctx) {
        System.out.println("---------> Authorisation");
        User user = ctx.getUser();
        Realm realm = user.getRealm();
        if (realm.checkResource(ctx.getResource())) {
            ctx.setGranted(true);
            next(ctx);
        }
    }
}
