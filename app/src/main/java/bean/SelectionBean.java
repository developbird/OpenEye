package bean;

import java.util.List;

/**
 * Created by Administrator on 2016/9/12.
 */
public class SelectionBean {


    private long date;
    private long nextPublishTime;
    private int count;
    private String nextPageUrl;
    private Object dialog;


    private List<SectionListBean> sectionList;

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getNextPublishTime() {
        return nextPublishTime;
    }

    public void setNextPublishTime(long nextPublishTime) {
        this.nextPublishTime = nextPublishTime;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public Object getDialog() {
        return dialog;
    }

    public void setDialog(Object dialog) {
        this.dialog = dialog;
    }

    public List<SectionListBean> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<SectionListBean> sectionList) {
        this.sectionList = sectionList;
    }

    public static class SectionListBean {
        private int id;
        private String type;
        private Object header;
        /**
         * type : forwardFooter
         * data : {"text":"查看往期编辑精选","font":"normal","actionUrl":"eyepetizer://feed/","adTrack":null}
         */

        private FooterBean footer;
        private int count;
        private Object adTrack;
        /**
         * type : banner1
         * data : {"dataType":"Banner","id":120,"title":"","description":"","image":"http://img.kaiyanapp.com/a56b22cb87f667d8ddf73a516ab76e2e.jpeg","actionUrl":"eyepetizer://webview/?title=%E6%9C%89%E6%89%80%E6%84%9F+%E6%9C%89%E6%89%80%E4%B8%BA%E2%80%94%E2%80%94%E8%AE%B0%E5%BD%95%E3%80%8E%E6%84%9F%E8%A7%82%E4%B9%8B%E8%B0%9C%E3%80%8F&url=http%3A%2F%2Fwww.wandoujia.com%2Feyepetizer%2Farticle.html%3Fnid%3D967%26shareable%3Dtrue","adTrack":null,"shade":false}
         */

        private List<ItemListBean> itemList;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Object getHeader() {
            return header;
        }

        public void setHeader(Object header) {
            this.header = header;
        }

        public FooterBean getFooter() {
            return footer;
        }

        public void setFooter(FooterBean footer) {
            this.footer = footer;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public Object getAdTrack() {
            return adTrack;
        }

        public void setAdTrack(Object adTrack) {
            this.adTrack = adTrack;
        }

        public List<ItemListBean> getItemList() {
            return itemList;
        }

        public void setItemList(List<ItemListBean> itemList) {
            this.itemList = itemList;
        }

        public static class FooterBean {
            private String type;
            /**
             * text : 查看往期编辑精选
             * font : normal
             * actionUrl : eyepetizer://feed/
             * adTrack : null
             */

            private DataBean data;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public DataBean getData() {
                return data;
            }

            public void setData(DataBean data) {
                this.data = data;
            }

            public static class DataBean {
                private String text;
                private String font;
                private String actionUrl;
                private Object adTrack;



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

                public Object getAdTrack() {
                    return adTrack;
                }

                public void setAdTrack(Object adTrack) {
                    this.adTrack = adTrack;
                }
            }
        }

        public static class ItemListBean {
            private String type;

            private DataBean data;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public DataBean getData() {
                return data;
            }

            public void setData(DataBean data) {
                this.data = data;
            }

            public static class DataBean {
                private String dataType;
                private int id;
                private String title;
                private String description;
                private String image;
                private String actionUrl;
                private boolean shade;
                private ProviderBean provider;
                private String category;
                private Object author;
                private CoverBean1 cover;
                private String playUrl;
                private int duration;
                private WebUrlBean webUrl;
                private long releaseTime;
                private ConsumptionBean consumption;
                private Object campaign;
                private Object waterMarks;
                private Object adTrack;
                private String type;
                private int idx;
                private Object shareAdTrack;
                private Object favoriteAdTrack;
                private Object webAdTrack;
                private long date;
                private Object promotion;
                private Object label;
                private List<PlayInfoBean> playInfo;
                private List<TagsBean> tags;
                private HeaderBean header;

                public static class HeaderBean{
                    private String cover;
                    private String actionUrl;

                    public String getCover() {
                        return cover;
                    }

                    public void setCover(String cover) {
                        this.cover = cover;
                    }

                    public String getActionUrl() {
                        return actionUrl;
                    }

                    public void setActionUrl(String actionUrl) {
                        this.actionUrl = actionUrl;
                    }
                }

                public HeaderBean getHeaderBean() {
                    return header;
                }

                public void setHeaderBean(HeaderBean headerBean) {
                    this.header = headerBean;
                }

                public String getDataType() {
                    return dataType;
                }

                public void setDataType(String dataType) {
                    this.dataType = dataType;
                }

                public String getCategory() {
                    return category;
                }

                public void setCategory(String category) {
                    this.category = category;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public String getActionUrl() {
                    return actionUrl;
                }

                public void setActionUrl(String actionUrl) {
                    this.actionUrl = actionUrl;
                }

                public boolean isShade() {
                    return shade;
                }

                public void setShade(boolean shade) {
                    this.shade = shade;
                }
                public ProviderBean getProvider() {
                    return provider;
                }

                public void setProvider(ProviderBean provider) {
                    this.provider = provider;
                }
                public static class ProviderBean {
                    private String name;
                    private String alias;
                    private String icon;

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getAlias() {
                        return alias;
                    }

                    public void setAlias(String alias) {
                        this.alias = alias;
                    }

                    public String getIcon() {
                        return icon;
                    }

                    public void setIcon(String icon) {
                        this.icon = icon;
                    }

                }

                public Object getAuthor() {
                    return author;
                }

                public void setAuthor(Object author) {
                    this.author = author;
                }

                public CoverBean1 getCover() {
                    return cover;
                }

                public void setCover(CoverBean1 cover) {
                    this.cover = cover;
                }

                public String getPlayUrl() {
                    return playUrl;
                }

                public void setPlayUrl(String playUrl) {
                    this.playUrl = playUrl;
                }

                public int getDuration() {
                    return duration;
                }

                public void setDuration(int duration) {
                    this.duration = duration;
                }

                public WebUrlBean getWebUrl() {
                    return webUrl;
                }

                public void setWebUrl(WebUrlBean webUrl) {
                    this.webUrl = webUrl;
                }

                public long getReleaseTime() {
                    return releaseTime;
                }

                public void setReleaseTime(long releaseTime) {
                    this.releaseTime = releaseTime;
                }

                public ConsumptionBean getConsumption() {
                    return consumption;
                }

                public void setConsumption(ConsumptionBean consumption) {
                    this.consumption = consumption;
                }

                public Object getCampaign() {
                    return campaign;
                }

                public void setCampaign(Object campaign) {
                    this.campaign = campaign;
                }

                public Object getWaterMarks() {
                    return waterMarks;
                }

                public void setWaterMarks(Object waterMarks) {
                    this.waterMarks = waterMarks;
                }

                public Object getAdTrack() {
                    return adTrack;
                }

                public void setAdTrack(Object adTrack) {
                    this.adTrack = adTrack;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public int getIdx() {
                    return idx;
                }

                public void setIdx(int idx) {
                    this.idx = idx;
                }

                public Object getShareAdTrack() {
                    return shareAdTrack;
                }

                public void setShareAdTrack(Object shareAdTrack) {
                    this.shareAdTrack = shareAdTrack;
                }

                public Object getFavoriteAdTrack() {
                    return favoriteAdTrack;
                }

                public void setFavoriteAdTrack(Object favoriteAdTrack) {
                    this.favoriteAdTrack = favoriteAdTrack;
                }

                public Object getWebAdTrack() {
                    return webAdTrack;
                }

                public void setWebAdTrack(Object webAdTrack) {
                    this.webAdTrack = webAdTrack;
                }

                public long getDate() {
                    return date;
                }

                public void setDate(long date) {
                    this.date = date;
                }

                public Object getPromotion() {
                    return promotion;
                }

                public void setPromotion(Object promotion) {
                    this.promotion = promotion;
                }

                public Object getLabel() {
                    return label;
                }

                public void setLabel(Object label) {
                    this.label = label;
                }

                public List<PlayInfoBean> getPlayInfo() {
                    return playInfo;
                }

                public void setPlayInfo(List<PlayInfoBean> playInfo) {
                    this.playInfo = playInfo;
                }

                public List<TagsBean> getTags() {
                    return tags;
                }

                public void setTags(List<TagsBean> tags) {
                    this.tags = tags;
                }


                public static class CoverBean1 {
                    private String feed;
                    private String detail;
                    private String blurred;
                    private Object sharing;

                    public String getFeed() {
                        return feed;
                    }

                    public void setFeed(String feed) {
                        this.feed = feed;
                    }

                    public String getDetail() {
                        return detail;
                    }

                    public void setDetail(String detail) {
                        this.detail = detail;
                    }

                    public String getBlurred() {
                        return blurred;
                    }

                    public void setBlurred(String blurred) {
                        this.blurred = blurred;
                    }

                    public Object getSharing() {
                        return sharing;
                    }

                    public void setSharing(Object sharing) {
                        this.sharing = sharing;
                    }
                }

                public static class WebUrlBean {
                    private String raw;
                    private String forWeibo;

                    public String getRaw() {
                        return raw;
                    }

                    public void setRaw(String raw) {
                        this.raw = raw;
                    }

                    public String getForWeibo() {
                        return forWeibo;
                    }

                    public void setForWeibo(String forWeibo) {
                        this.forWeibo = forWeibo;
                    }
                }

                public static class ConsumptionBean {
                    private int collectionCount;
                    private int shareCount;
                    private int replyCount;

                    public int getCollectionCount() {
                        return collectionCount;
                    }

                    public void setCollectionCount(int collectionCount) {
                        this.collectionCount = collectionCount;
                    }

                    public int getShareCount() {
                        return shareCount;
                    }

                    public void setShareCount(int shareCount) {
                        this.shareCount = shareCount;
                    }

                    public int getReplyCount() {
                        return replyCount;
                    }

                    public void setReplyCount(int replyCount) {
                        this.replyCount = replyCount;
                    }
                }

                public static class PlayInfoBean {
                    private int height;
                    private int width;
                    private String name;
                    private String type;
                    private String url;

                    public int getHeight() {
                        return height;
                    }

                    public void setHeight(int height) {
                        this.height = height;
                    }

                    public int getWidth() {
                        return width;
                    }

                    public void setWidth(int width) {
                        this.width = width;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }
                }

                public static class TagsBean {
                    private int id;
                    private String name;
                    private String actionUrl;
                    private Object adTrack;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getActionUrl() {
                        return actionUrl;
                    }

                    public void setActionUrl(String actionUrl) {
                        this.actionUrl = actionUrl;
                    }

                    public Object getAdTrack() {
                        return adTrack;
                    }

                    public void setAdTrack(Object adTrack) {
                        this.adTrack = adTrack;
                    }
                }
            }
            }
        }
    }

