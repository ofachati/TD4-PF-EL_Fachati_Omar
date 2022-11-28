package promowarn.common.mail;

/**
 * An EMailAddress is just the encapsulation of a String.
 */
public final record EMailAddress(String address) {
    @Override
    public String toString() {
        return this.address();
    }
}
