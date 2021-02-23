package ru.job4j.accident.repository.interfaces;

import java.util.List;

public interface Rep<T> {
    T add(T t);
    T get(int id);
    List<T> getAll();
}
