package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by denisizmailov on 20/12/2016.
 */
public class CountMapIml<T> implements CountMap<T> {
    private Map<T, Integer> map = new HashMap<>();

    @Override
    public void add(T o) {
        Integer value = map.get(o);
        if (value != null) map.put(o, value + 1);
        else map.put(o, 1);
    }

    @Override
    public int getCount(T o) {
        return map.get(o);
    }

    @Override
    public int remove(T o) {
        return map.remove(o);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap<T> source) {
        for (Map.Entry<T, Integer> pair :
                source.toMap().entrySet()) {
            Integer value = map.get(pair.getKey());
            if (value != null) map.put(pair.getKey(), value + pair.getValue());
            else map.put(pair.getKey(), pair.getValue());
        }
    }

    @Override
    public Map<T, Integer> toMap() {
        return map;
    }

    @Override
    public void toMap(Map<T, Integer> destination) {
        destination = this.toMap();
    }

}
