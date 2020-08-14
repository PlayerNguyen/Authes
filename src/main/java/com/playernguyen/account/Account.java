package com.playernguyen.account;

import java.util.UUID;

public interface Account {

    UUID getUniqueId();

    boolean validate(String password);

    boolean isRegistered();

}
