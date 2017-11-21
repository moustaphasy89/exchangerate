package com.makeba.currencyexchange.service.impl;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import com.makeba.currencyexchange.Utils;
import com.makeba.currencyexchange.service.ExchangeApiPersister;

public class ExchangeApiPersisterImpl implements ExchangeApiPersister {

  public void persist(final String apiName) {

    try {
      final String jsonLine = IOUtils.toString(new URL(Utils.readValueFromPropertieFile(Utils.PATH_TO_RATE_FILES, apiName)).openStream(), "UTF-8");
      final String fileName = Utils.PATH_TO_RATE_FILES + "rate_" + apiName + ".json";
      FileUtils.write(new File(fileName), jsonLine, "UTF-8");

    } catch (final MalformedURLException e) {
      // TODO Bloc catch auto-généré
      e.printStackTrace();
    } catch (final IOException e) {
      // TODO Bloc catch auto-généré
      e.printStackTrace();
    }

  }

  public String read(final String fileName) {

    String jsonLine = null;
    try {
      jsonLine = FileUtils.readFileToString(new File(Utils.PATH_TO_RATE_FILES + fileName), Charset.forName("UTF-8"));

    } catch (final MalformedURLException e) {
      // TODO Bloc catch auto-généré
      e.printStackTrace();
    } catch (final IOException e) {
      // TODO Bloc catch auto-généré
      e.printStackTrace();
    }

    return jsonLine;

  }
}
