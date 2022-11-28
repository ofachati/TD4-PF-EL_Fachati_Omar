package promowarn.common.mail;

/**
 * An EMail is a title and an EMailAddress to send the EMail to.
 */
public final record EMail(EMailAddress toAddress, String title) {
}
