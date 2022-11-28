package promowarn.version1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FacultyImpl implements Faculty {
    private final int id;
    private final List<PromotionWithDelegate> promotions;

    public FacultyImpl(final int id) {
        this.id = id;
        promotions = new ArrayList<>();
    }

    public FacultyImpl(final int id, final Collection<PromotionWithDelegate> promotions) {
        this(id);
        this.promotions.addAll(promotions);
    }

    public FacultyImpl(final int id, final PromotionWithDelegate promotion1, final PromotionWithDelegate... promotions) {
        this(id);
        this.promotions.add(promotion1);
        this.promotions.addAll(Arrays.asList(promotions));
    }

    @Override
    public int id() {
        return id;
    }

    @Override
    public List<PromotionWithDelegate> promotions() {
        return promotions;
    }
}
