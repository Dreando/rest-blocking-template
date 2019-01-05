package org.dreando.jpacascadingplayground.common;

import org.hashids.Hashids;
import org.springframework.stereotype.Component;

@Component
public class IdConverter {

    private final Hashids hashids;

    public IdConverter() {
        hashids = new Hashids("salt-abcde-12345", 5);
    }

    public String encode(long number) {
        return hashids.encode(number);
    }

    public Long decode(String hash) {
        return hashids.decode(hash)[0];
    }
}
