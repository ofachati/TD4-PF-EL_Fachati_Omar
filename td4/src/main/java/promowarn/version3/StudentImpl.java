package promowarn.version3;

import promowarn.common.mail.EMailAddress;

import java.util.Objects;

public class StudentImpl implements Student {
    private final Integer id;
    private final EMailAddress email;
    private Double grade;

    public StudentImpl(final Integer id, final String email) {
        this.id = id;
        this.email = new EMailAddress(email);
        this.grade = null;
    }

    @Override
    public Integer id() {
        return id;
    }

    @Override
    public EMailAddress email() {
        return email;
    }

    //return optional?????          Optional of nullable (graade)

    @Override
    public Double grade() {
        return grade;
    }


    @Override
    public void grade(final double grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final StudentImpl student = (StudentImpl) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
