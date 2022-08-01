package ru.job4j.tracker.search.map.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {

    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(k -> k.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(r -> r.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }


    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account minus = findByRequisite(srcPassport, srcRequisite);
        Account plus = findByRequisite(destPassport, destRequisite);
        boolean rsl = false;
        if (minus != null && plus != null && minus.getBalance() >= amount && amount > 0) {
            minus.setBalance(minus.getBalance() - amount);
            plus.setBalance(plus.getBalance() + amount);
            rsl = true;
        }

        return rsl;
    }
}
