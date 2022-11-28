package promowarn.version1;

public class PromotionWithDelegateImpl extends PromotionImpl implements PromotionWithDelegate {
    private Student delegate = null;

    public PromotionWithDelegateImpl(final int id) {
        super(id);
    }

    @Override
    public Student delegate() {
        return delegate;
    }

    @Override
    public void chooseDelegate(final Student e) {
        if (students().contains(e)) {
            delegate = e;
        }
    }
}
