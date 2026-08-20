package enums.account;

public enum AccountCurrency {

  USD("USD", 840, 2),
  EUR("EUR", 978, 2),
  CNY("CNY", 156, 2),
  GBP("GBP", 826, 2);

  private final String alphabeticCode;
  private final int numericCode;
  private final int minorUnit;

  AccountCurrency(String alphabeticCode, int numericCode, int minorUnit) {
    this.alphabeticCode = alphabeticCode;
    this.numericCode = numericCode;
    this.minorUnit = minorUnit;
  }

  public String getAlphabeticCode() {
    return alphabeticCode;
  }

  public int getNumericCode() {
    return numericCode;
  }

  public int getMinorUnit() {
    return minorUnit;
  }
}
