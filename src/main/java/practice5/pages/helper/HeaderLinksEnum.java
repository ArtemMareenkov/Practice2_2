package practice5.pages.helper;

/**
 * Created by Serhii on 16-Dec-16.
 */
public enum HeaderLinksEnum {

    DEALS("Deals"),
    SELL("Sell"),
    GIFT_CARDS("Gift Cards");

    private String linkText;

    HeaderLinksEnum(String linkText) {
        this.linkText = linkText;
    }

    public String getLinkText() {
        return linkText;
    }
}
