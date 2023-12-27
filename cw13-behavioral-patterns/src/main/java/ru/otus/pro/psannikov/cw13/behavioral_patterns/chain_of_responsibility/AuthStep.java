package ru.otus.pro.psannikov.cw13.behavioral_patterns.chain_of_responsibility;

import ru.otus.pro.psannikov.cw13.behavioral_patterns.chain_of_responsibility.data.AuthCtx;

public abstract class AuthStep {

    private final AuthStep next;

    public AuthStep(final AuthStep next) {
        this.next = next;
    }

    public abstract void check(AuthCtx ctx);

    public final void next(AuthCtx ctx) {
        if (next != null) {
            next.check(ctx);
        }
    }
}
