package top.zxh.web.ajax.entity;

/**
 * Date:2023/2/26
 * Author：zxh
 * Description:新闻
 */
public class News {
    private Integer id;

    private  String tittle;

    private String date;

    private String source;

    private String content;

    public News() {
    }

    public News(Integer id, String tittle, String date, String source, String content) {
        this.id = id;
        this.tittle = tittle;
        this.date = date;
        this.source = source;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "News{" +
               "id=" + id +
               ", tittle='" + tittle + '\'' +
               ", date='" + date + '\'' +
               ", source='" + source + '\'' +
               ", content='" + content + '\'' +
               '}';
    }
}
