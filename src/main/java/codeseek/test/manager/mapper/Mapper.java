package codeseek.test.manager.mapper;

public interface Mapper<S, U, V> {
    U toDto(V model);

    V toModel(S dto);
}
