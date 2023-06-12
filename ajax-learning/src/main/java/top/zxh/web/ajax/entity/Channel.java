package top.zxh.web.ajax.entity;

/**
 * Date:2023/2/26
 * Author：zxh
 * Description:TODO
 */
public class Channel {
    private String code;
    private String name;

    public Channel(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Channel() {

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Channel{" +
               "code='" + code + '\'' +
               ", name='" + name + '\'' +
               '}';
    }
}
