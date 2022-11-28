package promowarn.common.io;

import org.apache.logging.log4j.Logger;

import promowarn.common.mail.EMail;

/**
 * A LoggerFakeEMailService is a fake EMailService. It "sends" EMails using a
 * Logger.
 */
public class LoggerFakeEMailService implements EMailService {
    private final Logger logger;

    public LoggerFakeEMailService(final Logger logger) {
        this.logger = logger;
    }

    @Override
    public void send(final EMail email) {
        logger.info(() -> String.format("sending mail to %s", email.toAddress()));
    }

}