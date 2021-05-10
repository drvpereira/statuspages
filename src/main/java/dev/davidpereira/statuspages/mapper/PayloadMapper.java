package dev.davidpereira.statuspages.mapper;

public interface PayloadMapper<T, D> {

    T fromPayload(D o);

    D toPayload(T o);

}
