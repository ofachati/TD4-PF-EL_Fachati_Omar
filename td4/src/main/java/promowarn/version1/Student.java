package promowarn.version1;

import promowarn.common.mail.EMailAddress;

public interface Student {
    Integer id();

    EMailAddress email();

    Double grade();

    void grade(final double grade);
}
