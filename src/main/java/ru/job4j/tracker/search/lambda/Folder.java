package ru.job4j.tracker.search.lambda;

import java.util.Objects;

public class Folder {

    private int size;

    private String name;

    public Folder(String name, int size) {
        this.size = size;
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Folder folder = (Folder) o;
        return size == folder.size && Objects.equals(name, folder.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, name);
    }

    @Override
    public String toString() {
        return "Folder{" +
                "size=" + size +
                ", name='" + name + '\'' +
                '}';
    }
}
