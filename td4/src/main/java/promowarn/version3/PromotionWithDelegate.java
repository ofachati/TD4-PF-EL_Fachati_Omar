package promowarn.version3;

import java.util.Optional;

public interface PromotionWithDelegate extends Promotion {
    Optional<Student> delegate();

    void chooseDelegate(final Optional<Student> e);
}
