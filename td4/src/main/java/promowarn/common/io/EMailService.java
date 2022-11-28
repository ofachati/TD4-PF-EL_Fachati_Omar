package promowarn.common.io;

import promowarn.common.mail.EMail;

/**
 * An EMailService is anything that can send an EMail. That is, that has a
 * <code>send : EMail -> ()</code> operation. Examples are: a real email sending service,
 * or a logger for demonstration purposes.
 */
public interface EMailService {
    void send(final EMail email);
}
