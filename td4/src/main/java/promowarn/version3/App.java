package promowarn.version3;


import promowarn.fp.core.Pair;
import promowarn.common.io.*;
import promowarn.common.mail.*;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.BiFunction;

public class App {
    private static final Logger LOGGER = LogManager.getLogger(promowarn.version3.App.class.getName());

    private static String koMessage(final promowarn.version3.Promotion p, final double m) {
        return String.format("promotion %d -- risk (%.2f)", p.id(), m);
    }

    private static String okMessage(final promowarn.version3.Promotion p, final double m) {
        return String.format("promotion %d -- no risk (%.2f)", p.id(), m);
    }




    
  


    //change : optional<double> n= e.grade()
    //regerder sis c'est pa sune boitre vide
    //if(!n.isEmpty()) Sum+= n.get()
    //n++

    //change : optional<double> n= e.grade()
    //regerder sis c'est pa sune boitre vide
    //if(!n.isEmpty()) Sum+= n.get()
    //n++
    private static OptionalDouble average(final Promotion p) {
        return p.students().stream()
                .filter(std -> std!=null)
                .mapToDouble(std -> std.grade())
                .average();
    }

    private static final BiFunction<Promotion, Double, String> bifunc =
            (p, avg) -> avg < 10 ? koMessage(p, avg) : okMessage(p, avg);

    private static String alertTitle(final Promotion p) {
        final OptionalDouble avg = average(p);

    }

    private static EMailAddress delegateEMail(final PromotionWithDelegate p) {
        Optional<Student> delegate = p.delegate();
        if (delegate != null)
            return delegate.email();
        else
            return null;
    }

    private static Pair<EMailCategory, EMail> createEMail(final promowarn.version3.PromotionWithDelegate p) {
        final EMailAddress email = delegateEMail(p);
        final String title = alertTitle(p);
        return new Pair<>(EMailCategory.DRAFT, new EMail(email, title));
    }

    private static void alert(final MailBox box, final Faculty f) {
        for (PromotionWithDelegate p : f.promotions()) {
            final Pair<EMailCategory, EMail> info = createEMail(p);
            box.prepare(info.fst(), info.snd());
        }
    }

    public static void main(final String[] args) {
        final promowarn.version3.DataProvider dao = new DataProvider();
        final EMailService service = new LoggerFakeEMailService(LOGGER);
        final MailBox mailbox = new MailBox(service);
        alert(mailbox, dao.faculty(1));
        LOGGER.info(mailbox);
        mailbox.sendAll();
        LOGGER.info(mailbox);
    }
}
