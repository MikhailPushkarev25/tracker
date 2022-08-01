package ru.job4j.tracker.search.set;

import java.util.HashSet;
import java.util.List;

public class NotifyAccount {

    public static HashSet<Account> sent(List<Account> accounts) {
        HashSet<Account> rsl = new HashSet<>(accounts);
        for (Account account : rsl) {
            if (rsl.contains(account)) {
                rsl.add(account);
            }
        }
        return rsl;
    }
}
