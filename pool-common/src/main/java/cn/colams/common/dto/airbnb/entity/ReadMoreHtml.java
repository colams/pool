package cn.colams.common.dto.airbnb.entity;

public class ReadMoreHtml {

    private String htmlText;
    private BasicListItem readMoreButton;
    private int recommendedNumberOfLines;

    public String getHtmlText() {
        return htmlText;
    }

    public void setHtmlText(String htmlText) {
        this.htmlText = htmlText;
    }

    public BasicListItem getReadMoreButton() {
        return readMoreButton;
    }

    public void setReadMoreButton(BasicListItem readMoreButton) {
        this.readMoreButton = readMoreButton;
    }

    public int getRecommendedNumberOfLines() {
        return recommendedNumberOfLines;
    }

    public void setRecommendedNumberOfLines(int recommendedNumberOfLines) {
        this.recommendedNumberOfLines = recommendedNumberOfLines;
    }
}
