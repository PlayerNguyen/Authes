package com.playernguyen.account;

import com.playernguyen.manager.ManagerList;

import java.util.UUID;

public class SessionManager extends ManagerList<Session> {

    /**
     * Linear search to has session or not
     * @param uuid the uuid to search
     * @return Whether has session or not
     */
    public boolean hasSession(UUID uuid) {
        for (Session session : getContainer()) {
            if (session.getUniqueId().equals(uuid)) {
                return true;
            }
        }
        return false;
    }

}
