package promowarn.version3;

import promowarn.version3.Student;

import java.util.Set;

public interface Promotion {
    Integer id();

    Set<Student> students();

    Promotion register(final Student student);
}
