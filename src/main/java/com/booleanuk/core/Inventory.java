package com.booleanuk.core;

import java.util.List;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class Inventory {
  // This is bad, but I don't think it matters, reading from environment variable
  // is a lot more work
  public static final String ACCOUNT_SID = "<some twilio account SID (should get from environment variable)>";
  public static final String AUTH_TOKEN = "<some twilio authentication token (should get from environment variable)>";

  private List<Product> stock;

  public Inventory(List<Product> stock) {
    this.stock = stock;
  }

  public Receipt purchase(Basket basket) throws NotInStockException {
    for (StandaloneProduct product : basket.products())
      for (Product component : product.components())
        this.stock.remove(this.find(component.sku()));

    Receipt receipt = Receipt.makeReceipt(basket.products());
    notifyUser(receipt.toString(), "<some phone number>");

    return receipt;
  }

  private static void notifyUser(String messageContent, String toNumber) {
    final String fromNumber = "<some twilio phone numeber (should get from environment variable)";
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    Message message = Message.creator(new PhoneNumber(toNumber), new PhoneNumber(fromNumber), messageContent)
        .create();

    System.out.println(message.getBody());
  }

  private Product find(Sku sku) throws NotInStockException {
    for (Product product : this.stock)
      if (product.sku() == sku)
        return product;

    throw new NotInStockException(sku);
  }
}
