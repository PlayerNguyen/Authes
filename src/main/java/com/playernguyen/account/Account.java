package com.playernguyen.account;

import java.util.UUID;

public interface Account {

    UUID getUniqueId();

    boolean validPassword(String password);

}
