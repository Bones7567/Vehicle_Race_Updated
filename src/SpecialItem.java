public class SpecialItem {
    private String itemType;
    private int delay;
    private String textColor;


    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemType() {return itemType;}

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public SpecialItem(String itemType, int delay, String textColor){
        this.itemType = itemType;
        this.delay = Math.max(1, delay);
        this.textColor = textColor;
    }
}
