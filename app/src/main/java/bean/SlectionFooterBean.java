package bean;

/**
 * Created by Administrator on 2016/9/19.
 */
public class SlectionFooterBean {
    private String type;
    private Data data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data{
        private String text;
        private String font;
        private String actionUrl;
        private String adTrack;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getFont() {
            return font;
        }

        public void setFont(String font) {
            this.font = font;
        }

        public String getActionUrl() {
            return actionUrl;
        }

        public void setActionUrl(String actionUrl) {
            this.actionUrl = actionUrl;
        }

        public String getAdTrack() {
            return adTrack;
        }

        public void setAdTrack(String adTrack) {
            this.adTrack = adTrack;
        }
    }
}
