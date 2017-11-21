import java.util.List;

import com.makeba.currencyexchange.model.ExchangeRate;
import com.makeba.currencyexchange.service.ExchangeApiPersister;
import com.makeba.currencyexchange.service.RateParser;
import com.makeba.currencyexchange.service.impl.ExchangeApiPersisterImpl;
import com.makeba.currencyexchange.service.impl.RateOpenExchangeParserImpl;

public class Main {

  public static void main(final String[] args) {
    final ExchangeApiPersister reader = new ExchangeApiPersisterImpl();
    final RateParser parser = new RateOpenExchangeParserImpl();
    //reader.persist("OPENEXCHANGE");
    final List<ExchangeRate> rates = parser.parse(reader.read("rate_OPENEXCHANGE.json"));

    for (final ExchangeRate e : rates) {
      System.out.println(e.getFrom() + " " + e.getTo() + " " + e.getRate() + " " + e.getSource());
    }
  }

}
