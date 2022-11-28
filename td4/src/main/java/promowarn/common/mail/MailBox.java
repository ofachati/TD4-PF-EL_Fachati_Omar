package promowarn.common.mail;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

import promowarn.common.io.EMailService;

/**
 * A MailBox is a set of EMails regrouped in subdivisions (using EMailCategory).
 * It is parameterized by an EMailFormatter (to format EMails) and an
 * EMailService (to send EMails).
 */
public final class MailBox {

    /**
     * An EMailFormatter is anything that can format an EMail. That is, that has a
     * <code>format : EMail -> String</code> operation.
     */
    public interface EMailFormatter {
        String format(final EMail email);
    }

    /**
     * The default EMailFormatter.
     */
    private static final EMailFormatter defaultEMailFormatter = new EMailFormatter() {
        @Override
        public String format(final EMail email) {
            return String.format("""
                    | mail to:      %s
                    |      subject: %s
                    """, email.toAddress(), email.title());
        }
    };

    private final Map<EMailCategory, List<EMail>> boxes;
    private final EMailService service;
    private final EMailFormatter formatter;

    public MailBox(final EMailService service, final EMailFormatter formatter) {
        this.boxes = new HashMap<>();
        for (EMailCategory cat : EMailCategory.values()) {
            this.boxes.put(cat, new ArrayList<>());
        }
        this.service = service;
        this.formatter = formatter;
    }

    public MailBox(final EMailService service) {
        this(service, defaultEMailFormatter);
    }

    public void prepare(final EMailCategory category, final EMail email) {
        boxes.get(category).add(email);
    }

    public void sendAll() {
        for (EMail email : boxes.get(EMailCategory.DRAFT)) {
            service.send(email);
            boxes.get(EMailCategory.SENT).add(email);
        }
        boxes.get(EMailCategory.DRAFT).clear();
    }

    @Override
    public String toString() {
        StringBuilder rtr = new StringBuilder();
        for (EMailCategory category : EMailCategory.values()) {
            StringBuilder contents = new StringBuilder();
            for (EMail email : boxes.get(category)) {
                contents.append(formatter.format(email));
            }
            rtr.append(String.format("+-- mailbox: %s", category));
            rtr.append(contents.toString());
        }
        return rtr.toString();
    }
}
